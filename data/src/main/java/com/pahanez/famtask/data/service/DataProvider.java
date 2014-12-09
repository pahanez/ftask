package com.pahanez.famtask.data.service;

import android.content.Context;
import android.os.Looper;

/**
 * Created by pindziukou on 04.11.14.
 */
public interface DataProvider {

    void open(Context context);
    void close();
    UserService getUserService();
    TaskService getTaskService();
    GroupService getGroupService();

}
