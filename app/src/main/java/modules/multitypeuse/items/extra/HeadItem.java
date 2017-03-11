package modules.multitypeuse.items.extra;

import modules.multitypeuse.items.base.BaseItems;

/**
 * Created by ly on 2017/3/11.
 */
public class HeadItem extends BaseItems{

    public final static int TYPE_ORDER = 1;

    public final static int TYPE_TOPIC = 2;

    public final static int TYPE_COMMON = 3;

    public String title;

    public int type;


    public HeadItem(String title, int type) {
        this.title = title;
        this.type = type;
    }
}