package com.aucean.vmtest.mvvm

import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.widget.Toast
import com.aucean.vmtest.R
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.disposables.Disposable

abstract class BaseNetworkProvider<P, D>: ILoadMoreAbleDataProvider<P, D> {
    companion object {
        private const val LOG_TAG = "BaseNetworkProvider"
        const val DEFAULT_LOOP_INTERVAL = 20000L
        val DEFAULT_LOOP_HANDLER = Handler()
    }
    private var liveError: MutableLiveData<Throwable>? = null

    private var dis: Disposable? = null

    private var looperHandler: Handler? = null

    private var loopInterval: Long = 20000

    private val pendingEmitter = HashSet<ObservableEmitter<*>>()

    /**
     * 如果要enable 轮询，必须要注册ErrorHandler
     */
    fun setLooper(handler: Handler? = DEFAULT_LOOP_HANDLER, interval: Long = DEFAULT_LOOP_INTERVAL) {
        // 不管如何，先清掉原有的轮询
        looperHandler = handler
        loopInterval = interval
    }


    override fun getData(params: P): Observable<Optional<D>> {
        return Observable.create({emitter: ObservableEmitter<Optional<D>> ->
            pendingEmitter.add(emitter)
            getDataOnce(params, emitter)
        })
    }

    override fun loadMoreData(params: P): Observable<Optional<D>> {
        val d = getDataFromNetwork(params).glhAsync()
        if (liveError != null) {
            return d.doOnError{ error ->
                        liveError?.value = error
                    }
        } else {
            return d
        }
    }

    private fun getDataOnce(params: P, dataEmitter: ObservableEmitter<Optional<D>>) {
        dis = getDataFromNetwork(params).glhmap().subscribe({data ->
            dataEmitter.onNext(data)
        }, {error ->
            Log.i(LOG_TAG, error.message)
            error.printStackTrace()
            if (liveError == null) {
                pendingEmitter.remove(dataEmitter)
                dataEmitter.onError(error)
            } else {
                liveError?.value = error
                dispatchFinished(params, dataEmitter)
            }
        }, {
            dispatchFinished(params, dataEmitter)
        })
    }

    private fun dispatchFinished(params: P, dataEmitter: ObservableEmitter<Optional<D>>) {
        if (looperHandler != null) {
            looperHandler?.run{
                removeCallbacksAndMessages(null)

                postDelayed({
                    getDataOnce(params, dataEmitter)
                }, loopInterval)
            }
        } else {
            pendingEmitter.remove(dataEmitter)
            dataEmitter.onComplete()
        }
    }

    override fun cancel() {
        dis?.dispose()
        looperHandler?.removeCallbacksAndMessages(null)
        pendingEmitter.forEach { emitter ->
            emitter.onComplete()
        }
    }

    override fun registerErrorHandler(activity: FragmentActivity) {
        if (liveError == null)
            liveError = MutableLiveData()
        else {
            liveError?.removeObservers(activity)
        }
        liveError?.observe(activity, object : android.arch.lifecycle.Observer<Throwable> {
            override fun onChanged(t: Throwable?) {
                t?.run {
                    var msg = activity.getString(R.string.msg_please_check_network)
                    if (t is BusinessException) {
                        msg = if (t.statusCode <= 0) activity.getString(R.string.msg_server_error) else message
                    }
                    Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    protected abstract fun getDataFromNetwork(params: P): Observable<ResponseModel<D>>
}