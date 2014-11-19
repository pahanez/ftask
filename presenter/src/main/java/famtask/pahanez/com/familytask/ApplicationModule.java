package famtask.pahanez.com.familytask;

import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import famtask.pahanez.com.familytask.executor.ExecutorModule;
import famtask.pahanez.com.familytask.view.fragment.MainViewFragment;

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

    @Provides LayoutInflater provideLayoutInflater() { return LayoutInflater.from(mApplication); }

}
