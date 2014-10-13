package com.pahanez.famtask.domain.utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by pindziukou on 13.10.14.
 */
public class MockUtil {

    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
