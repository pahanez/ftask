package famtask.pahanez.com.familytask.view.activity.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import famtask.pahanez.com.familytask.Application;
import famtask.pahanez.com.familytask.ApplicationModule;
import famtask.pahanez.com.familytask.view.activity.AppActivity;
import famtask.pahanez.com.familytask.view.activity.presenter.AppActivityPresenter;
import famtask.pahanez.com.familytask.view.activity.presenter.AppActivityPresenterImpl;
import famtask.pahanez.com.familytask.view.activity.view.AppActivityView;

/**
 * Created by pindziukou on 15.09.14.
 */
@Module(injects = {AppActivity.class}, addsTo = ApplicationModule.class )
public class AppActivityModule {

    private AppActivityView mAppActivityView;

    public AppActivityModule(AppActivityView appActivityView){
        this.mAppActivityView = appActivityView;
    }

    @Provides @Singleton public AppActivityView providesView(){
        return mAppActivityView;
    }

    @Provides @Singleton public AppActivityPresenter providePresenter(AppActivityView appActivityView){
        return  new AppActivityPresenterImpl(appActivityView);
    }

}
