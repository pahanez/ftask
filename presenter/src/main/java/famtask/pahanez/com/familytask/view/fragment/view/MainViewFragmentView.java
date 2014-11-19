package famtask.pahanez.com.familytask.view.fragment.view;

import com.pahanez.famtask.domain.Task;

import java.util.Collection;

import famtask.pahanez.com.familytask.view.LoadDataView;

/**
 * Created by pindziukou on 13.11.14.
 */
public interface MainViewFragmentView extends LoadDataView{

    void renderTasks(Collection<Task> tasks);
}
