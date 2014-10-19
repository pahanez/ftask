package com.pahanez.famtask.domain.interactors;

import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.exception.ErrorBundle;
import com.pahanez.famtask.domain.executor.PostExecutionThread;
import com.pahanez.famtask.domain.executor.ThreadExecutor;
import com.pahanez.famtask.domain.service.DataService;
import com.pahanez.famtask.domain.utils.MockUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by pindziukou on 13.10.14.
 */
public class GetTasksUseCaseImpl implements GetTasksUseCase{
    private ThreadExecutor threadExecutor;
    private PostExecutionThread postExecutionThread;
    private DataService dataService;
    private Callback callBack;


    public GetTasksUseCaseImpl(DataService dataService, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
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
            callBack.onTasksLoaded(tasks);
        }

        @Override
        public void onError(ErrorBundle error) {
            callBack.onError(error);
        }
    };
}
