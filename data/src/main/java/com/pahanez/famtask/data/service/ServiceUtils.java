package com.pahanez.famtask.data.service;

import android.os.Looper;

/**
 * Created by pindziukou on 04.11.14.
 */
public class ServiceUtils {
    public static void assertNotUIThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("Do not use Services in UI Thread");
        }
    }
}
