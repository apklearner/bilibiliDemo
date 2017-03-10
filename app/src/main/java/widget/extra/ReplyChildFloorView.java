package widget.extra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import network.entity.ReplyChildEntity;

/**
 * Created by ly on 2017/2/25.
 */

public class ReplyChildFloorView extends RelativeLayout {
    @BindView(R.id.ll_reply_child_floor_main)
    LinearLayout ll;

    public ReplyChildFloorView(Context context) {
        this(context,null);
    }

    public ReplyChildFloorView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ReplyChildFloorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.layout_reply_child_floor_main,this,true);
        ButterKnife.bind(this);
    }


    public void build(List<ReplyChildEntity.RepliesBean> dataList){
        ll.removeAllViews();

        for(int i =0;i <dataList.size() ;i++){
            if(i >6) break;
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_reply_child_floor_item,null);
            ViewHolder holder = new ViewHolder(view);
            holder.name.setText(dataList.get(i).getMember().getUname());
            holder.time.setText(dataList.get(i).getCtime()+"");
            holder.content.setText(dataList.get(i).getContent().getMessage());
            if(i == dataList.size()-1) holder.line.setVisibility(View.GONE);
             ll.addView(view);
        }
    }


    public void clearData(){
        if(ll!=null){
            ll.removeAllViews();
        }
    }

    class ViewHolder{
        @BindView(R.id.tv_reply_child_floor_name)
        TextView name;
        @BindView(R.id.tv_reply_child_floor_time)
        TextView time;
        @BindView(R.id.tv_reply_child_floor_content)
        TextView content;
        @BindView(R.id.line_reply_child_floor)
        View line;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }

    }
}
