package modules.multitypeuse.items.bangumi;

import modules.multitypeuse.items.base.BaseItems;
import network.entity.HomeBangumiMainEntity;

/**
 * Created by ly on 2017/3/11.
 */
public class BangumiComplete extends BaseItems{

    public HomeBangumiMainEntity.ResultBean.EndsBean data;



    public BangumiComplete(HomeBangumiMainEntity.ResultBean.EndsBean data,int position) {
        this.data = data;
        this.position = position;
    }
}