package modules.sections.bangumi;

import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeBangumiMainEntity;
import network.entity.HomeRecContentEntity;
import widget.extra.CommonHeaderView;
import widget.extra.SectionBangumiItemView;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeBangumiUpdateSection extends HomeSections {

    private HomeBangumiMainEntity.ResultBean.LatestUpdateBean data;
    private HomeRecContentEntity.ResultBean resultBean;
    private boolean isRecommand;

    public HomeBangumiUpdateSection(HomeBangumiMainEntity.ResultBean.LatestUpdateBean data){
        super(R.layout.section_bangum_items,R.layout.section_header_common,true);
        this.data = data;
    }

    public HomeBangumiUpdateSection( HomeRecContentEntity.ResultBean resultBean){
        super(R.layout.section_bangum_items,R.layout.section_header_common,R.layout.section_bangumi_foot);
        this.resultBean = resultBean;
        isRecommand = true;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderHolder(View view) {
        HeadViewHolder viewHolder = new HeadViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindHeaderView(RecyclerView.ViewHolder viewHolder, int position) {
        HeadViewHolder headViewHolder = (HeadViewHolder) viewHolder;
       if(isRecommand){
            headViewHolder.commonHeaderView.onEnter();
           headViewHolder.commonHeaderView.setRightBtnText("更多");
           return;
       }
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
//        Glide.with(itemViewHolder.cover.getContext())
//                .load(data.getList().get(position -1).getCover())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .dontAnimate()
//                .into(itemViewHolder.cover);
//
//       String watchCount = data.getList().get(position-1).getWatchingCount();
//        if(!TextUtils.isEmpty(watchCount)){
//            if(Integer.valueOf(watchCount) < 100){
//                itemViewHolder.watch.setVisibility(View.GONE);
//            }else {
//                itemViewHolder.watch.setVisibility(View.VISIBLE);
//            }
//        }
//
//        itemViewHolder.watch.setText(data.getList().get(position -1).getWatchingCount()+ "在看");
//        itemViewHolder.title.setText(data.getList().get(position-1).getTitle());
//        itemViewHolder.num.setText("第"+data.getList().get(position -1).getNewest_ep_index()+"话");
//        itemViewHolder.time.setText(data.getList().get(position -1).getLast_time());
       if(isRecommand){
           itemViewHolder.bangumiItemView.build(resultBean.getBody().get(position-1).getCover(),
                   resultBean.getBody().get(position-1).getTitle(),
                   resultBean.getBody().get(position-1).getDesc1(),"","");

           return;
       }


        itemViewHolder.bangumiItemView.build(data.getList().get(position-1).getCover(),
                data.getList().get(position-1).getTitle(),
                "第"+data.getList().get(position-1).getNewest_ep_index()+"话",
                data.getList().get(position-1).getLast_time(),
                data.getList().get(position-1).getWatchingCount());


    }

    @Override
    protected RecyclerView.ViewHolder onCreateFooterHolder(View view) {
        FootViewHolder footViewHolder = new FootViewHolder(view);
        return footViewHolder;
    }



    @Override
    public int getTotalItemCount() {
        if(isRecommand){
            return resultBean.getBody().size() +2;
        }
        return 4 +1;
    }

    @Override
    public int getSectionType(int postion) {
        if(isRecommand){

            switch (postion){
                case 0:
                    return SectionRecyclerAdapter.VIEW_TYPE_HEADER;
                case 5:
                    return SectionRecyclerAdapter.VIEW_TYPE_FOOTER;
                default:
                    return SectionRecyclerAdapter.VIEW_TYPE_ITEM_2;
            }

        }

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

      @BindView(R.id.bangumisection)
        SectionBangumiItemView bangumiItemView;

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


    class FootViewHolder extends RecyclerView.ViewHolder{

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }
}
