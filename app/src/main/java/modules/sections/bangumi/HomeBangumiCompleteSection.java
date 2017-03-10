package modules.sections.bangumi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeBangumiMainEntity;
import utils.GlideUtils;
import widget.extra.CommonHeaderView;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeBangumiCompleteSection extends HomeSections {

    private Context context;
    private List<HomeBangumiMainEntity.ResultBean.EndsBean> datalist;
    public HomeBangumiCompleteSection(Context context,List<HomeBangumiMainEntity.ResultBean.EndsBean> datalist){
        super(R.layout.section_bangumi_wanjie,R.layout.section_header_common,true);
        this.context = context;
        this.datalist = datalist;
    }


    @Override
    protected RecyclerView.ViewHolder onCreateHeaderHolder(View view) {
        HeadViewHolder viewHolder = new HeadViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindHeaderView(RecyclerView.ViewHolder viewHolder, int position) {
        super.onBindHeaderView(viewHolder, position);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
//        super.onBindItemView(viewHolder, position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
//        Glide.with(context)
//                .load(datalist.get(position -1).getCover())
//                .placeholder(R.drawable.ic_launcher)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .dontAnimate()
//                .into(itemViewHolder.cover);
        GlideUtils.loadImgWidthDefaultCorner(context,datalist.get(position -1).getCover(),itemViewHolder.cover);
        itemViewHolder.title.setText(datalist.get(position-1).getTitle());
        itemViewHolder.total.setText(datalist.get(position-1).getTotal_count()+"话全");

    }

    @Override
    public int getTotalItemCount() {
        return 4;
    }

    @Override
    public int getSectionType(int postion) {
        switch (postion){
            case 0:
                return SectionRecyclerAdapter.VIEW_TYPE_HEADER;
            default:
                return SectionRecyclerAdapter.VIEW_TYPE_ITEM_3;

        }
    }


    class ItemViewHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.iv_banguumi_cover)
        ImageView cover;
        @BindView(R.id.tv_bangumi_title)
        TextView title;
        @BindView(R.id.tv_bangumi_complete_num)
        TextView total;



        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }





//    class HeadViewHolder extends RecyclerView.ViewHolder{
//
//        @BindView(R.id.iv_live_item_head_icon)
//        ImageView icon;
//        @BindView(R.id.tv_live_item_head_title)
//        TextView title;
//        @BindView(R.id.tv_live_item_head_num)
//        TextView num;
//        @BindView(R.id.tv_live_item_head_enter)
//        TextView enter;
//        @BindView(R.id.tv_bangumi_head_right)
//        TextView bangumi;
//
//        public HeadViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this,itemView);
//            enter.setVisibility(View.VISIBLE);
//            num.setVisibility(View.GONE);
//            bangumi.setVisibility(View.GONE);
//            title.setText("完结动画");
//            Glide.with(enter.getContext())
//                    .load(R.drawable.ic_launcher)
//                    .override(60,60)
//                    .skipMemoryCache(true)
//                    .dontAnimate()
//                    .into(icon);
//        }
//    }


    class HeadViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.commonheader)
        CommonHeaderView commonHeaderView;

        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            commonHeaderView.onEnter();
            commonHeaderView.loadIconAndTitle(R.drawable.ic_launcher,"完结动画");
        }
    }
}
