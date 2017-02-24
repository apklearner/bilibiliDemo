package widget.extra;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import utils.GlideUtils;

/**
 * Created by ly on 2017/2/22.
 */

public class SectionBangumiItemView extends RelativeLayout {

    @BindView(R.id.iv_bangumi_item_cover)
    RoundedImageView cover;
    @BindView(R.id.tv_bangumi_item_watch)
    TextView watch;
    @BindView(R.id.tv_bangumi_item_title)
    TextView title;
    @BindView(R.id.tv_bangumi_update_num)
    TextView num;
    @BindView(R.id.tv_bangumi_update_time)
    TextView time;

    public SectionBangumiItemView(Context context) {
        this(context,null);
    }

    public SectionBangumiItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public SectionBangumiItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }


    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.section_bangumi_update,this,true);
        ButterKnife.bind(this);
    }
    public void build(String cover,String title,String updateNum,String updatTime,String watchCount){

//        Glide.with(getContext())
//                .load(cover)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .centerCrop()
//                .dontAnimate()
//                .into(this.cover);
        GlideUtils.loadImg(getContext(),cover,this.cover);

        if(!TextUtils.isEmpty(watchCount)){
            if(Integer.valueOf(watchCount) < 100){
                this.watch.setVisibility(View.GONE);
            }else {
                this.watch.setVisibility(View.VISIBLE);
                this.watch.setText(watchCount+ "在看");
            }
        }else {
            this.watch.setVisibility(View.GONE);
        }
        this.title.setText(title);
        this.num.setText(updateNum);
        if(!TextUtils.isEmpty(updatTime))
        this.time.setText(updatTime);

    }

}
