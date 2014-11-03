package famtask.pahanez.com.familytask;

import android.os.Looper;

import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.interactors.GetTasksUseCase;
import com.pahanez.famtask.domain.interactors.GetTasksUseCaseImpl;
import com.pahanez.famtask.domain.service.DataService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import famtask.pahanez.com.familytask.executor.BackThread;
import famtask.pahanez.com.familytask.executor.UIThread;

/**
 * Created by pindziukou on 03.11.14.
 */
@Module(library = true, complete = false)
public class UseCasesModule {
    @Provides GetTasksUseCase provideGetTaskUsecase(BackThread backThread,UIThread uiThread){
        return new GetTasksUseCaseImpl(new DataService() {
            @Override
            public List<Task> getTasksList(TasksLoaderCallback tasksLoaderCallback) {
                android.util.Log.e("p37td8","getTasksList " + Thread.currentThread() + "main looper : " +(Looper.myLooper() == Looper.getMainLooper()));
                tasksLoaderCallback.onTasksLoaded(new ArrayList<Task>());
                return null;

            }
        }, backThread, uiThread);
    }
}
