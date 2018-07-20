package com.aucean.viewmodel

import android.arch.lifecycle.ViewModel
import com.gelonghui.xchain.dataprovider.BaseDataProvider
import com.gelonghui.xchain.utils.GlhLiveData
import com.gelonghui.xchain.dataprovider.IDataProvider
import com.gelonghui.xchain.utils.Optional
import io.reactivex.Observable

class BaseViewModel(): ViewModel() {
    protected val providerList = ArrayList<IDataProvider<*,*>>()

    override fun onCleared() {
        super.onCleared()
        providerList.forEach { provider->
            provider.cancel()
        }
    }
}