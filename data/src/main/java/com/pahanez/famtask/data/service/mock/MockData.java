package com.pahanez.famtask.data.service.mock;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pahanez.famtask.data.R;
import com.pahanez.famtask.data.enity.GroupEntity;
import com.pahanez.famtask.data.enity.TaskEntity;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pindziukou on 04.11.14.
 */
public class MockData {
    private Context context;
    Map<String,TaskEntity> tasks = Collections.synchronizedMap(new HashMap<String, TaskEntity>());
    public MockData(Context context){
        this.context = context;

        loadUserData();
    }

    public MockData(){
    }

    private void loadUserData(){
        Type listTypeTaskEntity = new TypeToken<List<TaskEntity>>() {
        }.getType();

        List<TaskEntity> taskEntityList = new Gson().fromJson(new InputStreamReader(context.getResources().openRawResource(R.raw.mock_tasks)), listTypeTaskEntity);
        for(TaskEntity e : taskEntityList){
            tasks.put(e.getID(), e);
        }
    }
}
