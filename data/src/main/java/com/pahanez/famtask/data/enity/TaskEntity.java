package com.pahanez.famtask.data.enity;

/**
 * Created by pindziukou on 04.11.14.
 */
public class TaskEntity implements IdentifiedEntity{

    private String taskId;
    private String taskDescription;
    private String taskName;
    private String assignedId;
    private String assignedName;

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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(String assignedId) {
        this.assignedId = assignedId;
    }

    public String getAssignedName() {
        return assignedName;
    }

    public void setAssignedName(String assignedName) {
        this.assignedName = assignedName;
    }

    @Override
    public String toString() {
        return "id :"+taskId+", taskName: :" + taskName + " taskDescription: " + taskDescription ;
    }
}
