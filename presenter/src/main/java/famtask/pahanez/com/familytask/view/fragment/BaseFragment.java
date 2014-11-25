package famtask.pahanez.com.familytask.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;
import famtask.pahanez.com.familytask.Application;
import famtask.pahanez.com.familytask.view.activity.BaseActivity;
import famtask.pahanez.com.familytask.view.fragment.module.MainViewFragmentModule;

/**
 * Created by pindziukou on 13.11.14.
 */
public abstract class BaseFragment extends Fragment {

    private ObjectGraph mFragmentGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentGraph = ((Application)getActivity().getApplication()).createScopedGraph(getModules().toArray());
        injectDependencies();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFragmentGraph = null;
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    protected abstract int getFragmentLayout();

    protected List<Object> getModules(){
        return Collections.emptyList();
    }

    private void injectDependencies() {
        mFragmentGraph.inject(this);
    }

    private void injectViews(final View view) {
        ButterKnife.inject(this, view);
    }
}
