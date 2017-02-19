package utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by ly on 2017/2/18.
 */

public class IntentHelper {

    public static void startActivity( Activity oriAct,Class desAct){
        Intent intent = new Intent(oriAct,desAct);
        oriAct.startActivity(intent);
    }
}
