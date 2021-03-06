package widget.extra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import utils.GlideUtils;

/**
 * Created by ly on 2017/2/22.
 */

public class RecItemView extends RelativeLayout {

    @BindView(R.id.iv_rec_cover)
    ImageView cover;
    @BindView(R.id.tv_rec_title)
    TextView title;
    @BindView(R.id.tv_rec_play_count)
    TextView playCount;
    @BindView(R.id.tv_rec_danm_count)
    TextView danmCount;

    public RecItemView(Context context) {
        this(context,null);
    }

    public RecItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public RecItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    private void initView(){

        LayoutInflater.from(getContext()).inflate(R.layout.section_rec_hot_item,this,true);
        ButterKnife.bind(this);

    }

    public void build(String cover,String title,String  playCount,String danmCount,int width,int height){
//        Glide.with(getContext())
//                .load(cover)
//                .override(width,height)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.ic_launcher)
//                .centerCrop()
//                .dontAnimate()
//                .into(this.cover);
        GlideUtils.loadImgWidthDefaultCorner(getContext(),cover,this.cover);
        this.title.setText(title);
        this.playCount.setText(playCount);
        this.danmCount.setText(danmCount);
    }



}
