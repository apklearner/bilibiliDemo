package modules.multitypeuse.items.banner;

import java.util.List;

import modules.multitypeuse.items.base.BaseItems;
import widget.banner.BannerEntity;

/**
 * Created by ly on 2017/3/9.
 */
public class BannerItem extends BaseItems {

    public List<BannerEntity> dataList;


    public BannerItem(List<BannerEntity> dataList) {
        this.dataList = dataList;
    }
}