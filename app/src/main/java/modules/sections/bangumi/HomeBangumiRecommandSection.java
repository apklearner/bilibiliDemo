package modules.sections.bangumi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeBangumiRecEntity;
import utils.GlideUtils;
import widget.extra.CommonHeaderView;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeBangumiRecommandSection extends HomeSections {

    private Context context;
    private List<HomeBangumiRecEntity.ResultBean> datalist ;
    public HomeBangumiRecommandSection(Context context,List<HomeBangumiRecEntity.ResultBean> datalist){
        super(R.layout.section_bangumi_recommand,R.layout.section_header_common,true);
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderHolder(View view) {
//        return super.onCreateHeaderHolder(view);
        HeadViewHolder viewHolder = new HeadViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindHeaderView(RecyclerView.ViewHolder viewHolder, int position) {
        super.onBindHeaderView(viewHolder, position);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
//        return super.onCreateItemHolder(view);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
//        super.onBindItemView(viewHolder, position);
        ItemViewHolder itemViewHolder  = (ItemViewHolder) viewHolder;
//        Glide.with(context)
//                .load(datalist.get(position -1).getCover())
//                .placeholder(R.drawable.ic_launcher)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .dontAnimate()
//                .into(itemViewHolder.cover);
        GlideUtils.loadImg(context,datalist.get(position-1).getCover(),itemViewHolder.cover);
        itemViewHolder.title.setText(datalist.get(position-1).getTitle());
        itemViewHolder.desc.setText(datalist.get(position-1).getDesc());

    }

    @Override
    public int getTotalItemCount() {
        return datalist.size()+1;
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



    class ItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_bangumi_item1_cover)
        RoundedImageView cover;
        @BindView(R.id.tv_bangumi_item1_title)
        TextView title;
        @BindView(R.id.tv_bangumi_item1_des)
        TextView desc;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    class HeadViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.commonheader)
        CommonHeaderView commonHeaderView;

        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            commonHeaderView.onBangumi();
            commonHeaderView.loadIconAndTitle(R.drawable.ic_launcher,"番剧推荐");
        }
    }
}
