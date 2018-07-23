package com.aucean.vmtest.mvvm.viewmodel

import com.aucean.vmtest.mvvm.BaseViewModel
import com.aucean.vmtest.mvvm.GlhLiveData
import com.aucean.vmtest.mvvm.dataprovider.MainDataProvider
import com.aucean.vmtest.mvvm.dataprovider.MainApiParams
import com.aucean.vmtest.mvvm.dataprovider.MainRawDataModel
import com.aucean.vmtest.mvvm.bindingmodel.MainBindingModel

class MainViewModel
    : BaseViewModel() {
    private val currentDataProvider = MainDataProvider()

    val bindingModel = object : GlhLiveData<MainBindingModel, MainRawDataModel>() {
        override fun converter(data: MainRawDataModel): MainBindingModel? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    fun getData(/*根据需要添加请求参数*/) {
        currentDataProvider.getData(MainApiParams().apply {
            // 根据实际需要给api 参数赋值
        }, bindingModel, {})
    }

}