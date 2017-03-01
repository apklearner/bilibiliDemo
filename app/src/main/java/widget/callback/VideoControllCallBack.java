package widget.callback;

/**
 * Created by ly on 2017/3/1.
 */

public interface VideoControllCallBack {

    void seekTo(int duration);

    int getCurDuration();

    int getTotalDuration();

}
