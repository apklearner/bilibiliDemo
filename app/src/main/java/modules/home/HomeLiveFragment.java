package modules.home;

import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import base.HomeBaseFragment;
import modules.sections.HomeBannerSection;
import modules.sections.live.HomeLiveCenterSection;
import modules.sections.live.HomeLiveFooter;
import modules.sections.live.HomeLiveItemSection;
import modules.sections.live.HomeLiveTypeSection;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeLiveEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import utils.DensityUtils;
import widget.banner.BannerEntity;
import widget.decoration.LiveItemDecoration;

/**
 * Created by ly on 2017/2/18.
 */

public class HomeLiveFragment extends HomeBaseFragment {



    private List<BannerEntity> bannerList = new ArrayList<>();
    private SectionRecyclerAdapter adapter;


    public static HomeLiveFragment newInstance(){
        HomeLiveFragment fragment = new HomeLiveFragment();
        return fragment;

    }

    @Override
    protected void initView() {
        super.initView();
        adapter = new SectionRecyclerAdapter();
        GridLayoutManager manager = new GridLayoutManager(getActivity(),12);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
               switch (adapter.getSpanViewType(position)){
                   case SectionRecyclerAdapter.VIEW_TYPE_HEADER:
                   case SectionRecyclerAdapter.VIEW_TYPE_FOOTER:
                   case SectionRecyclerAdapter.VIEW_TYPE_ITEM_1:
                        return 12;
                   case SectionRecyclerAdapter.VIEW_TYPE_ITEM_2:
                        return 6;
                   case SectionRecyclerAdapter.VIEW_TYPE_ITEM_4:
                        return 3;
                   default:
                        return 12;
               }

            }
        });

        mrecyclerView.setLayoutManager(manager);
        mrecyclerView.addItemDecoration(new LiveItemDecoration(DensityUtils.Dp2px(getActivity(),10)));
        mrecyclerView.setAdapter(adapter);
        mswipeRefresh.setRefreshing(true);


    }

    @Override
    protected void loadData() {
        super.loadData();
        ApiGengder.getLiveService().getHomeLiveInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeLiveEntity>() {
                    @Override
                    public void call(HomeLiveEntity homeLiveEntity) {
                        addBanners(homeLiveEntity);
                        addTypes(homeLiveEntity);
                        addItems(homeLiveEntity);
                        adapter.notifyDataSetChanged();
                        refreshComplete();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                    }
                });
    }


    private void addBanners(HomeLiveEntity homeLiveEntity){
        bannerList.clear();
       List<HomeLiveEntity.DataBean.BannerBean> bannerBeen =  homeLiveEntity.getData().getBanner();
        for(int i =0;i<bannerBeen.size();i++){
            bannerList.add(new BannerEntity(bannerBeen.get(i).getImg()));
        }
        adapter.addSections(new HomeBannerSection(bannerList));


//        bannerView.buildBanner(bannerList);
    }
    private void addTypes(HomeLiveEntity homeLiveEntity) {
        List<HomeLiveEntity.DataBean.EntranceIconsBean> datalist = homeLiveEntity.getData().getEntranceIcons();
        adapter.addSections(new HomeLiveTypeSection(datalist));

        adapter.addSections(new HomeLiveCenterSection(getActivity()));
    }

    private void addItems(HomeLiveEntity homeLiveEntity){
        List<HomeLiveEntity.DataBean.PartitionsBean> datalist = homeLiveEntity.getData().getPartitions();
        for(HomeLiveEntity.DataBean.PartitionsBean baan :datalist){
            adapter.addSections(new HomeLiveItemSection(baan));
        }

        adapter.addSections(new HomeLiveFooter(getActivity()));
    }
}
