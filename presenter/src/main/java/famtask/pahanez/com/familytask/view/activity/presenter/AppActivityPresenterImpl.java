package famtask.pahanez.com.familytask.view.activity.presenter;

import famtask.pahanez.com.familytask.Application;
import famtask.pahanez.com.familytask.view.activity.view.AppActivityView;

/**
 * Created by pindziukou on 19.10.14.
 */
public class AppActivityPresenterImpl implements AppActivityPresenter{

    private AppActivityView appActivityView;

    public AppActivityPresenterImpl(AppActivityView appActivityView) {
        this.appActivityView = appActivityView;
    }

    @Override
    public void prepareUI() {
        appActivityView.updateUI();
    }

    @Override
    public void loadData() {

    }
}
