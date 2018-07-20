package com.aucean.vmtest.mvvm

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable

open class BaseViewModel(): ViewModel() {
    protected val providerList = ArrayList<IDataProvider<*,*>>()

    override fun onCleared() {
        super.onCleared()
        providerList.forEach { provider->
            provider.cancel()
        }
    }
}