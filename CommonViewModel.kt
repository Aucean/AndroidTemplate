package com.gelonghui.xchain.viewmodel

import android.arch.lifecycle.MutableLiveData

abstract class CommonViewModel<B, R, P>(private val apiParams: P): BaseViewModel<R, P>(apiParams) {
    val liveBindingData:MutableLiveData<B> = MutableLiveData()

    abstract fun converter(data: R): B?

    override fun onDataReceive(data: R) {
        val bindingData = converter(data)
        if (bindingData != null) {
            liveBindingData.value = converter(data)
        }
    }
}