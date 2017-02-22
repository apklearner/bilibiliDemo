package widget.extra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.makeramen.roundedimageview.RoundedImageView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by ly on 2017/2/22.
 */

public class SectionLiveItemView extends RelativeLayout {

    @BindView(R.id.iv_live_item_bg)
    RoundedImageView cover;
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
        Glide.with(getContext())
                .load(cover)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher)
                .centerCrop()
                .dontAnimate()
                .into(this.cover);
        Glide.with(getContext())
                .load(icon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .centerCrop()
                .dontAnimate()
                .into(this.icon);

        this.name.setText(name);
        this.title.setText(title);
        this.online.setText(online);

    }



}
