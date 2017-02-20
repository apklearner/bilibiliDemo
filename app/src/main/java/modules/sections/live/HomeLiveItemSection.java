package modules.sections.live;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.makeramen.roundedimageview.RoundedImageView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeLiveEntity;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeLiveItemSection extends HomeSections{

    private HomeLiveEntity.DataBean.PartitionsBean data;

    public HomeLiveItemSection(HomeLiveEntity.DataBean.PartitionsBean data){
        super(R.layout.section_live_item,R.layout.section_live_item_head,R.layout.section_live_item_foot);
        this.data = data;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderHolder(View view) {
        HeadViewHoloder viewHoloder = new HeadViewHoloder(view);
        return viewHoloder;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateFooterHolder(View view) {
        FootViewHolder viewHolder = new FootViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindHeaderView(RecyclerView.ViewHolder viewHolder, int position) {
      HeadViewHoloder headViewHoloder = (HeadViewHoloder) viewHolder;
        int width = Integer.valueOf(data.getPartition().getSub_icon().getWidth());
        int height = Integer.valueOf(data.getPartition().getSub_icon().getHeight());
        Glide.with(headViewHoloder.icon.getContext())
                .load(data.getPartition().getSub_icon().getSrc())
                .skipMemoryCache(true)
                .override(width,height)
                .dontAnimate()
                .into(headViewHoloder.icon);
        headViewHoloder.title.setText(data.getPartition().getName());
        headViewHoloder.num.setText("更多"+data.getPartition().getCount()+"个直播");

    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        Glide.with(itemViewHolder.cover.getContext())
                .load(data.getLives().get(position -1).getCover().getSrc())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher)
                .dontAnimate()
                .into(itemViewHolder.cover);

        Glide.with(itemViewHolder.cover.getContext())
                .load(data.getLives().get(position -1).getOwner().getFace())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CropCircleTransformation(itemViewHolder.cover.getContext()))
                .dontAnimate()
                .into(itemViewHolder.icon);

        itemViewHolder.online.setText(data.getLives().get(position -1 ).getOnline()+"");
        itemViewHolder.title.setText(data.getLives().get(position -1 ).getTitle());


    }

    @Override
    protected void onBindFooterView(RecyclerView.ViewHolder viewHolder, int position) {
        FootViewHolder footViewHolder = (FootViewHolder) viewHolder;
//        SpannableStringBuilder span = new SpannableStringBuilder("查看更多"+data.getPartition().getCount()+"个直播");
//        ForegroundColorSpan colorSpan = new ForegroundColorSpan(footViewHolder.active.getContext().getResources().getColor(R.color.colorPrimary));
//        span.setSpan(colorSpan,4,span.length()-3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        footViewHolder.active.setText(span);



    }

    @Override
    public int getTotalItemCount() {
        return 6 ;
    }

    @Override
    public int getSectionType(int position) {
        switch (position){
            case 0:
                return SectionRecyclerAdapter.VIEW_TYPE_HEADER;
            case 5:
                return SectionRecyclerAdapter.VIEW_TYPE_FOOTER;
            default:
                return SectionRecyclerAdapter.VIEW_TYPE_ITEM_2;
        }
    }

    class HeadViewHoloder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_live_item_head_icon)
        ImageView icon;
        @BindView(R.id.tv_live_item_head_title)
        TextView title;
        @BindView(R.id.tv_live_item_head_num)
        TextView num;
        @BindView(R.id.tv_live_item_head_enter)
        TextView enter;

        public HeadViewHoloder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_live_item_bg)
        RoundedImageView cover;
        @BindView(R.id.iv_live_item_icon)
        ImageView icon;
        @BindView(R.id.tv_live_item_online)
        TextView online;
        @BindView(R.id.tv_live_item_title)
        TextView title;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class FootViewHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.iv_live_item_foot_more)
        ImageView refresh;
        @BindView(R.id.tv_live_item_foot_active)
        TextView active;
        @BindView(R.id.tv_live_item_foot_more)
        TextView btnMore;

        public FootViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
