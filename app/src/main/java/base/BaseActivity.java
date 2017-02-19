package base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import bilibili.demoforbilibili.R;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import utils.StatusBarCompat;

/**
 * Created by ly on 2017/2/18.
 */

public abstract class BaseActivity  extends AppCompatActivity{

    protected  void  initToolBar(){};
    protected abstract void initView();
    protected  abstract int getLayoutRes();
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }

        setContentView(getLayoutRes());
        unbinder =  ButterKnife.bind(this);
        initView();
        initToolBar();
        StatusBarCompat.compat(this,getResources().getColor(R.color.colorPrimary));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
