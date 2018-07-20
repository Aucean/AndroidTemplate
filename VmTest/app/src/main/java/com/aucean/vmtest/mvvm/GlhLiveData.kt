package com.aucean.vmtest.mvvm

import android.arch.lifecycle.MutableLiveData

abstract class GlhLiveData<B, R>: MutableLiveData<B>() {
    protected abstract fun converter(data: R): B?

    fun onDataReceive(data: R) {
        val bindingData = converter(data)
        if (bindingData != null) {
            value = bindingData
        }
    }
}

class GlhModelLiveData<R>: GlhLiveData<R, R>() {
    override fun converter(data: R): R? {
        return data
    }
}