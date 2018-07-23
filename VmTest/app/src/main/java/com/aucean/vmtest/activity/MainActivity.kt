package com.aucean.vmtest.activity

import com.aucean.vmtest.mvvm.viewmodel.MainViewModel
import android.databinding.DataBindingUtil
import android.arch.lifecycle.ViewModelProviders
import com.aucean.vmtest.databinding.ActivityMainBinding
import android.os.Bundle
import com.aucean.vmtest.R
import android.support.v7.app.AppCompatActivity


/**
 * 所有与UI没关的代码都不应该写在这里，而是在ViewModel，或者抽象到一个Helper里边实现
 */
class MainActivity : AppCompatActivity() {

    internal val mViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    internal lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        mBinding.setLifecycleOwner(this)
        mBinding.bindingModel = mViewModel.bindingModel

        // 获取数据
        // e.g.
        //   mViewModel.getData())
    }
}