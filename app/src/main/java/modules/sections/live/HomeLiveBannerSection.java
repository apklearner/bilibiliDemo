package modules.sections.live;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import widget.banner.BannerEntity;
import widget.banner.BannerView;

/**
 * Created by ly on 2017/2/20.
 */

public class HomeLiveBannerSection extends HomeSections {

    private List<BannerEntity> datalist = new ArrayList<>();

    public HomeLiveBannerSection(List<BannerEntity> datalist){
        super(R.layout.section_live_banner);
        this.datalist = datalist;
    }



    @Override
    public int getTotalItemCount() {
        return 1;
    }

    @Override
    public int getSectionType(int position) {
        return SectionRecyclerAdapter.VIEW_TYPE_ITEM_1;
    }


    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
        BannerViewHolder viewHolder = new BannerViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder,int position) {
       BannerViewHolder viewHolder1 = (BannerViewHolder) viewHolder;
       viewHolder1.bannerView.buildBanner(datalist);
    }

    class BannerViewHolder extends  RecyclerView.ViewHolder{

        @BindView(R.id.section_banner)
        BannerView bannerView;

        public BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
