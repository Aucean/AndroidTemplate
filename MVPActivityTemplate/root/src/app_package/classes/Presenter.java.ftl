package ${packageName}.presenter;

import ${packageName}.activity.BaseAppCompatActivity;
import ${packageName}.uiinterface.I${className}Ui;

public class ${className}Presenter extends BasePresenter{
    
    private I${className}Ui mView;
    
    BaseAppCompatActivity mActivity;

    public ${className}Presenter(BaseAppCompatActivity activity, I${className}Ui view) {
        this.mView = view;
        this.mActivity = activity;
    }

    @Override
    public void start() {
        
    }

    @Override
    public void stop() {

    }
}
