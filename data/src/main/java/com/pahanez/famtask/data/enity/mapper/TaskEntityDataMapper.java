/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.pahanez.famtask.data.enity.mapper;

import com.pahanez.famtask.data.enity.TaskEntity;
import com.pahanez.famtask.domain.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Mapper class used to transform {@link TaskEntity} (in the data layer) to {@link Task} in the
 * domain layer.
 */
public class TaskEntityDataMapper {

  /**
   * Transform a {@link TaskEntity} into an {@link Task}.
   *
   * @param taskEntity Object to be transformed.
   * @return {@link Task} if valid {@link TaskEntity} otherwise null.
   */
  public Task transform(TaskEntity taskEntity) {
    Task task = null;
    if (taskEntity != null) {
        task = new Task(taskEntity.getID());
        task.setTaskName(taskEntity.getTaskName());
        task.setAssignedId(taskEntity.getAssignedId());
        task.setAssignedName(taskEntity.getAssignedName());
        task.setTaskId(taskEntity.getID());
        task.setTaskDescription(taskEntity.getTaskDescription());
    }

    return task;
  }

  /**
   * Transform a Collection of {@link TaskEntity} into a Collection of {@link Task}.
   *
   * @param taskEntityCollection Object Collection to be transformed.
   * @return {@link Task} if valid {@link TaskEntity} otherwise null.
   */
  public List<Task> transform(Collection<TaskEntity> taskEntityCollection) {
    List<Task> taskList = new ArrayList<Task>(20);
    Task task = null;
    for (TaskEntity taskEntity : taskEntityCollection) {
      task = transform(taskEntity);
      if (null != task) {
        taskList.add(task);
      }
    }

    return taskList;
  }
}
