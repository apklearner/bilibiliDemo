package modules.multitypeuse.items.live;

import network.entity.HomeLiveEntity;
import network.entity.HomeRecContentEntity;

/**
 * Created by ly on 2017/3/9.
 */
public class LiveTextItem {

    public HomeLiveEntity.DataBean.PartitionsBean.LivesBeanX data;

    public HomeRecContentEntity.ResultBean.BodyBean resultBean;

    public boolean isRecommamd;

    public int position;

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