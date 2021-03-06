package makyu.nga.app;

import android.app.Application;

import makyu.nga.http.RequestQueueSingleton;

/**
 * Created by bb on 16/5/23.
 * 项目入口
 */
public class NgaApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initInMainThread();
    }

    private void initInMainThread() {
        RequestQueueSingleton.init(this);
    }
}
