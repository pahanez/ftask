package com.pahanez.famtask.data.service;

import com.pahanez.famtask.data.enity.TaskEntity;
import com.pahanez.famtask.data.enity.mapper.TaskEntityDataMapper;
import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.exception.ErrorBundle;
import com.pahanez.famtask.domain.service.DataService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by pindziukou on 11.11.14.
 */
public class GlobalDataService implements DataService{

    private DataProvider dataProvider;
    private TaskEntityDataMapper taskEntityDataMapper = new TaskEntityDataMapper();

    public GlobalDataService(DataProvider dataProvider){
        this.dataProvider = dataProvider;
    }

    @Override
    public void getTasksList(TasksLoaderCallback tasksLoaderCallback) {
        //TODO trycatch
        Collection<TaskEntity> entityList = dataProvider.getTaskService().tasksList();
        if(entityList != null && !entityList.isEmpty()){
            tasksLoaderCallback.onTasksLoaded(taskEntityDataMapper.transform(entityList));
        }else{
            tasksLoaderCallback.onError(new ErrorBundle() {
                @Override
                public Exception getException() {
                    return null;
                }

                @Override
                public String getErrorMessage() {
                    return null;
                }
            });
        }
    }
}
