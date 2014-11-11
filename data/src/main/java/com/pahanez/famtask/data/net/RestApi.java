package com.pahanez.famtask.data.net;

import com.pahanez.famtask.data.enity.TaskEntity;

import java.util.Collection;

/**
 * Created by pindziukou on 04.11.14.
 */
public interface RestApi {

    interface TaskListCallback {
        void onTaskListLoaded(Collection<TaskEntity> taskEntityCollection);
        void onError(Exception exception);
    }

    static final String API_BASE_URL = "http://www.android10.org/myapi/";
    static final String API_URL_GET_USER_LIST = API_BASE_URL + "users.json";
    static final String API_URL_GET_USER_DETAILS = API_BASE_URL + "user_";

}
