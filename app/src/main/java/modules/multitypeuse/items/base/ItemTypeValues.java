package modules.multitypeuse.items.base;

import modules.multitypeuse.items.bangumi.BangumiComplete;
import modules.multitypeuse.items.bangumi.BangumiHeadItem;
import modules.multitypeuse.items.bangumi.BangumiRecommand;
import modules.multitypeuse.items.bangumi.BangumiType;
import modules.multitypeuse.items.bangumi.BangumiUpdate;
import modules.multitypeuse.items.banner.BannerItem;
import modules.multitypeuse.items.extra.FootItem;
import modules.multitypeuse.items.extra.FootMoreItem;
import modules.multitypeuse.items.extra.HeadItem;
import modules.multitypeuse.items.live.LiveCenterItem;
import modules.multitypeuse.items.live.LiveHeadItem;
import modules.multitypeuse.items.live.LiveTextItem;
import modules.multitypeuse.items.live.LiveTypeItem;
import modules.multitypeuse.items.recommand.RecBangumiFoot;
import modules.multitypeuse.items.recommand.RecHotitem;
import modules.multitypeuse.items.recommand.RecTopicItem;
import modules.multitypeuse.items.video.VideoHeadItem;
import modules.multitypeuse.items.video.VideoMainItem;

/**
 * Created by ly on 2017/3/9.
 */

public class ItemTypeValues {
    public final static int VIEW_TYPE_BANNER = 0;
    public final static int VIEW_TYPE_HEADER = 1; //占1
    public final static int VIEW_TYPE_FOOTER = 2; //占1
    public final static int VIEW_TYPE_ITEM_1 = 3; //占1
    public final static int VIEW_TYPE_ITEM_1_1 = 4;//占1，但值穿插一个
    public final static int VIEW_TYPE_ITEM_2 = 5; //占1/2
    public final static int VIEW_TYPE_ITEM_3 = 6; //占1/3
    public final static int VIEW_TYPE_ITEM_4 = 7; //占1/4

    public static int getChildTypes(Object o) {

        if(o instanceof BannerItem )
            return VIEW_TYPE_BANNER;

        if(o instanceof LiveHeadItem ||o instanceof BangumiHeadItem || o instanceof LiveCenterItem || o instanceof BangumiType || o instanceof HeadItem || o instanceof VideoHeadItem)
            return VIEW_TYPE_HEADER;

        if(o instanceof FootMoreItem || o instanceof FootItem || o instanceof RecBangumiFoot)
            return VIEW_TYPE_FOOTER;

        if ( o instanceof LiveCenterItem  || o instanceof BangumiType ||
                o instanceof BangumiRecommand || o instanceof VideoMainItem) {
            return VIEW_TYPE_ITEM_1;
        }

        if(o instanceof RecTopicItem ){
            return VIEW_TYPE_ITEM_1_1;
        }

        if (o instanceof LiveTextItem || o instanceof BangumiUpdate || o instanceof RecHotitem) {
            return VIEW_TYPE_ITEM_2;
        }

        if(o instanceof BangumiComplete){
            return VIEW_TYPE_ITEM_3;
        }

        if (o instanceof LiveTypeItem) {
            return VIEW_TYPE_ITEM_4;
        }
        return 1;
    }

}