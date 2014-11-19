package famtask.pahanez.com.familytask.view.renderer.task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pahanez.famtask.domain.Task;
import com.pedrogomez.renderers.Renderer;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import famtask.pahanez.com.familytask.R;
import famtask.pahanez.com.familytask.view.fragment.presenter.MainViewFragmentPresenter;

/**
 * Created by pindziukou on 16.11.14.
 */
public class TaskRenderer extends Renderer<Task>{

    @InjectView(R.id.task_row_task_name) TextView mTaskName;
    @InjectView(R.id.task_row_task_description) TextView mTaskDescription;
    @InjectView(R.id.task_row_task_assigned) TextView mTaskAssigned;
    @InjectView(R.id.task_row_img_layout) ImageView mTaskImg;

    private MainViewFragmentPresenter mPresenter;

    @Inject
    public TaskRenderer(MainViewFragmentPresenter presenter){
        mPresenter = presenter;
    }


    @Override
    protected void setUpView(View view) {
        ButterKnife.inject(this, view);
    }

    @Override
    protected void hookListeners(View view) {
        //Empty
    }

    @Override
    protected View inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.task_row, viewGroup, false);
    }

    @Override
    public void render() {
        Task task = getContent();
        renderTaskName(task);
        renderTaskDescription(task);
        renderTaskAssigned(task);
    }


    private void renderTaskName(Task task) {
        String name = task.getTaskName();
        mTaskName.setText(name);
    }

    private void renderTaskDescription(Task task) {
        String description = task.getTaskDescription();
        mTaskDescription.setText(description);
    }

    private void renderTaskAssigned(Task task) {
        String assigned = task.getAssignedName();
        mTaskAssigned.setText(assigned);
    }

    
}
