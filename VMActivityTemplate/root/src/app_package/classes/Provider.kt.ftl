package ${packageName}.mvvm.dataprovider

import io.reactivex.Observable
import ${packageName}.mvvm.ResponseModel
import ${packageName}.mvvm.BaseDataProvider
import ${packageName}.mvvm.BaseNetworkProvider

class ${className}DataProvider
    :BaseDataProvider<${className}ApiParams, ${className}RawDataModel>(${className}NetWorkDataProvider()){
    
    protected class ${className}NetWorkDataProvider : BaseNetworkProvider<${className}ApiParams, ${className}RawDataModel>(){
         override fun getDataFromNetwork(params: ${className}ApiParams): Observable<ResponseModel<${className}RawDataModel>> {
            TODO("实现从网络加载数据功能")
            /* e.g.
             *      return HttpHelper.getServer().getExampleData(params.stockType, params.stockCode)
            */
        }
    }
}

class ${className}ApiParams()
/**
 * Api 返回数据Bean对象(网络层数据Bean)
 */
class ${className}RawDataModel(/*根据后台接口设计添加相应字段*/val data: String)