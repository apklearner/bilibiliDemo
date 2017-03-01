package utils;

/**
 * Created by ly on 2017/2/27.
 */

public class DurationUtils {

    public static String calculateTime(int duration){
        String time = "%02d:%02d";
        int minutes = (int) (duration/60);
        int seconds = (int) (duration%60);
        return   String.format(time,minutes,seconds);
    }
}
