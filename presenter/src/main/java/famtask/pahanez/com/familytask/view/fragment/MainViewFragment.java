package famtask.pahanez.com.familytask.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.pahanez.famtask.domain.Task;
import com.pedrogomez.renderers.RendererAdapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import famtask.pahanez.com.familytask.R;
import famtask.pahanez.com.familytask.view.fragment.module.MainViewFragmentModule;
import famtask.pahanez.com.familytask.view.fragment.presenter.MainViewFragmentPresenter;
import famtask.pahanez.com.familytask.view.fragment.view.MainViewFragmentView;
import famtask.pahanez.com.familytask.view.renderer.task.TaskAdapterRendererFactory;
import famtask.pahanez.com.familytask.view.renderer.task.TaskCollection;

/**
 * Created by pindziukou on 13.11.14.
 */
public class MainViewFragment extends BaseFragment implements MainViewFragmentView{

    @Inject MainViewFragmentPresenter mPresenter;
    @Inject TaskAdapterRendererFactory mTaskAdapterRendererFactory;

    @InjectView(R.id.main_view_list) ListView mList;

    private TaskCollection mTasks = new TaskCollection();
    private RendererAdapter<Task> adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeListView();
        mPresenter.initialize();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainViewFragmentModule(this));
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.main_view_fragment;
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
        return getActivity();
    }

    @Override
    public boolean isReady() {
        return isAdded();
    }

    @Override
    public void renderTasks(Collection<Task> tasks) {
        mTasks.clear();
        mTasks.addAll(tasks);
        refreshAdapter();
    }

    private void initializeListView() {
        adapter = mTaskAdapterRendererFactory.getTvShowRendererAdapter(mTasks);
        mList.setAdapter(adapter);
    }

    private void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }

}
