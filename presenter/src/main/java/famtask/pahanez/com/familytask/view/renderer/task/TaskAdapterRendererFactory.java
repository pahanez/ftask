package famtask.pahanez.com.familytask.view.renderer.task;

import android.view.LayoutInflater;

import com.pahanez.famtask.domain.Task;
import com.pedrogomez.renderers.RendererAdapter;

import javax.inject.Inject;

/**
 * Created by pindziukou on 16.11.14.
 */
public class TaskAdapterRendererFactory {

    private final TaskRendererBuilder rendererBuilder;
    private final LayoutInflater layoutInflater;

    @Inject
    public TaskAdapterRendererFactory(TaskRendererBuilder rendererBuilder,
                                        LayoutInflater layoutInflater) {
        this.rendererBuilder = rendererBuilder;
        this.layoutInflater = layoutInflater;
    }

    public RendererAdapter<Task> getTvShowRendererAdapter(final TaskCollection tvShowCollection) {
        return new RendererAdapter<Task>(layoutInflater, rendererBuilder, tvShowCollection);
    }
}
