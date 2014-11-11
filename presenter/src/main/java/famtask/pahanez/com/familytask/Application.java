package famtask.pahanez.com.familytask;

import com.pahanez.famtask.data.service.DataProvider;
import com.pahanez.famtask.domain.service.DataService;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by pindziukou on 19.10.14.
 */
public class Application extends android.app.Application{


    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(getModules().toArray());
    }

    public List<Object> getModules() {
        return Arrays.<Object>asList(new ApplicationModule(this));
    }

    public void inject(Object object){
        mObjectGraph.inject(object);
    }

    public ObjectGraph createScopedGraph(Object... modules) {
        return mObjectGraph.plus(modules);
    }

}
