package modules.sections.recommand;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.makeramen.roundedimageview.RoundedImageView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeRecContentEntity;
import utils.GlideUtils;
import widget.extra.CommonHeaderView;

/**
 * Created by ly on 2017/2/22.
 */

public class RecTopicSection extends HomeSections {

    private HomeRecContentEntity.ResultBean resultBean;
    public RecTopicSection(HomeRecContentEntity.ResultBean resultBean){
        super(R.layout.section_topic,R.layout.section_header_common,true);
        this.resultBean = resultBean;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderHolder(View view) {
        HeadViewHolder viewHolder  = new HeadViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindHeaderView(RecyclerView.ViewHolder viewHolder, int position) {
        HeadViewHolder headViewHolder = (HeadViewHolder) viewHolder;
        headViewHolder.headerView.onlyIconTitle();
        headViewHolder.headerView.loadOnlyTitle("话题");
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
//        Glide.with(itemViewHolder.cover.getContext())
//                .load(resultBean.getBody().get(0).getCover())
//                .placeholder(R.drawable.ic_launcher)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .dontAnimate()
//                .into(itemViewHolder.cover);
        GlideUtils.loadImg(itemViewHolder.cover.getContext(),resultBean.getBody().get(0).getCover(),itemViewHolder.cover);
    }

    @Override
    public int getTotalItemCount() {
        return 2;
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

    class HeadViewHolder extends  RecyclerView.ViewHolder{

        @BindView(R.id.commonheader)
        CommonHeaderView headerView;
        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class ItemViewHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.iv_section_topic)
        RoundedImageView cover;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
