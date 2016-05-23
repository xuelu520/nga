package makyu.nga.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import makyu.nga.R;
import makyu.nga.constant.HttpConstant;

/**
 * 引导页.
 * Created by bb on 16/5/23.
 * 该页面负责 账号相关 Splash相关 引导页相关.
 * 管理各种Fragment.
 */
public class GuideActivity extends BaseActivity {
    static Boolean openTest = true; //是否开启测试
    final String TAG = "GuideActivity";

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // UI界面的更新等相关操作
        }
    };

    /**
     * 网络操作相关的子线程
     */
    Runnable networkTask = new Runnable() {

        @Override
        public void run() {
            // 在这里进行 http request.网络请求相关操作
            unitTest();
            Message msg = new Message();
            handler.sendMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        new Thread(networkTask).start();
    }

    private void unitTest() {
        if(!openTest) {
            return;
        }
        String url = "http://bbs.nga.cn/thread.php?fid=335&lite=js";
        try {

            Log.e(TAG, HttpConstant.get(url).toString());
            Log.e(TAG, HttpConstant.get(url).body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
