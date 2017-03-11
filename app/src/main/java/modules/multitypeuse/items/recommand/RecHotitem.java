package modules.multitypeuse.items.recommand;

import modules.multitypeuse.items.base.BaseItems;
import network.entity.HomeRecContentEntity;

/**
 * Created by ly on 2017/3/11.
 */
public class RecHotitem extends BaseItems {

    public HomeRecContentEntity.ResultBean.BodyBean data;



    public RecHotitem(HomeRecContentEntity.ResultBean.BodyBean data,int position) {
        this.data = data;
        this.position = position;
    }
}