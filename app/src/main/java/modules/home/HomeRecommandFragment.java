package modules.home;

import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import base.HomeBaseFragment;
import modules.sections.HomeBannerSection;
import modules.sections.SectionRecyclerAdapter;
import modules.sections.recommand.RecHotSection;
import network.entity.HomeRecBannerEntity;
import network.entity.HomeRecContentEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import utils.DensityUtils;
import widget.banner.BannerEntity;
import widget.decoration.BangumiItemDecoration;

/**
 * Created by ly on 2017/2/22.
 */

public class HomeRecommandFragment  extends HomeBaseFragment{

    private GridLayoutManager manager;
    private SectionRecyclerAdapter adapter;

    public static HomeRecommandFragment newInstance(){
        HomeRecommandFragment instance = new HomeRecommandFragment();
        return instance;
    }



    @Override
    protected void initView() {
        super.initView();
        adapter = new SectionRecyclerAdapter();
        manager = new GridLayoutManager(getActivity(),2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getSpanViewType(position)){
                    case SectionRecyclerAdapter.VIEW_TYPE_HEADER:
                    case SectionRecyclerAdapter.VIEW_TYPE_FOOTER:
                    case  SectionRecyclerAdapter.VIEW_TYPE_ITEM_1:
                        return 2;
                    case SectionRecyclerAdapter.VIEW_TYPE_ITEM_2:
                        return 1;
                }
                return 0;
            }
        });

        mrecyclerView.addItemDecoration(new BangumiItemDecoration(getActivity(), DensityUtils.Dp2px(getActivity(),10),4));
        mrecyclerView.setLayoutManager(manager);
        mrecyclerView.setAdapter(adapter);


    }

    @Override
    protected void loadData() {
        super.loadData();
        ApiGengder.getRecommandService().getBanners()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeRecBannerEntity>() {
                    @Override
                    public void call(HomeRecBannerEntity homeRecBannerEntity) {
                        loadBannerData(homeRecBannerEntity);
                        requestContent();
//                        adapter.notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        refreshComplete();
                    }
                });
    }

    private void loadBannerData(HomeRecBannerEntity homeRecBannerEntity){
        List<BannerEntity> datalist = new ArrayList<>();
        for(HomeRecBannerEntity.DataBean dataBean:homeRecBannerEntity.getData()){
            datalist.add(new BannerEntity(dataBean.getImage()));
        }
        adapter.addSections(new HomeBannerSection(datalist));

    }

    private void requestContent(){
        ApiGengder.getRecommandService().getContents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeRecContentEntity>() {
                    @Override
                    public void call(HomeRecContentEntity homeRecContentEntity) {
                        loadContentData(homeRecContentEntity);
                        adapter.notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        refreshComplete();

                    }
                });
    }

    private void loadContentData(HomeRecContentEntity homeRecContentEntity){
        for(HomeRecContentEntity.ResultBean bean : homeRecContentEntity.getResult()){
            if(bean.getType().equals("recommend") || bean.getType().equals("region")){
                adapter.addSections(new RecHotSection(bean));
            }
        }

    }


    private String types[] = new String[]{"recommend","live","bangumi_2","weblink","region","activity"};

}
