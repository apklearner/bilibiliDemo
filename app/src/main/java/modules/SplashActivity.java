package modules;

import android.os.Bundle;
import android.support.annotation.Nullable;

import base.BaseActivity;
import bilibili.demoforbilibili.R;
import modules.home.HomepageActivity;
import utils.IntentHelper;

/**
 * Created by ly on 2017/2/18.
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentHelper.startActivity(this, HomepageActivity.class);
        finish();
    }
}
