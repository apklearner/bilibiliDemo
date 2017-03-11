package modules.multitypeuse.items.live;

import modules.multitypeuse.items.base.BaseItems;
import network.entity.HomeLiveEntity;
import network.entity.HomeRecContentEntity;

/**
 * Created by ly on 2017/3/9.
 */
public class LiveTextItem extends BaseItems{

    public HomeLiveEntity.DataBean.PartitionsBean.LivesBeanX data;

    public HomeRecContentEntity.ResultBean.BodyBean resultBean;

    public boolean isRecommamd;


    public LiveTextItem(HomeLiveEntity.DataBean.PartitionsBean.LivesBeanX data,int position) {
        this.data = data;
        this.position = position;
    }

    public LiveTextItem(HomeRecContentEntity.ResultBean.BodyBean resultBean,int position) {
        this.resultBean = resultBean;
        this.position = position;
        isRecommamd = true;
    }
}