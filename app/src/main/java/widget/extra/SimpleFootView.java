package widget.extra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ly on 2017/2/25.
 */

public class SimpleFootView extends RelativeLayout {

    @BindView(R.id.tv_foot_view)
    TextView tvMess;

    public SimpleFootView(Context context) {
        this(context,null);
    }

    public SimpleFootView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleFootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.layout_video_comment_foot,this,true);
        ButterKnife.bind(this);
    }

    public void setLoading(){
        tvMess.setText("正在加载...");
    }

    public void setNoMoreData(){
        tvMess.setText("没有更多数据");
    }

}
