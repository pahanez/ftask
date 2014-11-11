package famtask.pahanez.com.familytask.data;

import android.content.Context;

import com.pahanez.famtask.data.service.DataProvider;
import com.pahanez.famtask.data.service.GlobalDataService;
import com.pahanez.famtask.data.service.TaskService;
import com.pahanez.famtask.data.service.mock.MockProvider;
import com.pahanez.famtask.data.service.mock.MockTaskService;
import com.pahanez.famtask.domain.service.DataService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pindziukou on 08.11.14.
 */
@Module(library = true , complete = false)
public class DataServiceModule {

    @Provides
    DataProvider provideDataProvider(Context context){
        MockProvider mockProvider = new MockProvider();
        mockProvider.open(context);
        return mockProvider;
    }

    @Provides
    DataService provideTaskService(DataProvider dataProvider){
        return new GlobalDataService(dataProvider);
    }
}
