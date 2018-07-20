package com.aucean.vmtest.mvvm.dataprovider

import io.reactivex.Observable
import com.aucean.vmtest.mvvm.ResponseModel
import com.aucean.vmtest.mvvm.BaseDataProvider
import com.aucean.vmtest.mvvm.BaseNetworkProvider

class TestVmodDataProvider
    : BaseDataProvider<TestVmodApiParams, TestVmodRawDataModel>(TestVmodNetWorkDataProvider()) {

    protected class TestVmodNetWorkDataProvider : BaseNetworkProvider<TestVmodApiParams, TestVmodRawDataModel>() {
        override fun getDataFromNetwork(params: TestVmodApiParams): Observable<ResponseModel<TestVmodRawDataModel>> {
            TODO("实现从网络加载数据功能")
            /* e.g.
             *      return HttpHelper.getServer().getExampleData(params.stockType, params.stockCode)
            */
        }
    }
}

class TestVmodApiParams()
/**
 * Api 返回数据Bean对象(网络层数据Bean)
 */
class TestVmodRawDataModel(/*根据后台接口设计添加相应字段*/val data: String)