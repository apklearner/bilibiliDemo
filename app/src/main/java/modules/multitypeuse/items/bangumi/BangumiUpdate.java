package modules.multitypeuse.items.bangumi;

import modules.multitypeuse.items.base.BaseItems;
import network.entity.HomeBangumiMainEntity;
import network.entity.HomeRecContentEntity;

/**
 * Created by ly on 2017/3/11.
 */
public class BangumiUpdate extends BaseItems{

   public HomeBangumiMainEntity.ResultBean.LatestUpdateBean.ListBean data;

   public HomeRecContentEntity.ResultBean.BodyBean data2;


    public boolean isRecommand;


    public BangumiUpdate(HomeBangumiMainEntity.ResultBean.LatestUpdateBean.ListBean data,int position) {
        this.data = data;
        this.position = position;
    }

    public BangumiUpdate(HomeRecContentEntity.ResultBean.BodyBean data2,int position) {
        isRecommand = true;
        this.position  = position;
        this.data2 = data2;
    }
}