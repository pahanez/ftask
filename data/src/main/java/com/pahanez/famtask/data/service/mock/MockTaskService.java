package com.pahanez.famtask.data.service.mock;

import com.pahanez.famtask.data.enity.TaskEntity;
import com.pahanez.famtask.data.service.TaskService;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by pindziukou on 04.11.14.
 */
public class MockTaskService implements TaskService{
    private MockData mockData;

    public MockTaskService(MockData mockData) {
        this.mockData = mockData;
    }

    @Override
    public TaskEntity createTask(TaskEntity taskEntity) {
        String id = UUID.randomUUID().toString();
        taskEntity.setTaskId(id);
        mockData.tasks.put(taskEntity.getID(),taskEntity);
        return  taskEntity;
    }

    @Override
    public TaskEntity findTask(String id) {
        return mockData.tasks.get(id);
    }

    @Override
    public void removeTask(String id) {
        mockData.tasks.remove(id);
    }

    @Override
    public void updateTask(TaskEntity taskEntity) {
        mockData.tasks.put(taskEntity.getID(),taskEntity);
    }

    @Override
    public Collection<TaskEntity> tasksList() {
        return mockData.tasks.values();
    }
}
