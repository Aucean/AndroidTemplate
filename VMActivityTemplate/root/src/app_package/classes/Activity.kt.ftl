package ${packageName}.activity

import ${packageName}.viewmodel.${className}ViewModel
import android.databinding.DataBindingUtil
import android.arch.lifecycle.ViewModelProviders
import ${packageName}.databinding.Activity${className}Binding
import android.os.Bundle
import ${packageName}.R

/**
 * 所有与UI没关的代码都不应该写在这里，而是在ViewModel，或者抽象到一个Helper里边实现
 */
class ${className}Activity : BaseAppCompatActivity() {

    internal val mViewModel: ${className}ViewModel by lazy {
        ViewModelProviders.of(this).get(${className}ViewModel::class.java)
    }

    internal lateinit var mBinding: Activity${className}Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<Activity${className}Binding>(this, R.layout.${activityLayoutName})
        initActionBar("")

        mBinding.setLifecycleOwner(this)
        mBinding.bindingModel = mViewModel.bindingModel

       // 获取数据
       // e.g.
       //   mViewModel.getData())
    }
}