package famtask.pahanez.com.familytask.view.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import famtask.pahanez.com.familytask.R;
import famtask.pahanez.com.familytask.view.activity.module.AppActivityModule;
import famtask.pahanez.com.familytask.view.activity.presenter.AppActivityPresenter;
import famtask.pahanez.com.familytask.view.activity.view.AppActivityView;
import famtask.pahanez.com.familytask.view.fragment.module.MainViewFragmentModule;

/**
 * Created by pindziukou on 15.09.14.
 */
public class AppActivity extends BaseActivity implements AppActivityView{

    @Inject
    AppActivityPresenter mPresenter;

//    @InjectView(R.id.drawer_lyt) DrawerLayout mDrawerLayout;
//    @InjectView(R.id.navigationdrawer) ListView mDrawerList;
//    @InjectView(R.id.tool_bar) Toolbar mToolBar;

    DrawerLayout mDrawerLayout;
ListView mDrawerList;
Toolbar mToolBar;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.create();

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
    public void createUI() {
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_lyt);
        mDrawerList = (ListView) findViewById(R.id.navigationdrawer);
        mToolBar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.drawable.ic_ab_drawer);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void updateUI() {
        PackageManager manager = this.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(this.getPackageName(), 0);
//            getActionBar().setTitle("FamilyTask DEMO v." + info.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
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
        return this;
    }

    @Override
    public boolean isReady() {
        return false;
    }
}
