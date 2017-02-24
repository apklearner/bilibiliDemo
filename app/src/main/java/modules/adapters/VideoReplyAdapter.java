package modules.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import network.entity.ReplyChildEntity;
import widget.extra.VideoReplyView;

/**
 * Created by ly on 2017/2/25.
 */

public class VideoReplyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ReplyChildEntity> dataList;

    public VideoReplyAdapter(Context context,List<ReplyChildEntity> dataList){
        this.context = context;
        this.dataList = dataList;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video_reply_com,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.videoReplyView.build(dataList.get(position));
        viewHolder.ll.setVisibility(View.GONE);
        if(dataList.size() >3){
            if(position == 2 ) viewHolder.ll.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return dataList==null?0:dataList.size();
    }


    class  ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.videoReply)
        VideoReplyView videoReplyView;
        @BindView(R.id.ll_video_reply_hot_more)
        LinearLayout ll;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
