/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.pahanez.famtask.data.enity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pahanez.famtask.data.enity.TaskEntity;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * Class used to transform from Strings representing json to valid objects.
 */
public class UserEntityJsonMapper {

  private final Gson gson;

  public UserEntityJsonMapper() {
    this.gson = new Gson();
  }

  /**
   * Transform from valid json string to {@link TaskEntity}.
   *
   * @param taskJsonResponse A json representing a user profile.
   * @return {@link TaskEntity}.
   * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
   */
  public TaskEntity transformTaskEntity(String taskJsonResponse) throws JsonSyntaxException {
    try {
      Type taskEntityType = new TypeToken<TaskEntity>() {}.getType();
      TaskEntity userEntity = this.gson.fromJson(taskJsonResponse, taskEntityType);

      return userEntity;
    } catch (JsonSyntaxException jsonException) {
      throw jsonException;
    }
  }

  /**
   * Transform from valid json string to Collection of {@link TaskEntity}.
   *
   * @param taskListJsonResponse A json representing a collection of users.
   * @return Collection of {@link TaskEntity}.
   * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
   */
  public List<TaskEntity> transformTaskEntityCollection(String taskListJsonResponse)
      throws JsonSyntaxException {

    List<TaskEntity> taskEntityList;
    try {
      Type listOfTaskEntityType = new TypeToken<List<TaskEntity>>() {}.getType();
      taskEntityList = this.gson.fromJson(taskListJsonResponse, listOfTaskEntityType);

      return taskEntityList;
    } catch (JsonSyntaxException jsonException) {
      throw jsonException;
    }
  }
}
