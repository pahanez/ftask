package com.pahanez.famtask.domain.interactors;

import com.pahanez.famtask.domain.executor.BackgroundExecutionThread;
import com.pahanez.famtask.domain.executor.MainExecutionThread;
import com.pahanez.famtask.domain.service.DataService;

/**
 * Created by pindziukou on 26.11.14.
 */
public class UseCase {
    protected BackgroundExecutionThread threadExecutor;
    protected MainExecutionThread postExecutionThread;
    protected DataService dataService;


    public UseCase(DataService dataService, BackgroundExecutionThread threadExecutor, MainExecutionThread postExecutionThread){
        this.postExecutionThread = postExecutionThread;
        this.threadExecutor = threadExecutor;
        this.dataService = dataService;
    }
}
