package makyu.nga.activity;

import android.os.Bundle;

import makyu.nga.R;

/**
 * 引导页.
 * Created by bb on 16/5/23.
 * 该页面负责 账号相关 Splash相关 引导页相关.
 * 管理各种Fragment.
 */
public class GuideActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }

}
