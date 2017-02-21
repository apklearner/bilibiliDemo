package widget.extra;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ly on 2017/2/22.
 */

public class CommonFootView extends RelativeLayout {

    @BindView(R.id.card_foot_more)
    CardView card;
    @BindView(R.id.iv_live_item_foot_more)
    ImageView refresh;
    @BindView(R.id.tv_live_item_foot_active)
    TextView active;
    @BindView(R.id.tv_live_item_foot_more)
    TextView btnMore;
    @BindView(R.id.tv_foot_exchange)
    TextView change;

    public CommonFootView(Context context) {
        this(context,null);
    }

    public CommonFootView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CommonFootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.section_live_item_foot,this,true);
        ButterKnife.bind(this);
    }

    public void onChangeShow(){
        card.setVisibility(View.GONE);
        refresh.setVisibility(View.GONE);
        btnMore.setVisibility(View.GONE);
        active.setVisibility(View.GONE);
        change.setVisibility(View.VISIBLE);
    }

    public void setBtnText(String content){
        btnMore.setText(content);
    }

}
