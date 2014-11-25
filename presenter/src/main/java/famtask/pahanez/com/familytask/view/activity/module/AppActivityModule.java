package famtask.pahanez.com.familytask.view.activity.module;


import android.support.v4.app.FragmentManager;

import com.pahanez.famtask.domain.interactors.GetTasksUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import famtask.pahanez.com.familytask.Application;
import famtask.pahanez.com.familytask.ApplicationModule;
import famtask.pahanez.com.familytask.UseCasesModule;
import famtask.pahanez.com.familytask.view.Navigator;
import famtask.pahanez.com.familytask.view.activity.AppActivity;
import famtask.pahanez.com.familytask.view.activity.presenter.AppActivityPresenter;
import famtask.pahanez.com.familytask.view.activity.presenter.AppActivityPresenterImpl;
import famtask.pahanez.com.familytask.view.activity.view.AppActivityView;

/**
 * Created by pindziukou on 15.09.14.
 */
@Module(injects = {AppActivity.class}, addsTo = ApplicationModule.class, includes = {UseCasesModule.class},library = true)
public class AppActivityModule {

    private AppActivityView mAppActivityView;
    private FragmentManager mFragmentManager;


    public AppActivityModule(AppActivity appActivity){
        this.mAppActivityView = appActivity;
        this.mFragmentManager = appActivity.getSupportFragmentManager();
    }

    @Provides @Singleton public AppActivityView providesView(){
        return mAppActivityView;
    }
    @Provides @Singleton public FragmentManager providesFragmentManager(){ return mFragmentManager; }

    @Provides @Singleton public AppActivityPresenter providePresenter(AppActivityView appActivityView, GetTasksUseCase getTasksUseCase){
        return  new AppActivityPresenterImpl(appActivityView, getTasksUseCase);
    }
}
