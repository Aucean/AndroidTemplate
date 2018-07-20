package com.aucean.vmtest.mvvm

import android.os.Handler
import android.support.v4.app.FragmentActivity
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


import java.lang.RuntimeException

/**
 * 定义业务层IO异常，也就是网络请求返回的ResponseModel中的
 * statusCode 不为200
 */
class BusinessException(var statusCode: Int, message: String = "") :RuntimeException(message)

interface Optional<T> {

    fun ifPresent(apply: (T) -> Unit): T?

    fun takeData(hasData: (T) -> Unit, noData: ()->Unit = {})
}

class OptionalImpl<T>(private var value: T? = null): Optional<T> {

    override fun ifPresent(apply: (T) -> Unit): T? {
        return value?.apply {
            apply(this)
        }
    }

    override fun takeData(hasData: (T) -> Unit, noData: ()->Unit) {
        value?.run {
            hasData(this)
        } ?: noData()
    }
}


fun <T> Observable<T>.async(): Observable<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T>  Observable<ResponseModel<T>>.glhmap(): Observable<Optional<T>> {
    // 把业务层的异常路由到onError
    return this.map{ vrm: ResponseModel<T> ->
        if (vrm.statusCode != 200) throw BusinessException(vrm.statusCode, vrm.message ?: "")
        vrm as Optional<T>
    }.subscribeOn(Schedulers.io())
}

fun <T> Observable<ResponseModel<T>>.glhAsync(): Observable<Optional<T>> {
    return this.glhmap().observeOn(AndroidSchedulers.mainThread())
}

interface IDataProvider<P, R> {
    fun getData(params: P): Observable<Optional<R>>
    fun cancel()
    fun registerErrorHandler(activity: FragmentActivity)
}

interface ILoadMoreAbleDataProvider<P, R>: IDataProvider<P, R> {
    fun loadMoreData(params: P): Observable<Optional<R>>
}

open class BaseDataProvider<P, R>(val provider: IDataProvider<P, R>): IDataProvider<P, R> by provider{
    fun getData(param: P,
                liveData: GlhLiveData<*, R>,
                noData: ()->Unit): Observable<Optional<R>>{
        var emitter: ObservableEmitter<Optional<R>>? = null
        val observable = Observable.create<Optional<R>>({e->
            emitter = e
        })
        getData(param).async().subscribe({ optionalData ->
            optionalData.takeData({data->
                liveData.onDataReceive(data)
            },noData)
            emitter?.onNext(optionalData)
        },
                { error ->
                    emitter?.onError(error)
                },
                {
                    emitter?.onComplete()
                },{})
        return observable
    }
}

/**
 * DataProvider的基类，实现了默认的数据获取逻辑 -> 先把本地缓存返回，再加载网络数据并返回
 *
 * 子类要真正需要缓存加载，则应重写getCacheData，
 */
open class BaseDataProviderWithCache<P, R>(provider: IDataProvider<P, R>)
    :BaseDataProvider<P, R>(provider){

    var canTake: Boolean = true
    val handler = Handler()
    // 获取数据入口，先把本地缓存数据发送出去（如果有的话），再从网络请求数据、发送数据
    override fun getData(params: P): Observable<Optional<R>> {
        return Observable.merge(Observable.create { emitter ->
            val data = getCacheData(params)
            data.ifPresent {
                emitter.onNext(data)
            }
            emitter.onComplete()
        }, provider.getData(params).doOnNext { optionalData ->
            if (canTake) {
                optionalData.ifPresent { data ->
                    Schedulers.io().createWorker().schedule {
                        saveData(params, data)
                    }
                }
                // 避免过频的缓存数据
                handler.postDelayed({
                    canTake = true
                }, 2 * 60* 1000)

            }
        }).async()
    }

    // 获取本地缓存数据的空实现，如果DataProvider需要实现缓存的数据的加载，应该重写这函数
    // 实现具体个缓存数据获取
    open fun getCacheData(param: P): Optional<R> {
        return OptionalImpl()
    }

    open fun saveData(param: P, data: R) {
    }
}


