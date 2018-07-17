package com.gelonghui.xchain.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import com.gelonghui.xchain.dataprovider.IDataProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseViewModel<R, P>(private val apiParams: P): ViewModel() {
    abstract val dataProvider: IDataProvider<P, R>
    var dis: Disposable? = null
    protected fun updateData(reqParams: (p: P)-> Unit, onError: (error: Throwable) -> Unit) {
        reqParams(apiParams)
        dis = dataProvider.getData(apiParams)?.subscribe({data ->
            if (data != null) {
                onDataReceive(data)
            } else {
                onNullData()
            }
        }, {error ->
            onError(error)
        })
    }

    protected fun updateData(reqParams: (p: P)-> Unit) {
        updateData(reqParams) { error: Throwable ->
            
        }
    }

    abstract fun onDataReceive(data: R)

    open fun onNullData(){
    }

    override fun onCleared() {
        super.onCleared()
        dis?.dispose()
    }
}