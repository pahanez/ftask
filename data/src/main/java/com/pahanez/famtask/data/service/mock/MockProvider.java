package com.pahanez.famtask.data.service.mock;

import android.content.Context;

import com.pahanez.famtask.data.service.DataProvider;
import com.pahanez.famtask.data.service.TaskService;
import com.pahanez.famtask.data.service.UserService;
import static com.pahanez.famtask.data.service.ServiceUtils.assertNotUIThread;

public class MockProvider implements DataProvider {

    private MockData mockData;

    @Override
    public void open(Context context) {
        mockData = new MockData(context);
    }

    @Override
    public void close() {
        mockData = null;
    }

    @Override
    public UserService getUserService() {
        assertNotUIThread();
        return new MockUserService(mockData);
    }

    @Override
    public TaskService getTaskService() {
        assertNotUIThread();
        return new MockTaskService(mockData);
    }
}
