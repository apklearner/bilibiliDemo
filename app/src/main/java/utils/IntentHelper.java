package utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import modules.video.VideoDetailActivity;

/**
 * Created by ly on 2017/2/18.
 */

public class IntentHelper {

    public  static final String AV = "av";

    public static void startActivity( Activity oriAct,Class desAct){
        Intent intent = new Intent(oriAct,desAct);
        oriAct.startActivity(intent);
    }

    public static void openVideoDetail(Context context, String av){
        Intent intent = new Intent(context, VideoDetailActivity.class);
        intent.putExtra(AV,av);
        context.startActivity(intent);
    }
}
