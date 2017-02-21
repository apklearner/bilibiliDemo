package modules.sections.recommand;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeRecContentEntity;
import widget.extra.CommonFootView;
import widget.extra.CommonHeaderView;
import widget.extra.RecItemView;

/**
 * Created by ly on 2017/2/22.
 */

public class RecHotSection extends HomeSections {

    private HomeRecContentEntity.ResultBean data;

    public  RecHotSection( HomeRecContentEntity.ResultBean data){
        super(R.layout.section_rec_hot_items,R.layout.section_header_common,R.layout.section_common_foot);
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
        if(data.getType().equals("recommend"))
        headViewHolder.headerView.onOrder();
        headViewHolder.headerView.loadOnlyTitle(data.getHead().getTitle());
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
        HomeRecContentEntity.ResultBean.BodyBean bodyBean = data.getBody().get(position-1);
        itemViewHolder.recItemView.build(bodyBean.getCover(),
                bodyBean.getTitle(),bodyBean.getPlay(),bodyBean.getDanmaku());

    }

    @Override
    protected RecyclerView.ViewHolder onCreateFooterHolder(View view) {
       FootViewHolder viewHolder = new FootViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindFooterView(RecyclerView.ViewHolder viewHolder, int position) {
      FootViewHolder footViewHolder = (FootViewHolder) viewHolder;
        if(data.getType().equals("recommend")){
            footViewHolder.footView.onChangeShow();
        }else {
            String content = data.getHead().getTitle();
            footViewHolder.footView.setBtnText("更多"+ content.substring(0,content.length()-1));
        }
    }

    @Override
    public int getTotalItemCount() {
        return 6;
    }

    @Override
    public int getSectionType(int postion) {
        switch (postion){
            case 0:
                return SectionRecyclerAdapter.VIEW_TYPE_HEADER;
            case 5:
                return SectionRecyclerAdapter.VIEW_TYPE_FOOTER;
            default:
                return SectionRecyclerAdapter.VIEW_TYPE_ITEM_2;
        }
    }


    class HeadViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.commonheader)
        CommonHeaderView headerView;

        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.rec_item_view)
        RecItemView recItemView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class FootViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.commonfooot)
        CommonFootView footView;
        public FootViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
