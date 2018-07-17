package ${packageName}.activity

import ${packageName}.uiinterface.I${className}Ui
import ${packageName}.presenter.${className}Presenter
import android.databinding.DataBindingUtil
import ${packageName}.databinding.Activity${className}Binding
import android.os.Bundle
import ${packageName}.R

class ${className}Activity : BaseAppCompatActivity(), I${className}Ui {

    internal val mPresenter: ${className}Presenter by lazy {
        ${className}Presenter(this, this)
    }

    internal lateinit var mBinding: Activity${className}Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<Activity${className}Binding>(this, R.layout.${activityLayoutName})
        initActionBar("")
    }

    override fun onStart() {
        super.onStart()
        mPresenter.start()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.stop()
    }

}