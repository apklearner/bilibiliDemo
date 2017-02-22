package widget.extra;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ly on 2017/2/21.
 */

public class CommonHeaderView extends RelativeLayout{

    @BindView(R.id.iv_live_item_head_icon)
    ImageView icon;
    @BindView(R.id.tv_live_item_head_title)
    TextView title;
    @BindView(R.id.tv_live_item_head_num)
    TextView numberLive;
    @BindView(R.id.tv_live_item_head_enter)
    TextView enter;
    @BindView(R.id.tv_bangumi_head_right)
    TextView bangumiNum;
    @BindView(R.id.tv_order)
    TextView order;

    public CommonHeaderView(Context context) {
        this(context,null);
    }

    public CommonHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CommonHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.section_live_item_head,this,true);
        ButterKnife.bind(this);
    }

    public void onlyIconTitle(){
        numberLive.setVisibility(View.GONE);
        enter.setVisibility(View.GONE);
        bangumiNum.setVisibility(View.GONE);
    }

    public void onLive(){
        bangumiNum.setVisibility(View.GONE);
    }

    public void onBangumi(){
        bangumiNum.setVisibility(View.VISIBLE);
        enter.setVisibility(View.GONE);
        numberLive.setVisibility(View.GONE);
    }

    public void onEnter(){
        bangumiNum.setVisibility(View.GONE);
        enter.setVisibility(View.VISIBLE);
        numberLive.setVisibility(View.GONE);
    }

    public void onOrder(){
        bangumiNum.setVisibility(View.GONE);
        enter.setVisibility(View.GONE);
        numberLive.setVisibility(View.GONE);
        order.setVisibility(View.VISIBLE);
    }


    public void loadIconAndTitle(String src,String content,int width,int height){
        Glide.with(getContext())
                .load(src)
                .override(width,height)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(icon);
        title.setText(content);
    }

    public void loadIconAndTitle(String src,String content){
        loadIconAndTitle(src,content,60,60);
    }


    public void loadOnlyTitle(String content){
        loadIconAndTitle(R.drawable.ic_launcher,content);
    }


    public void loadIconAndTitle(int src,String content,int width,int height){
        Glide.with(getContext())
                .load(src)
                .override(width,height)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(icon);
        title.setText(content);
    }

    public void loadIconAndTitle(int src,String content){
        loadIconAndTitle(src,content,60,60);
    }

    public void setLiveNum(String content){
        numberLive.setText(content);
    }

    public void setBangumiNum(SpannableStringBuilder spannableStringBuilder){
        bangumiNum.setText(spannableStringBuilder);
        bangumiNum.setVisibility(VISIBLE);
    }

    public  void setOnEnterClick(OnClickListener l){
        enter.setVisibility(View.VISIBLE);
        enter.setOnClickListener(l);
    }

    public void setOnBangumiClick(OnClickListener l){
        bangumiNum.setVisibility(View.VISIBLE);
        bangumiNum.setOnClickListener(l);
    }

    public void setRightBtnText(String content){
        enter.setText(content);
    }

}
