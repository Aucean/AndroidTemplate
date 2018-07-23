package ${packageName}.activity;

import ${packageName}.mvvm.viewmodel.${className}ViewModel;
import android.databinding.DataBindingUtil;
import android.arch.lifecycle.ViewModelProviders;
import ${packageName}.databinding.Activity${className}Binding;
import android.os.Bundle;
import ${packageName}.R;
import android.support.v7.app.AppCompatActivity;



/**
 * 所有与UI没关的代码都不应该写在这里，而是在ViewModel，或者抽象到一个Helper里边实现
 */
public class ${className}Activity extends AppCompatActivity {
 
    Activity${className}Binding mBinding;
    ${className}ViewModel mViewModel;
    
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    mBinding = DataBindingUtil.setContentView(this, R.layout.${activityLayoutName});


        mBinding.setLifecycleOwner(this);
        mViewModel = ViewModelProviders.of(this).get(${className}ViewModel.class);
        mBinding.setBindingModel(mViewModel.getBindingData());

       // 获取数据
       // e.g.
       //   mViewModel.getData();
    }

}
