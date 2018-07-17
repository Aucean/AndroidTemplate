package ${packageName}.fragment

import com.gelonghui.glhapp.R
import com.gelonghui.glhapp.activity.BaseAppCompatActivity
import com.gelonghui.glhapp.databinding.Fragment${className}Binding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ${packageName}.uiinterface.I${className}Ui
import ${packageName}.presenter.${className}Presenter



class ${className}Fragment : BaseFragment(), I${className}Ui {

    internal val mPresenter: ${className}Presenter by lazy {
        ${className}Presenter(activity as BaseAppCompatActivity, this)
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


        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


}