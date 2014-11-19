package famtask.pahanez.com.familytask.view.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;


import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;
import famtask.pahanez.com.familytask.Application;

public abstract class BaseActivity extends ActionBarActivity {

    private ObjectGraph mActivityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectViews(this);

        mActivityGraph = ((Application)getApplication()).createScopedGraph(getModules().toArray());
        mActivityGraph.inject(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityGraph = null;
    }

    protected <T> T getView(int id) {
        return (T) findViewById(id);
    }

    public void inject(Object object) {
        mActivityGraph.inject(object);
    }


    protected List<Object> getModules(){
        return Collections.emptyList();
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    private void injectViews(final Activity activity) {
        ButterKnife.inject(this, activity);
    }
}
