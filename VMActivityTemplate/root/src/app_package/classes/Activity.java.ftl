package ${packageName}.activity;

import ${packageName}.viewmodel.${className}ViewModel;
import android.databinding.DataBindingUtil;
import android.arch.lifecycle.ViewModelProviders;
import ${packageName}.databinding.Activity${className}Binding;
import android.os.Bundle;
import ${packageName}.R;



/**
 * 所有与UI没关的代码都不应该写在这里，而是在ViewModel，或者抽象到一个Helper里边实现
 */
public class ${className}Activity extends BaseAppCompatActivity {
 
    Activity${className}Binding mBinding;
    ${className}ViewModel mViewModel;
    
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    mBinding = DataBindingUtil.setContentView(this, R.layout.${activityLayoutName});

        initActionBar("");

        mBinding.setLifecycleOwner(this);
        mViewModel = ViewModelProviders.of(this).get(${className}ViewModel.class);
        mBinding.setBindingModel(mViewModel.getBindingData());

       // 获取数据
       // e.g.
       //   mViewModel.getData();
    }

}
