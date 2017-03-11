package modules.multitypeuse.items.bangumi;

import modules.multitypeuse.items.base.BaseItems;
import network.entity.HomeBangumiRecEntity;

/**
 * Created by ly on 2017/3/11.
 */
public class BangumiRecommand extends BaseItems{

    public HomeBangumiRecEntity.ResultBean data;


    public BangumiRecommand(HomeBangumiRecEntity.ResultBean data,int position) {
        this.data = data;
        this.position = position;
    }
}