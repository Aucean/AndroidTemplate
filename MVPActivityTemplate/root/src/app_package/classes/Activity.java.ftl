package ${packageName}.activity;

import ${packageName}.uiinterface.I${className}Ui;
import ${packageName}.presenter.${className}Presenter;
import android.databinding.DataBindingUtil;
import ${packageName}.databinding.Activity${className}Binding;
import android.os.Bundle;
import ${packageName}.R;




public class ${className}Activity extends BaseAppCompatActivity implements I${className}Ui {
 
    ${className}Presenter mPresenter;
    Activity${className}Binding mBinding;

    
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    mBinding = DataBindingUtil.setContentView(this, R.layout.${activityLayoutName});
        initActionBar("")
	
        mPresenter = new ${className}Presenter(this, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stop();
    }

}
