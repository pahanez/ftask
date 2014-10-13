package com.pahanez.famtask.domain.interactors;

import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.exception.ErrorBundle;

import java.util.List;

/**
 * Created by pindziukou on 13.10.14.
 */
public interface GetTasksUseCase extends Interactor{

    interface Callback {
        void onTasksLoaded(List<Task> tasks);
        void onError(ErrorBundle errorBundle);
    }

    public void execute(Callback callback);
}
