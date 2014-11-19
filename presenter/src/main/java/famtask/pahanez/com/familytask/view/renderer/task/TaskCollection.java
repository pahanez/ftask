package famtask.pahanez.com.familytask.view.renderer.task;

import com.pahanez.famtask.domain.Task;
import com.pedrogomez.renderers.AdapteeCollection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pindziukou on 16.11.14.
 */
public class TaskCollection implements AdapteeCollection<Task>,Serializable{

    private static final long serialVersionUID = 8799677673292716638L;

    private final List<Task> tasks;

    public TaskCollection(){
        this(new LinkedList<Task>());
    }

    public TaskCollection(Collection<Task> tasks){
        this.tasks = new LinkedList<Task>(tasks);
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public Task get(int i) {
        return tasks.get(i);
    }

    @Override
    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public void remove(Task task) {
        tasks.remove(task);
    }

    @Override
    public void addAll(Collection<Task> tasks) {
        this.tasks.addAll(tasks);
    }

    @Override
    public void removeAll(Collection<Task> tasks) {
        this.tasks.removeAll(tasks);
    }

    public void clear() {
        this.tasks.clear();
    }

    public List<Task> getAsList() {
        return (List<Task>) ((LinkedList<Task>) tasks).clone();
    }
}
