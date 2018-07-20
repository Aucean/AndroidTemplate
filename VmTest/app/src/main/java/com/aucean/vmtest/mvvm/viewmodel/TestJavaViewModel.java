package com.aucean.vmtest.mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import kotlin.Unit;

import com.aucean.vmtest.mvvm.BaseViewModel;
import com.aucean.vmtest.mvvm.GlhLiveData;
import com.aucean.vmtest.mvvm.dataprovider.TestJavaDataProvider;
import com.aucean.vmtest.mvvm.dataprovider.TestJavaApiParams;
import com.aucean.vmtest.mvvm.dataprovider.TestJavaRawDataModel;
import com.aucean.vmtest.mvvm.bindingmodel.TestJavaBindingModel;



public class TestJavaViewModel
        extends BaseViewModel {
    private TestJavaDataProvider currentDataProvider = new TestJavaDataProvider();


    private GlhLiveData<TestJavaBindingModel, TestJavaRawDataModel> bindingModel =
            new GlhLiveData<TestJavaBindingModel, TestJavaRawDataModel>() {
                public TestJavaBindingModel converter(TestJavaRawDataModel data) {
                    // TODO("实现具体业务逻辑")

                }
            };

    public MutableLiveData<TestJavaBindingModel> getBindingData() {
        return bindingModel;
    }

    public void getData(/*根据需要添加请求参数*/) {
        TestJavaApiParams apiParams = new TestJavaApiParams();
        // apiParams 赋值
        currentDataProvider.getData(apiParams, bindingModel, () -> {
            return Unit.INSTANCE;
        });
    }

}
