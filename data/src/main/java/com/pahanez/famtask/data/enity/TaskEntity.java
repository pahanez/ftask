package com.pahanez.famtask.data.enity;

/**
 * Created by pindziukou on 04.11.14.
 */
public class TaskEntity implements IdentifiedEntity{
    private String taskId;
    private String taskDescription;

    @Override
    public String getID() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
