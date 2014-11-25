package famtask.pahanez.com.familytask.view.fragment.module;

import dagger.Module;
import famtask.pahanez.com.familytask.ApplicationModule;
import famtask.pahanez.com.familytask.UseCasesModule;
import famtask.pahanez.com.familytask.view.fragment.AddTaskFragment;
import famtask.pahanez.com.familytask.view.fragment.view.AddTaskFragmentView;

@Module(injects = {AddTaskFragment.class}, addsTo = ApplicationModule.class, includes = {UseCasesModule.class})
public class AddTaskFragmentModule {

    private final AddTaskFragmentView addTaskFragmentView;

    public AddTaskFragmentModule(AddTaskFragmentView addTaskFragmentView){
        this.addTaskFragmentView = addTaskFragmentView;
    }
}
