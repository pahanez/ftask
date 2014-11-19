package famtask.pahanez.com.familytask.view.fragment.module;

import com.pahanez.famtask.domain.Task;
import com.pahanez.famtask.domain.interactors.GetTasksUseCase;
import com.pedrogomez.renderers.Renderer;

import java.util.LinkedList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import famtask.pahanez.com.familytask.ApplicationModule;
import famtask.pahanez.com.familytask.UseCasesModule;
import famtask.pahanez.com.familytask.view.fragment.MainViewFragment;
import famtask.pahanez.com.familytask.view.fragment.presenter.MainViewFragmentPresenter;
import famtask.pahanez.com.familytask.view.fragment.presenter.MainViewFragmentPresenterImpl;
import famtask.pahanez.com.familytask.view.fragment.view.MainViewFragmentView;
import famtask.pahanez.com.familytask.view.renderer.task.TaskRenderer;
import famtask.pahanez.com.familytask.view.renderer.task.TaskRendererBuilder;

/**
 * Created by pindziukou on 13.11.14.
 */
@Module(injects = {MainViewFragment.class}, addsTo = ApplicationModule.class, includes = {UseCasesModule.class})
public class MainViewFragmentModule {
    private MainViewFragmentView mainViewFragmentView;

    public MainViewFragmentModule(MainViewFragmentView mainViewFragmentView){
        this.mainViewFragmentView = mainViewFragmentView;
    }

    @Provides @Singleton MainViewFragmentPresenter provideMainViewFragmentPresenter(GetTasksUseCase getTasksUseCase){
        return new MainViewFragmentPresenterImpl(mainViewFragmentView,getTasksUseCase);
    }

    @Provides
    TaskRendererBuilder provideTvShowRendererBuilder(TaskRenderer taskRenderer) {
        LinkedList<Renderer<Task>> renderers = new LinkedList<Renderer<Task>>();
        renderers.add(taskRenderer);
        return new TaskRendererBuilder(renderers);
    }
}
