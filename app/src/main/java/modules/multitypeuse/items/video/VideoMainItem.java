package modules.multitypeuse.items.video;

import modules.multitypeuse.items.base.BaseItems;
import network.entity.VideoDetailEntity;

/**
 * Created by ly on 2017/3/11.
 */
public class VideoMainItem extends BaseItems{

    public VideoDetailEntity.DataBean.RelatesBean data;


    public VideoMainItem(VideoDetailEntity.DataBean.RelatesBean data,int position) {
        this.data = data;
        this.position = position;
    }
}