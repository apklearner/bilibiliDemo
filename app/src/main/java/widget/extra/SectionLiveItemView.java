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
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import utils.GlideUtils;

/**
 * Created by ly on 2017/2/22.
 */

public class SectionLiveItemView extends RelativeLayout {

    @BindView(R.id.iv_live_item_bg)
    ImageView cover;
    @BindView(R.id.iv_live_item_icon)
    ImageView icon;
    @BindView(R.id.tv_live_item_online)
    TextView online;
    @BindView(R.id.tv_live_item_title)
    TextView title;
    @BindView(R.id.tv_live_item_name)
    TextView name;

    public SectionLiveItemView(Context context) {
        this(context,null);
    }

    public SectionLiveItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SectionLiveItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.section_live_item,this,true);
        ButterKnife.bind(this);
    }

    public void build(String cover,String icon,String name,String title,String online){
//        Glide.with(getContext())
//                .load(cover)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.ic_launcher)
//                .centerCrop()
//                .dontAnimate()
//                .into(this.cover);
//        Glide.with(getContext())
//                .load(icon)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .bitmapTransform(new CropCircleTransformation(getContext()))
//                .dontAnimate()
//                .into(this.icon);


//        GlideUtils\.loadImg(getContext(),cover,this.cover);
        GlideUtils.loadImgWidthDefaultCorner(getContext(),cover,this.cover);
        GlideUtils.loadImg(getContext(),icon,this.icon,new CropCircleTransformation(getContext()));
        this.name.setText(name);
        this.title.setText(title);
        this.online.setText(online);

    }



}
