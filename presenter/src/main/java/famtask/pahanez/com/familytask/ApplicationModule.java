package famtask.pahanez.com.familytask;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import famtask.pahanez.com.familytask.executor.ExecutorModule;

@Module(
        library = true,
        includes = {ExecutorModule.class}
)
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application){
        this.mApplication = application;
    }

    @Provides @Singleton Application provideApplication() {
        return mApplication;
    }

    @Provides @Singleton Context provideContext() { return mApplication; }

}
