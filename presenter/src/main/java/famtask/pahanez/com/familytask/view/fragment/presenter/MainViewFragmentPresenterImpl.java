package famtask.pahanez.com.familytask.view.fragment.presenter;

import android.os.Looper;

import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.exception.ErrorBundle;
import com.pahanez.famtask.domain.interactors.GetTasksUseCase;

import java.util.Collection;
import java.util.List;

import famtask.pahanez.com.familytask.view.fragment.view.MainViewFragmentView;
import famtask.pahanez.com.familytask.view.renderer.task.TaskCollection;

/**
 * Created by pindziukou on 13.11.14.
 */
public class MainViewFragmentPresenterImpl implements  MainViewFragmentPresenter{

    private final MainViewFragmentView mMainViewFragmentView;
    private final GetTasksUseCase mGetTaskUseCase;

    public MainViewFragmentPresenterImpl(MainViewFragmentView mainViewFragmentView, GetTasksUseCase getTasksUseCase) {
        this.mMainViewFragmentView = mainViewFragmentView;
        this.mGetTaskUseCase = getTasksUseCase;
    }

    @Override
    public void create() {

    }

    @Override
    public void initialize() {
        loadTasks();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    private void loadTasks() {
        mGetTaskUseCase.execute(this.callback);
    }

    @Override
    public void showTasks(Collection<Task> tasks) {
        if (mMainViewFragmentView.isReady()) {
            mMainViewFragmentView.renderTasks(tasks);
            mMainViewFragmentView.hideLoading();
        }
    }

    private GetTasksUseCase.Callback callback = new GetTasksUseCase.Callback() {
        @Override
        public void onTasksLoaded(List<Task> tasks) {
            for(Task task : tasks){
                android.util.Log.e("p37td8" , "task id  " + task.getTaskId() + "  , task descr : " + task.getTaskDescription());
            }

            TaskCollection taskCollection = new TaskCollection(tasks);
            MainViewFragmentPresenterImpl.this.showTasks(tasks);

        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            MainViewFragmentPresenterImpl.this.mMainViewFragmentView.showError(errorBundle.getErrorMessage());
        }
    };

}
