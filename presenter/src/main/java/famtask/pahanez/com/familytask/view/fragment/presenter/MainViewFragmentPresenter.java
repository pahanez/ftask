package famtask.pahanez.com.familytask.view.fragment.presenter;

import com.pahanez.famtask.domain.Task;

import java.util.Collection;

import famtask.pahanez.com.familytask.view.Presenter;

/**
 * Created by pindziukou on 13.11.14.
 */
public interface MainViewFragmentPresenter extends Presenter{
    void showTasks(Collection<Task> tasks);
}
