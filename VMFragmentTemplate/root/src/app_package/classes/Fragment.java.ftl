package ${packageName}.fragment;

import ${packageName}.databinding.Fragment${className}Binding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ${packageName}.mvvm.viewmodel.${className}ViewModel;
import android.arch.lifecycle.ViewModelProviders;

/**
 * 所有与UI没关的代码都不应该写在这里，而是在ViewModel，或者抽象到一个Helper里边实现
 */
public class ${className}Fragment extends BaseFragment{

    ${className}ViewModel mViewModel;
    Fragment${className}Binding mBinding;
    

    public ${className}Fragment()
    {
        // Required empty public constructor
    }

    public static ${className}Fragment newInstance() {
        return new ${className}Fragment();
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {

        }
	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mBinding = Fragment${className}Binding.inflate(inflater, container, false);
        mBinding.setLifecycleOwner(this);
        mViewModel = ViewModelProviders.of(this).get(${className}ViewModel.class);
        mBinding.setBindingModel(mViewModel.getBindingData());

    
        return mBinding.getRoot();
    }

        @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // 获取数据
       // e.g.
       //   mViewModel.getData();

    }

}
