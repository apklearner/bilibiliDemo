package modules.sections.bangumi;

import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.makeramen.roundedimageview.RoundedImageView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeBangumiMainEntity;
import widget.extra.CommonHeaderView;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeBangumiUpdateSection extends HomeSections {

    private HomeBangumiMainEntity.ResultBean.LatestUpdateBean data;

    public HomeBangumiUpdateSection(HomeBangumiMainEntity.ResultBean.LatestUpdateBean data){
        super(R.layout.section_bangumi_update,R.layout.section_header_common,true);
        this.data = data;
    }


    @Override
    protected RecyclerView.ViewHolder onCreateHeaderHolder(View view) {
        HeadViewHolder viewHolder = new HeadViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindHeaderView(RecyclerView.ViewHolder viewHolder, int position) {
        HeadViewHolder headViewHolder = (HeadViewHolder) viewHolder;
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder("今日更新"+data.getUpdateCount());
        ForegroundColorSpan span = new ForegroundColorSpan(headViewHolder.commonHeaderView.getContext().getResources().getColor(R.color.colorPrimary));
        stringBuilder.setSpan(span,stringBuilder.length()-1,stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        headViewHolder.commonHeaderView.setBangumiNum(stringBuilder);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        Glide.with(itemViewHolder.cover.getContext())
                .load(data.getList().get(position -1).getCover())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(itemViewHolder.cover);

       String watchCount = data.getList().get(position-1).getWatchingCount();
        if(!TextUtils.isEmpty(watchCount)){
            if(Integer.valueOf(watchCount) < 100){
                itemViewHolder.watch.setVisibility(View.GONE);
            }else {
                itemViewHolder.watch.setVisibility(View.VISIBLE);
            }
        }

        itemViewHolder.watch.setText(data.getList().get(position -1).getWatchingCount()+ "在看");
        itemViewHolder.title.setText(data.getList().get(position-1).getTitle());
        itemViewHolder.num.setText("第"+data.getList().get(position -1).getNewest_ep_index()+"话");
        itemViewHolder.time.setText(data.getList().get(position -1).getLast_time());

    }

    @Override
    public int getTotalItemCount() {
        return 7;
    }

    @Override
    public int getSectionType(int postion) {
        switch (postion){
            case 0:
                return SectionRecyclerAdapter.VIEW_TYPE_HEADER;
            default:
                return SectionRecyclerAdapter.VIEW_TYPE_ITEM_2;
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
//            enter.setVisibility(View.GONE);
//            num.setVisibility(View.GONE);
//            bangumi.setVisibility(View.VISIBLE);
//            title.setText("新番连载");
//            Glide.with(enter.getContext())
//                    .load(R.drawable.ic_launcher)
//                    .override(60,60)
//                    .skipMemoryCache(true)
//                    .dontAnimate()
//                    .into(icon);
//        }
//    }

    class ItemViewHolder extends  RecyclerView.ViewHolder{

        @BindView(R.id.iv_bangumi_item_cover)
        RoundedImageView cover;
        @BindView(R.id.tv_bangumi_item_watch)
        TextView watch;
        @BindView(R.id.tv_bangumi_item_title)
        TextView title;
        @BindView(R.id.tv_bangumi_update_num)
        TextView num;
        @BindView(R.id.tv_bangumi_update_time)
        TextView time;

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
            commonHeaderView.loadIconAndTitle(R.drawable.ic_launcher,"新番连载");
        }
    }
}
