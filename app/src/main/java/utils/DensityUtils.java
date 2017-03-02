package utils;

import android.app.Activity;
import android.content.Context;

/**
 * Created by ly on 2017/2/19.
 */

public class DensityUtils {

    public static int Dp2px(Context context,int dipValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int getWindowHieght(Activity activity){
        return activity.getResources().getDisplayMetrics().heightPixels;
    }
    public static int getWindowWidth(Activity activity){
        return activity.getResources().getDisplayMetrics().widthPixels;
    }

}
