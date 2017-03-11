package modules.multitypeuse.items.extra;

import modules.multitypeuse.items.base.BaseItems;

/**
 * Created by ly on 2017/3/11.
 */
public class FootItem extends BaseItems{

    public final static int TYPE_ON_CHANGE = 1;

    public final static int TYPE_ON_COMMON = 2;

    public int type;


    public FootItem(int type) {
        this.type = type;
    }
}