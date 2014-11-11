package famtask.pahanez.com.familytask;

import android.os.Looper;

import com.pahanez.famtask.data.service.DataProvider;
import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.interactors.GetTasksUseCase;
import com.pahanez.famtask.domain.interactors.GetTasksUseCaseImpl;
import com.pahanez.famtask.domain.service.DataService;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import famtask.pahanez.com.familytask.data.DataServiceModule;
import famtask.pahanez.com.familytask.executor.BackThread;
import famtask.pahanez.com.familytask.executor.UIThread;

/**
 * Created by pindziukou on 03.11.14.
 */
@Module(library = true, complete = false, includes = {DataServiceModule.class})
public class UseCasesModule {
    @Provides GetTasksUseCase provideGetTaskUsecase(BackThread backThread,UIThread uiThread,DataService dataService){
        return new GetTasksUseCaseImpl(dataService, backThread, uiThread);
    }
}
