package com.pahanez.famtask.domain.interactors;

import com.pahanez.famtask.domain.Group;
import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.exception.ErrorBundle;

import java.util.List;

/**
 * Created by pindziukou on 26.11.14.
 */
public interface GetGroupUseCase extends Interactor{
    interface Callback {
        void onGroupLoaded(Group group);
        void onError(ErrorBundle errorBundle);
    }

    public void execute(Callback callback);
}
