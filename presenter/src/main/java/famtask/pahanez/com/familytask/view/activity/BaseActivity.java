package famtask.pahanez.com.familytask.view.activity;

import android.app.Activity;
import android.os.Bundle;


import java.util.Collections;
import java.util.List;

import dagger.ObjectGraph;
import famtask.pahanez.com.familytask.Application;

public abstract class BaseActivity extends Activity {

    private ObjectGraph mActivityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
