package modules.multitypeuse.items.base;

import modules.multitypeuse.items.banner.BannerItem;
import modules.multitypeuse.items.footer.FootItem;
import modules.multitypeuse.items.live.LiveCenterItem;
import modules.multitypeuse.items.live.LiveFooterItem;
import modules.multitypeuse.items.live.LiveHeadItem;
import modules.multitypeuse.items.live.LiveTextItem;
import modules.multitypeuse.items.live.LiveTypeItem;

/**
 * Created by ly on 2017/3/9.
 */

public class ItemTypeValues {
    public final static int VIEW_TYPE_HEADER = 0; //占1
    public final static int VIEW_TYPE_FOOTER = 1; //占1
    public final static int VIEW_TYPE_ITEM_1 = 2; //占1
    public final static int VIEW_TYPE_ITEM_2 = 3; //占1/2
    public final static int VIEW_TYPE_ITEM_3 = 4; //占1/3
    public final static int VIEW_TYPE_ITEM_4 = 5; //占1/4

    public static int getChildTypes(Object o) {

        if (o instanceof BannerItem || o instanceof LiveHeadItem || o instanceof LiveCenterItem || o instanceof FootItem || o instanceof LiveFooterItem) {
            return VIEW_TYPE_ITEM_1;
        }

        if (o instanceof LiveTextItem) {
            return VIEW_TYPE_ITEM_2;
        }

        if (o instanceof LiveTypeItem) {
            return VIEW_TYPE_ITEM_4;
        }
        return 1;
    }

}