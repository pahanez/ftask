package com.pahanez.famtask.domain.interactors;

import com.pahanez.famtask.domain.executor.PostExecutionThread;
import com.pahanez.famtask.domain.executor.ThreadExecutor;
import com.pahanez.famtask.domain.utils.MockUtil;

import java.util.concurrent.TimeUnit;

/**
 * Created by pindziukou on 13.10.14.
 */
public class GetTasksUseCaseImpl implements GetTasksUseCase{
    private ThreadExecutor threadExecutor;
    private PostExecutionThread postExecutionThread;


    public GetTasksUseCaseImpl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        this.postExecutionThread = postExecutionThread;
        this.threadExecutor = threadExecutor;
    }

    @Override
    public void execute(Callback callback) {
        threadExecutor.execute(this);
    }

    @Override
    public void run() {
        MockUtil.sleep(3);



    }
}
