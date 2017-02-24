package modules.sections.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.VideoDetailEntity;
import utils.GlideUtils;

/**
 * Created by ly on 2017/2/24.
 */

public class VideoAbstractSection  extends HomeSections{

    private VideoDetailEntity data;
    private Context context;
    public VideoAbstractSection(Context context,VideoDetailEntity data){
        super(R.layout.item_video_relate,R.layout.section_video_abstract_head,true);
        this.data = data;
        this.context = context;
    }

    @Override
    public int getTotalItemCount() {
        try {
            return data==null?0:data.getData().getRelates().size()+1;
        }catch (Exception e){}
        return 1;
    }

    @Override
    public int getSectionType(int postion) {
        switch (postion){
            case 0:
                return SectionRecyclerAdapter.VIEW_TYPE_HEADER;
            default:
                return SectionRecyclerAdapter.VIEW_TYPE_ITEM_1;
        }
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderHolder(View view) {
        HeadVideHolder videHolder = new HeadVideHolder(view);
        return videHolder;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
       ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    protected void onBindHeaderView(RecyclerView.ViewHolder viewHolder, int position) {
        HeadVideHolder headVideHolder = (HeadVideHolder) viewHolder;

        headVideHolder.title.setText(data.getData().getTitle());
        headVideHolder.playCount.setText(data.getData().getStat().getView()+"");
        headVideHolder.danmCount.setText(data.getData().getStat().getDanmaku()+"");
        headVideHolder.content.setText(data.getData().getDesc());
        headVideHolder.tvShare.setText(data.getData().getStat().getShare()+"");
        headVideHolder.tvCoin.setText(data.getData().getStat().getCoin()+"");
        headVideHolder.tvCollect.setText(data.getData().getStat().getFavorite()+"");
        GlideUtils.loadImg(context,data.getData().getOwner().getFace(),headVideHolder.ivUpIcon,new CropCircleTransformation(context));
        headVideHolder.tvUpName.setText(data.getData().getOwner().getName());
        headVideHolder.tvTime.setText(data.getData().getCtime()+"");
        headVideHolder.tagFlowLayout.setAdapter(new TagAdapter<String>(data.getData().getTags()) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_tags,null);
                TextView title = (TextView) view.findViewById(R.id.tv_tags);
                title.setText(s);
                return view;
            }
        });



    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder holder1= (ItemViewHolder) viewHolder;
        GlideUtils.loadImg(context,data.getData().getRelates().get(position-1).getPic(),holder1.cover);
        holder1.title.setText(data.getData().getRelates().get(position-1).getTitle());
        holder1.name.setText(data.getData().getRelates().get(position-1).getOwner().getName());
        holder1.playCount.setText(data.getData().getRelates().get(position-1).getStat().getView()+"");
        holder1.danmCount.setText(data.getData().getRelates().get(position-1).getStat().getDanmaku()+"");
    }

    class HeadVideHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_video_abstract_title)
        TextView title;
        @BindView(R.id.tv_video_abstract_play_count)
        TextView playCount;
        @BindView(R.id.tv_video_abstract_danm_count)
        TextView danmCount;
        @BindView(R.id.tv_video_abstract_content)
        TextView content;
        @BindView(R.id.tv_vide_abstract_share)
        TextView tvShare;
        @BindView(R.id.iv_vide_abstract_share)
        ImageView ivShare;
        @BindView(R.id.tv_vide_abstract_coin)
        TextView tvCoin;
        @BindView(R.id.iv_vide_abstract_coin)
        ImageView ivCoin;
        @BindView(R.id.tv_vide_abstract_collect)
        TextView tvCollect;
        @BindView(R.id.iv_vide_abstract_collect)
        ImageView ivCollect;
        @BindView(R.id.iv_video_abstract_up_icon)
        ImageView ivUpIcon;
        @BindView(R.id.tv_video_abstract_up_name)
        TextView tvUpName;
        @BindView(R.id.tv_video_abstract_up_time)
        TextView tvTime;
        @BindView(R.id.tv_video_abstract_focus)
        TextView tvFocus;
        @BindView(R.id.tags_video_abstract)
        TagFlowLayout tagFlowLayout;

        public HeadVideHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class ItemViewHolder extends  RecyclerView.ViewHolder{


        @BindView(R.id.iv_video_relate)
        ImageView cover;
        @BindView(R.id.tv_video_relate_title)
        TextView title;
        @BindView(R.id.tv_video_relate_up_name)
        TextView name;
        @BindView(R.id.tv_video_relate_play_count)
        TextView playCount;
        @BindView(R.id.tv_video_relate_danm_count)
        TextView danmCount;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
