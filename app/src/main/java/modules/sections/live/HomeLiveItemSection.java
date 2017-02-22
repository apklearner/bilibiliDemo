package modules.sections.live;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeLiveEntity;
import network.entity.HomeRecContentEntity;
import widget.extra.CommonFootView;
import widget.extra.CommonHeaderView;
import widget.extra.SectionLiveItemView;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeLiveItemSection extends HomeSections{

    private HomeLiveEntity.DataBean.PartitionsBean data;
    private HomeRecContentEntity.ResultBean resultBean;
    private boolean isrecommand;

    public HomeLiveItemSection(HomeLiveEntity.DataBean.PartitionsBean data){
        super(R.layout.section_live_item_view,R.layout.section_header_common,R.layout.section_common_foot);
        this.data = data;
    }

    public HomeLiveItemSection(HomeRecContentEntity.ResultBean resultBean){
        super(R.layout.section_live_item_view,R.layout.section_header_common,R.layout.section_common_foot);
        this.resultBean = resultBean;
        isrecommand = true;
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
       if(isrecommand){
          headViewHoloder.commonHeaderView.loadOnlyTitle(resultBean.getHead().getTitle());
           headViewHoloder.commonHeaderView.setLiveNum("更多"+resultBean.getHead().getCount()+"个直播");
          return;
       }

        int width = Integer.valueOf(data.getPartition().getSub_icon().getWidth());
        int height = Integer.valueOf(data.getPartition().getSub_icon().getHeight());
        headViewHoloder.commonHeaderView.loadIconAndTitle(data.getPartition().getSub_icon().getSrc(),data.getPartition().getName(),
                width,height);
        headViewHoloder.commonHeaderView.setLiveNum("更多"+data.getPartition().getCount()+"个直播");

    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
//        Glide.with(itemViewHolder.cover.getContext())
//                .load(data.getLives().get(position -1).getCover().getSrc())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.ic_launcher)
//                .dontAnimate()
//                .into(itemViewHolder.cover);
//
//        Glide.with(itemViewHolder.cover.getContext())
//                .load(data.getLives().get(position -1).getOwner().getFace())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .bitmapTransform(new CropCircleTransformation(itemViewHolder.cover.getContext()))
//                .dontAnimate()
//                .into(itemViewHolder.icon);
//
//        itemViewHolder.online.setText(data.getLives().get(position -1 ).getOnline()+"");
//        itemViewHolder.title.setText(data.getLives().get(position -1 ).getTitle());
//        itemViewHolder.name.setText(data.getLives().get(position-1).getOwner().getName());

        if(isrecommand){
            itemViewHolder.sectionLive.build(resultBean.getBody().get(position-1).getCover(),
                    resultBean.getBody().get(position-1).getUp_face(),
                    resultBean.getBody().get(position-1).getUp(),
                    resultBean.getBody().get(position-1).getTitle(),
                    resultBean.getBody().get(position-1).getOnline()+"");

            return;
        }


        itemViewHolder.sectionLive.build(data.getLives().get(position-1).getCover().getSrc(),
                data.getLives().get(position-1).getOwner().getFace(),
                data.getLives().get(position-1).getOwner().getName(),
                data.getLives().get(position-1).getTitle(),
                data.getLives().get(position-1).getOnline()+""
                );

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

        @BindView(R.id.commonheader)
        CommonHeaderView commonHeaderView;

        public HeadViewHoloder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            commonHeaderView.onLive();
//            commonHeaderView.loadIconAndTitle(R.drawable.ic_launcher,"新番连载");
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

       @BindView(R.id.section_live)
        SectionLiveItemView sectionLive;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class FootViewHolder extends  RecyclerView.ViewHolder{
      @BindView(R.id.commonfooot)
      CommonFootView footView;

        public FootViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
