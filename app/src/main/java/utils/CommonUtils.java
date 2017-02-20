package utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

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


    public  static Uri getResUri(Context context,int resID){
        Resources res = context.getResources();
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + res.getResourcePackageName(resID) +"/"
         + res.getResourceTypeName(resID) +"/" + res.getResourceEntryName(resID)
        );
        return uri;
    }

}
