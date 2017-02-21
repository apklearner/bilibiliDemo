package modules.home;

import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import base.HomeBaseFragment;
import modules.sections.SectionRecyclerAdapter;
import modules.sections.HomeBannerSection;
import modules.sections.bangumi.HomeBangumiCompleteSection;
import modules.sections.bangumi.HomeBangumiRecommandSection;
import modules.sections.bangumi.HomeBangumiTypeSection;
import modules.sections.bangumi.HomeBangumiUpdateSection;
import network.entity.HomeBangumiMainEntity;
import network.entity.HomeBangumiRecEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import utils.DensityUtils;
import widget.banner.BannerEntity;
import widget.decoration.BangumiItemDecoration;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeBangumiFragment extends HomeBaseFragment {


    private SectionRecyclerAdapter adapter;
    private GridLayoutManager manager;

    public static HomeBangumiFragment newInstance(){
        HomeBangumiFragment instance = new HomeBangumiFragment();
        return instance;

    }


    @Override
    protected void initView() {
        super.initView();
        adapter = new SectionRecyclerAdapter();
        manager = new GridLayoutManager(getActivity(),6);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getSpanViewType(position)){
                    case SectionRecyclerAdapter.VIEW_TYPE_HEADER:
                    case SectionRecyclerAdapter.VIEW_TYPE_ITEM_1:
                        return 6;
                    case SectionRecyclerAdapter.VIEW_TYPE_ITEM_2:
                        return 3;
                    case SectionRecyclerAdapter.VIEW_TYPE_ITEM_3:
                        return 2;
                }
                return 0;
            }
        });
        mrecyclerView.addItemDecoration(new BangumiItemDecoration(getActivity(), DensityUtils.Dp2px(getActivity(),10),6));
        mrecyclerView.setLayoutManager(manager);
        mrecyclerView.setAdapter(adapter);

    }

    @Override
    protected void loadData() {
        super.loadData();
        ApiGengder.getBangumiService().getHomeBangumiMain()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeBangumiMainEntity>() {
                    @Override
                    public void call(HomeBangumiMainEntity homeBangumiMainEntity) {
                        loadMainData(homeBangumiMainEntity);
//                        adapter.notifyDataSetChanged();
                        requestRecData();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        refreshComplete();
                    }
                });


    }


    private void loadMainData(HomeBangumiMainEntity homeBangumiMainEntity){
        List<BannerEntity>  bannerlist = new ArrayList<>();
        for(HomeBangumiMainEntity.ResultBean.BannersBean banner:homeBangumiMainEntity.getResult().getBanners()){
            bannerlist.add(new BannerEntity(banner.getImg()));
        }

        adapter.addSections(new HomeBannerSection(bannerlist));
        adapter.addSections(new HomeBangumiTypeSection(getActivity()));
        adapter.addSections(new HomeBangumiUpdateSection(homeBangumiMainEntity.getResult().getLatestUpdate()));
        adapter.addSections(new HomeBangumiCompleteSection(getActivity(),homeBangumiMainEntity.getResult().getEnds()));
    }
    private void requestRecData(){
        ApiGengder.getBangumiService().getHomeBangumiRec()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeBangumiRecEntity>() {
                    @Override
                    public void call(HomeBangumiRecEntity homeBangumiRecEntity) {
                        loadRecData(homeBangumiRecEntity);
                        adapter.notifyDataSetChanged();
                        refreshComplete();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        refreshComplete();
                    }
                });

    }

    private void loadRecData(HomeBangumiRecEntity homeBangumiRecEntity){
        adapter.addSections(new HomeBangumiRecommandSection(getActivity(),homeBangumiRecEntity.getResult()));
    }


}
