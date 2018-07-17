package ${packageName}.viewmodel

import ${packageName}.dataprovider.IDataProvider
import ${packageName}.dataprovider.${className}DataProvider
import ${packageName}.dataprovider.${className}ApiParams
import ${packageName}.dataprovider.${className}RawDataModel
import ${packageName}.utils.GlhLiveData
import ${packageName}.models.binding.${className}BindingModel
class ${className}ViewModel
    : BaseViewModel()
{
    private val currentDataProvider = ${className}DataProvider()

    val bindingModel = object :GlhLiveData<${className}BindingModel, ${className}RawDataModel>(){
        override fun converter(data: ${className}RawDataModel): ${className}BindingModel? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    fun getData(/*根据需要添加请求参数*/) {
        getData(currentDataProvider, ${className}ApiParams().apply{
            // 根据实际需要给api 参数赋值
        }, bindingModel, {})
    }

}