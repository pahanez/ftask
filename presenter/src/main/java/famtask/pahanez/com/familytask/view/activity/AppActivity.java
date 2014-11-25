package famtask.pahanez.com.familytask.view.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;
import famtask.pahanez.com.familytask.R;
import famtask.pahanez.com.familytask.libstuff.FloatingActionButton;
import famtask.pahanez.com.familytask.view.Navigator;
import famtask.pahanez.com.familytask.view.activity.module.AppActivityModule;
import famtask.pahanez.com.familytask.view.activity.presenter.AppActivityPresenter;
import famtask.pahanez.com.familytask.view.activity.view.AppActivityView;

/**
 * Created by pindziukou on 15.09.14.
 */
public class AppActivity extends BaseActivity implements AppActivityView{

    @Inject
    AppActivityPresenter mPresenter;
    @Inject
    Navigator mNavigator;


    @InjectView(R.id.drawer_lyt) DrawerLayout mDrawerLayout;
    @InjectView(R.id.navigationdrawer) ListView mDrawerList;
    @InjectView(R.id.tool_bar) Toolbar mToolBar;
    @InjectView(R.id.fabButton) FloatingActionButton mFloatButton;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectViews(this);
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
        mNavigator.openMainViewFragment();

        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.drawable.ic_ab_drawer);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        String [] arrayTypesStr = getResources().getStringArray(R.array.tasks_types);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrayTypesStr);
        mDrawerList.setAdapter(adapter);

        mFloatButton.setDrawableIcon(res.getDrawable(R.drawable.plus));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
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

    @OnClick(R.id.fabButton)
    public void clickFloatButton() {
        android.util.Log.e("p37td8","click float button");
        mNavigator.openCreateNewTaskFragment();

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
