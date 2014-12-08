package com.pahanez.famtask.data.provider;


import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.pahanez.famtask.data.enity.TaskEntity;
import com.pahanez.famtask.data.service.DataProvider;
import com.pahanez.famtask.data.service.mock.MockProvider;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by pindziukou on 08.12.14.
 */
public class TaskServiceTest extends AndroidTestCase{

    private static final int DEFAULT_TASKS_LIST_SIZE = 4;
    private static final String MOCK_TASK_NAME= "new mock task";
    private static final String MOCK_TASK_DESC= "mock task for mock stuff";
    private static final String MOCK_TASK_ASS_ID= "mock assigned id";
    private static final String MOCK_TASK_ASS_NAME= "mock assigned name";

    private static final String MOCK_TASK_NAME_UPDATED= "new updated mock task";

    private DataProvider mDataProvider;
    private String mCreatedTaskId = null;
    @Before
    public void setUp(){
        mDataProvider = new MockProvider();
        mDataProvider.open(mContext);
    }

    @SmallTest
    public void testInitial(){
        List<TaskEntity> tasksList = new ArrayList<TaskEntity>(mDataProvider.getTaskService().tasksList());
        Assert.assertEquals(DEFAULT_TASKS_LIST_SIZE,tasksList.size());

    }

    @SmallTest
    public TaskEntity testCreateTask(){
        TaskEntity mockTask = createTaskEntity();

        int previousSize = mDataProvider.getTaskService().tasksList().size();

        TaskEntity storedMockTask = mDataProvider.getTaskService().createTask(mockTask);

        mCreatedTaskId = storedMockTask.getID();

        Assert.assertNotNull(mCreatedTaskId);

        int currentSize = mDataProvider.getTaskService().tasksList().size();

        Assert.assertEquals(++previousSize, currentSize);

        return storedMockTask;
    }

    @SmallTest
    public void testVerifyTaskInfo(){

        testCreateTask();

        TaskEntity createdTask = mDataProvider.getTaskService().findTask(mCreatedTaskId);

        Assert.assertNotNull(createdTask);

        Assert.assertEquals(createdTask.getTaskName(),MOCK_TASK_NAME);
        Assert.assertEquals(createdTask.getTaskDescription(),MOCK_TASK_DESC);
        Assert.assertEquals(createdTask.getAssignedId(),MOCK_TASK_ASS_ID);
        Assert.assertEquals(createdTask.getAssignedName(),MOCK_TASK_ASS_NAME);

    }

    @SmallTest
    public void testUpdateTask(){
        TaskEntity entity = testCreateTask();

        Assert.assertNotNull(entity);

        entity.setTaskName(MOCK_TASK_NAME_UPDATED);

        mDataProvider.getTaskService().updateTask(entity);


        TaskEntity updatedEntity = mDataProvider.getTaskService().findTask(entity.getID());

        Assert.assertNotNull(updatedEntity);

        Assert.assertEquals(updatedEntity.getTaskName(),MOCK_TASK_NAME_UPDATED);
    }

    @SmallTest
    public void testDeleteTask(){
        testCreateTask();

        TaskEntity entity = mDataProvider.getTaskService().findTask(mCreatedTaskId);
        Assert.assertNotNull(entity);

        mDataProvider.getTaskService().removeTask(entity.getID());
        TaskEntity nullEntity = mDataProvider.getTaskService().findTask(mCreatedTaskId);

        Assert.assertNull(nullEntity);


    }

    private TaskEntity createTaskEntity(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskName(MOCK_TASK_NAME);
        taskEntity.setTaskDescription(MOCK_TASK_DESC);
        taskEntity.setAssignedId(MOCK_TASK_ASS_ID);
        taskEntity.setAssignedName(MOCK_TASK_ASS_NAME);
        return taskEntity;
    }
}
