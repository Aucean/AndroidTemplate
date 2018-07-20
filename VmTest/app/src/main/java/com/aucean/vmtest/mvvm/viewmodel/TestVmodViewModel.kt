package com.aucean.vmtest.viewmodel

import com.aucean.vmtest.mvvm.BaseViewModel
import com.aucean.vmtest.mvvm.GlhLiveData
import com.aucean.vmtest.mvvm.dataprovider.TestVmodDataProvider
import com.aucean.vmtest.mvvm.dataprovider.TestVmodApiParams
import com.aucean.vmtest.mvvm.dataprovider.TestVmodRawDataModel
import com.aucean.vmtest.mvvm.bindingmodel.TestVmodBindingModel

class TestVmodViewModel
    : BaseViewModel() {
    private val currentDataProvider = TestVmodDataProvider()

    val bindingModel = object : GlhLiveData<TestVmodBindingModel, TestVmodRawDataModel>() {
        override fun converter(data: TestVmodRawDataModel): TestVmodBindingModel? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    fun getData(/*根据需要添加请求参数*/) {
        currentDataProvider.getData(TestVmodApiParams().apply {
            // 根据实际需要给api 参数赋值
        }, bindingModel, {})
    }

}