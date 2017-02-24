package widget.extra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import network.entity.ReplyChildEntity;
import utils.GlideUtils;

/**
 * Created by ly on 2017/2/25.
 */

public class VideoReplyView extends RelativeLayout {

    @BindView(R.id.iv_video_reply_icon)
    ImageView icon;
    @BindView(R.id.iv_video_reply_lv)
    ImageView lv;
    @BindView(R.id.tv_video_reply_name)
    TextView name;
    @BindView(R.id.tv_video_reply_floor)
    TextView floor;
    @BindView(R.id.tv_video_reply_time)
    TextView time;
    @BindView(R.id.tv_video_reply_message)
    TextView mess;
    @BindView(R.id.tv_video_reply_feedback_com)
    TextView comNum;
    @BindView(R.id.tv_video_reply_feedback_support)
    TextView supNum;
    @BindView(R.id.childfloor)
    ReplyChildFloorView childFloorView;


    public VideoReplyView(Context context) {
        this(context,null);
    }

    public VideoReplyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public VideoReplyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.item_video_reply,this,true);
        ButterKnife.bind(this);
    }

    public  void  build(ReplyChildEntity data){
        GlideUtils.loadImg(getContext(),data.getMember().getAvatar(),icon,new CropCircleTransformation(getContext()));
        lv.setVisibility(View.VISIBLE);
        if(data.getMember().getLevel_info().getCurrent_level() >0){
            lv.setImageLevel(data.getMember().getLevel_info().getCurrent_level());
        }else {
            lv.setVisibility(View.GONE);
        }

        name.setText(data.getMember().getUname());
        floor.setText("#"+data.getFloor());
        time.setText(data.getCtime() + "");
        mess.setText(data.getContent().getMessage());
        comNum.setText(data.getCount()+"");
        supNum.setText(data.getLike()+"");

        if(data.getReplies().size() >0 ){
            childFloorView.setVisibility(View.VISIBLE);
            childFloorView.build(data.getReplies());
        }else {
            childFloorView.setVisibility(View.GONE);
        }



    }
}
