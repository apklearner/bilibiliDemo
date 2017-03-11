package modules.multitypeuse.items.live;

import modules.multitypeuse.items.base.BaseItems;

/**
 * Created by ly on 2017/3/9.
 */
public class LiveTypeItem extends BaseItems {

    public String title;

    public String src;

    public int width;

    public int height;


    public LiveTypeItem(String title, String src) {
        this.title = title;
        this.src = src;
    }

    public LiveTypeItem(String title, String src, int width, int height) {
        this.title = title;
        this.src = src;
        this.width = width;
        this.height = height;
    }
}