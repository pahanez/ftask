package famtask.pahanez.com.familytask.executor;


import android.os.Handler;
import android.os.Looper;

import com.pahanez.famtask.domain.executor.MainExecutionThread;

import javax.inject.Inject;

/**
 * Created by pindziukou on 19.10.14.
 */
public class UIThread implements MainExecutionThread{
    private Handler mHandler;

    @Inject UIThread(){
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("Runnable to execute cannot be null");
        }
        mHandler.post(runnable);
    }
}
