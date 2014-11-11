package com.pahanez.famtask.data.service.mock;

import com.pahanez.famtask.data.service.UserService;

/**
 * Created by pindziukou on 04.11.14.
 */
public class MockUserService implements UserService{
    private MockData mockData;

    public MockUserService(MockData mockData) {
        this.mockData = mockData;
    }
}
