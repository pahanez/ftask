package famtask.pahanez.com.familytask.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import famtask.pahanez.com.familytask.R;
import famtask.pahanez.com.familytask.view.fragment.module.AddTaskFragmentModule;
import famtask.pahanez.com.familytask.view.fragment.module.MainViewFragmentModule;
import famtask.pahanez.com.familytask.view.fragment.presenter.AddTaskFragmentPresenter;
import famtask.pahanez.com.familytask.view.fragment.view.AddTaskFragmentView;

/**
 * Created by pindziukou on 24.11.14.
 */
public class AddTaskFragment extends BaseFragment implements AddTaskFragmentView{

    @Inject
    AddTaskFragmentPresenter mPresenter;

    @InjectView(R.id.create_task_name)    EditText mTaskNameET;
    @InjectView(R.id.create_task_description) EditText mTaskDescriptionET;
    @InjectView(R.id.create_task_assignee_spinner)    Spinner mAssignedSP;
    @InjectView(R.id.create_task_priority_spinner) Spinner mPrioritySP;

    @Override
    protected int getFragmentLayout() {
        return R.layout.create_task_fragment;
    }


    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new AddTaskFragmentModule(this));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.initialize();
    }

    @Override
    public void setAssigned() {

    }

    @Override
    public void setPriority() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public boolean isReady() {
        return false;
    }
}
