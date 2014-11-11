package com.pahanez.famtask.domain.service;

import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.exception.ErrorBundle;

import java.util.Collection;
import java.util.List;

/**
 * Created by pindziukou on 19.10.14.
 */
public interface DataService {

    void getTasksList(TasksLoaderCallback tasksLoaderCallback);

    interface TasksLoaderCallback{
        void onTasksLoaded(List<Task> tasks);
        void onError(ErrorBundle error);
    }
}
