package modules.multitypeuse.items.bangumi;

import modules.multitypeuse.items.base.BaseItems;

/**
 * Created by ly on 2017/3/11.
 */
public class BangumiHeadItem extends BaseItems {

    public String title;

    public String updateCount;

    public int type = 1;

    public boolean isRecommand;

    public static final int BANGUMI_TYPE_1 = 1;

    public static final int BANGUMI_TYPE_2 = 2;

    public static final int BANGUMI_TYPE_3 = 3;


    public BangumiHeadItem(String title, String updateCount) {
        this.title = title;
        this.updateCount = updateCount;

    }

    public BangumiHeadItem(String title, int type,boolean isRecommand) {
        this.title = title;
        this.type = type;
        this.isRecommand = isRecommand;
    }
}