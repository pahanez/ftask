package famtask.pahanez.com.familytask.view.renderer.task;

import com.pahanez.famtask.domain.Task;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.Collection;

/**
 * Created by pindziukou on 16.11.14.
 */
public class TaskRendererBuilder extends RendererBuilder<Task>{

    public TaskRendererBuilder(Collection<Renderer<Task>> prototypes) {
        super(prototypes);
    }

    @Override
    protected Class getPrototypeClass(Task content) {
        return TaskRenderer.class;
    }
}
