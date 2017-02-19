package bilibili.demoforbilibili;

import android.app.Application;

/**
 * Created by ly on 2017/2/19.
 */

public class BaseApplication extends Application{

    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static BaseApplication getInstance(){

        return mInstance;
    }
}
