package famtask.pahanez.com.familytask.view.activity.presenter;

import android.os.Looper;

import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.exception.ErrorBundle;
import com.pahanez.famtask.domain.interactors.GetTasksUseCase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import famtask.pahanez.com.familytask.Application;
import famtask.pahanez.com.familytask.view.activity.view.AppActivityView;

/**
 * Created by pindziukou on 19.10.14.
 */
public class AppActivityPresenterImpl implements AppActivityPresenter{

    private AppActivityView appActivityView;
    private GetTasksUseCase getTasksUseCase;

    public AppActivityPresenterImpl(AppActivityView appActivityView, GetTasksUseCase getTasksUseCase) {
        this.appActivityView = appActivityView;
        this.getTasksUseCase = getTasksUseCase;
    }

    @Override
    public void prepareUI() {
        appActivityView.updateUI();
    }

    @Override
    public void loadData() {
        android.util.Log.e("p37td8" , "loadData " + getTasksUseCase);
        getTasksUseCase.execute(new GetTasksUseCase.Callback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                android.util.Log.e("p37td8" , "onTasksLoaded " + getTasksUseCase + " " + Thread.currentThread()+ "main looper : " +(Looper.myLooper() == Looper.getMainLooper()));
                for(Task task : tasks){
                    android.util.Log.e("p37td8" , "task id  " + task.getTaskId() + "  , task descr : " + task.getTaskDescription());
                }
            }

            @Override
            public void onError(ErrorBundle errorBundle) {
                android.util.Log.e("p37td8" , "onError " + getTasksUseCase);
            }
        });
    }

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
