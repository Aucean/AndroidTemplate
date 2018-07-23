package ${packageName}.fragment

import ${packageName}.databinding.Fragment${className}Binding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ${packageName}.mvvm.viewmodel.${className}ViewModel
import android.arch.lifecycle.ViewModelProviders


/**
 * 所有与UI没关的代码都不应该写在这里，而是在ViewModel，或者抽象到一个Helper里边实现
 */
class ${className}Fragment : BaseFragment(){

    internal val mViewModel: ${className}ViewModel by lazy {
        ViewModelProviders.of(this).get(${className}ViewModel::class.java)
    }

    internal lateinit var mBinding: Fragment${className}Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null)
        {

        }
    }

    companion object {

        @JvmStatic  fun newInstance(): ${className}Fragment {
            return ${className}Fragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = Fragment${className}Binding.inflate(inflater, container, false)
        mBinding.setLifecycleOwner(this)
        mBinding.bindingModel = mViewModel.liveBindingData

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       // 获取数据
       // e.g.
       //   mViewModel.getData())

    }


}