package com.pahanez.famtask.data.service;

import com.pahanez.famtask.data.enity.TaskEntity;

import java.util.Collection;
import java.util.List;

/**
 * Created by pindziukou on 04.11.14.
 */
public interface TaskService {
    TaskEntity createTask(TaskEntity taskEntity);
    void removeTask(String id);
    void updateTask(TaskEntity taskEntity);
    Collection<TaskEntity> tasksList();
}
