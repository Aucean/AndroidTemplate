package ${packageName}.mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import kotlin.Unit;

import ${packageName}.mvvm.BaseViewModel;
import ${packageName}.mvvm.GlhLiveData;
import ${packageName}.mvvm.dataprovider.${className}DataProvider;
import ${packageName}.mvvm.dataprovider.${className}ApiParams;
import ${packageName}.mvvm.dataprovider.${className}RawDataModel;
import ${packageName}.mvvm.bindingmodel.${className}BindingModel;


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
        currentDataProvider.getData(apiParams, bindingModel, ()->{ return Unit.INSTANCE;});
    }

}
