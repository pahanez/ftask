package com.pahanez.famtask.domain.interactors;

import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.exception.ErrorBundle;
import com.pahanez.famtask.domain.executor.BackgroundExecutionThread;
import com.pahanez.famtask.domain.executor.MainExecutionThread;
import com.pahanez.famtask.domain.service.DataService;
import com.pahanez.famtask.domain.utils.MockUtil;

import java.util.List;

/**
 * Created by pindziukou on 13.10.14.
 */
public class GetTasksUseCaseImpl implements GetTasksUseCase{
    private BackgroundExecutionThread threadExecutor;
    private MainExecutionThread postExecutionThread;
    private DataService dataService;
    private Callback callBack;


    public GetTasksUseCaseImpl(DataService dataService, BackgroundExecutionThread threadExecutor, MainExecutionThread postExecutionThread){
        this.postExecutionThread = postExecutionThread;
        this.threadExecutor = threadExecutor;
        this.dataService = dataService;
    }

    @Override
    public void execute(Callback callback) {
        this.callBack = callback;
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        MockUtil.sleep(3); //TODO remove

        this.dataService.getTasksList(tasksLoaderCallback);
    }

    DataService.TasksLoaderCallback tasksLoaderCallback = new DataService.TasksLoaderCallback() {
        @Override
        public void onTasksLoaded(List<Task> tasks) {
            postResult(tasks);
        }

        @Override
        public void onError(ErrorBundle error) {
            postError(error);
        }
    };

    private void postResult(final List<Task> tasks){
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callBack.onTasksLoaded(tasks);
            }
        });
    }


    private  void postError(final ErrorBundle error){
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callBack.onError(error);
            }
        });
    }
}
