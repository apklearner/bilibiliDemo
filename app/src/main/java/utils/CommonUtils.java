package utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ly on 2017/2/19.
 */

public class CommonUtils {

    public  static  boolean isNetWorkAvialable(Context context){

        NetworkInfo networkInfo = getNetWorkInfo(context);
        if(networkInfo.isAvailable()) return true;

        return false;
    }

    private static NetworkInfo getNetWorkInfo(Context context){

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();

    }

}
