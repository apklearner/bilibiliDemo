package modules.home;

import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import base.HomeBaseFragment;
import network.entity.HomeLiveEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import widget.banner.BannerEntity;

/**
 * Created by ly on 2017/2/18.
 */

public class HomeLiveFragment extends HomeBaseFragment {



    private List<BannerEntity> bannerList = new ArrayList<>();


    public static HomeLiveFragment newInstance(){
        HomeLiveFragment fragment = new HomeLiveFragment();
        return fragment;

    }

    @Override
    protected void initView() {
        super.initView();
        GridLayoutManager manager = new GridLayoutManager(getActivity(),12);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 0;
            }
        });

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
//        bannerView.buildBanner(bannerList);

    }
}
