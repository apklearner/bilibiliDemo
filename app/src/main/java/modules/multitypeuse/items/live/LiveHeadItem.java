package modules.multitypeuse.items.live;

/**
 * Created by ly on 2017/3/9.
 */
public class LiveHeadItem {
    public boolean isRecommand;

    public String title;

    public String liveNum;

    public String src;

    public int width;

    public int height;


    public LiveHeadItem(String title, String liveNum) {
        this.title = title;
        this.liveNum = liveNum;
        isRecommand = true;
    }

    public LiveHeadItem(String title, String liveNum, String src, int width, int height) {
        this.title = title;
        this.liveNum = liveNum;
        this.src = src;
        this.width = width;
        this.height = height;
    }
}