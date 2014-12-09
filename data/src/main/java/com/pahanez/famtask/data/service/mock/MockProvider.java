package com.pahanez.famtask.data.service.mock;

import android.content.Context;

import com.pahanez.famtask.data.service.DataProvider;
import com.pahanez.famtask.data.service.GroupService;
import com.pahanez.famtask.data.service.TaskService;
import com.pahanez.famtask.data.service.UserService;
import static com.pahanez.famtask.data.service.ServiceUtils.assertNotUIThread;

public class MockProvider implements DataProvider {

    private MockData mMockData = new MockData();

    private GroupService mGroupService;

    @Override
    public void open(Context context) {
        mMockData = new MockData(context);
    }

    @Override
    public void close() {
        mMockData = null;
    }

    @Override
    public UserService getUserService() {
        assertNotUIThread();
        return new MockUserService(mMockData);
    }

    @Override
    public TaskService getTaskService() {
        assertNotUIThread();
        return new MockTaskService(mMockData);
    }

    @Override
    public synchronized GroupService getGroupService() {
        if(mGroupService == null)
            mGroupService = new MockGroupService();
        return mGroupService;
    }
}
