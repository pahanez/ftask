package com.pahanez.famtask.domain;

/**
 * Created by pindziukou on 13.10.14.
 */
public class Task {
    private String taskId;
    private String taskDescription;

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

}
