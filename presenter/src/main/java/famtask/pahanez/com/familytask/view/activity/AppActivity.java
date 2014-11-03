package famtask.pahanez.com.familytask.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import famtask.pahanez.com.familytask.R;
import famtask.pahanez.com.familytask.view.activity.module.AppActivityModule;
import famtask.pahanez.com.familytask.view.activity.presenter.AppActivityPresenter;
import famtask.pahanez.com.familytask.view.activity.view.AppActivityView;

/**
 * Created by pindziukou on 15.09.14.
 */
public class AppActivity extends BaseActivity implements AppActivityView{

    @Inject
    AppActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onCli(View view){
        mPresenter.loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
        mPresenter.prepareUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.pause();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new AppActivityModule(this));
    }

    @Override
    public void updateUI() {
        getActionBar().setTitle("Custom title in action bar");
    }

    @Override
    public void dataLoaded() {

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
}
