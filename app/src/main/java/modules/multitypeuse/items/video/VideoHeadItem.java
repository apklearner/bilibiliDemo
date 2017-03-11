package modules.multitypeuse.items.video;

import modules.multitypeuse.items.base.BaseItems;
import network.entity.VideoDetailEntity;

/**
 * Created by ly on 2017/3/11.
 */
public class VideoHeadItem extends BaseItems{

    public VideoDetailEntity.DataBean data;


    public VideoHeadItem(VideoDetailEntity.DataBean data) {
        this.data = data;
    }
}