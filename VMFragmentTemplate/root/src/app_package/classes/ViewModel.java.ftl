package ${packageName}.viewmodel;

import ${packageName}.dataprovider.IDataProvider;
import ${packageName}.dataprovider.${className}DataProvider;
import ${packageName}.dataprovider.${className}ApiParams;
import ${packageName}.dataprovider.${className}RawDataModel;
import ${packageName}.models.binding.${className}BindingModel;
import ${packageName}.utils.GlhLiveData;
import android.arch.lifecycle.MutableLiveData;
import org.jetbrains.annotations.NotNull;
import kotlin.Unit;

public class ${className}ViewModel
    extends BaseViewModel
{
    private ${className}DataProvider currentDataProvider = new ${className}DataProvider();


    private GlhLiveData<${className}BindingModel, ${className}RawDataModel> bindingModel =
     new GlhLiveData<${className}BindingModel, ${className}RawDataModel>() {
        public ${className}BindingModel converter(${className}RawDataModel data) {
            // TODO("实现具体业务逻辑")

        }
    };

    public MutableLiveData<${className}BindingModel> getBindingData() {
        return bindingModel;
    }

    public void getData(/*根据需要添加请求参数*/) {
        ${className}ApiParams apiParams = new ${className}ApiParams();
        // apiParams 赋值
        getData(currentDataProvider, apiParams, bindingModel, ()->{ return Unit.INSTANCE;});
    }

}
