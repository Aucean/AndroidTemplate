package ${packageName}.fragment;

import ${packageName}.R;
import ${packageName}.activity.BaseAppCompatActivity;
import ${packageName}.databinding.Fragment${className}Binding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ${packageName}.uiinterface.I${className}Ui;
import ${packageName}.presenter.${className}Presenter;

public final class ${className}Fragment extends BaseFragment implements I${className}Ui{

    ${className}Presenter mPresenter;
    Fragment${className}Binding mBinding;
    

    // Your presenter is available using the mPresenter variable
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

    
        return mBinding.getRoot();
    }

        @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = new ${className}Presenter((BaseAppCompatActivity)getActivity(), this);
    }

}
