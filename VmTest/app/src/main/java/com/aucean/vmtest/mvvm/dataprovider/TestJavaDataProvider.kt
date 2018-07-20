package com.aucean.vmtest.mvvm.dataprovider

import io.reactivex.Observable
import com.aucean.vmtest.mvvm.ResponseModel
import com.aucean.vmtest.mvvm.BaseDataProvider
import com.aucean.vmtest.mvvm.BaseNetworkProvider

class TestJavaDataProvider
    : BaseDataProvider<TestJavaApiParams, TestJavaRawDataModel>(TestJavaNetWorkDataProvider()) {

    protected class TestJavaNetWorkDataProvider : BaseNetworkProvider<TestJavaApiParams, TestJavaRawDataModel>() {
        override fun getDataFromNetwork(params: TestJavaApiParams): Observable<V2ResponseModel<TestJavaRawDataModel>> {
            TODO("实现从网络加载数据功能")
            /* e.g.
             *      return HttpHelper.getServer().getExampleData(params.stockType, params.stockCode)
            */
        }
    }
}

class TestJavaApiParams()
/**
 * Api 返回数据Bean对象(网络层数据Bean)
 */
class TestJavaRawDataModel(/*根据后台接口设计添加相应字段*/val data: String)