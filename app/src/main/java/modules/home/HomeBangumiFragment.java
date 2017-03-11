package modules.home;

import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import base.HomeBaseFragment;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import widget.decoration.BaseDecoration;
import modules.multitypeuse.items.bangumi.BangumiComplete;
import modules.multitypeuse.items.bangumi.BangumiCompleteViewProvider;
import modules.multitypeuse.items.bangumi.BangumiHeadItem;
import modules.multitypeuse.items.bangumi.BangumiHeadItemViewProvider;
import modules.multitypeuse.items.bangumi.BangumiRecommand;
import modules.multitypeuse.items.bangumi.BangumiRecommandViewProvider;
import modules.multitypeuse.items.bangumi.BangumiType;
import modules.multitypeuse.items.bangumi.BangumiTypeViewProvider;
import modules.multitypeuse.items.bangumi.BangumiUpdate;
import modules.multitypeuse.items.bangumi.BangumiUpdateViewProvider;
import modules.multitypeuse.items.banner.BannerItem;
import modules.multitypeuse.items.banner.BannerItemViewProvider;
import modules.multitypeuse.items.base.ItemTypeValues;
import network.entity.HomeBangumiMainEntity;
import network.entity.HomeBangumiRecEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import utils.DensityUtils;
import widget.banner.BannerEntity;

/**
 * Created by ly on 2017/3/11.
 */

public class HomeBangumiFragment extends HomeBaseFragment {



    private MultiTypeAdapter adapter;
    private GridLayoutManager manager;
    private Items items = new Items();

    public static HomeBangumiFragment newInstance(){
       HomeBangumiFragment instance = new HomeBangumiFragment();
        return instance;

    }


    @Override
    protected void initView() {
        super.initView();
        adapter = new MultiTypeAdapter();
        manager = new GridLayoutManager(getActivity(),6);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (ItemTypeValues.getChildTypes(items.get(position))){
                    case ItemTypeValues.VIEW_TYPE_BANNER:
                    case ItemTypeValues.VIEW_TYPE_HEADER:
                    case ItemTypeValues.VIEW_TYPE_FOOTER:
                    case ItemTypeValues.VIEW_TYPE_ITEM_1:
                        return 6;
                    case ItemTypeValues.VIEW_TYPE_ITEM_2:
                        return 3;
                    case ItemTypeValues.VIEW_TYPE_ITEM_3:
                        return 2;
                }
                return 0;
            }
        });

        adapter.register(BannerItem.class, new BannerItemViewProvider());
        adapter.register(BangumiType.class,new BangumiTypeViewProvider());
        adapter.register(BangumiHeadItem.class,new BangumiHeadItemViewProvider());
        adapter.register(BangumiUpdate.class,new BangumiUpdateViewProvider());
        adapter.register(BangumiComplete.class,new BangumiCompleteViewProvider());
        adapter.register(BangumiRecommand.class,new BangumiRecommandViewProvider());


        adapter.setItems(items);
        mrecyclerView.addItemDecoration(new BaseDecoration(DensityUtils.Dp2px(getActivity(),10),items));
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
                        items.clear();
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
        List<BannerEntity> bannerlist = new ArrayList<>();
        for(HomeBangumiMainEntity.ResultBean.BannersBean banner:homeBangumiMainEntity.getResult().getBanners()){
            bannerlist.add(new BannerEntity(banner.getImg()));
        }

        items.add(new BannerItem(bannerlist));
        items.add(new BangumiType());
        items.add(new BangumiHeadItem("",homeBangumiMainEntity.getResult().getLatestUpdate().getUpdateCount()));
        for(int i =0;i<4;i++){
            items.add(new BangumiUpdate(homeBangumiMainEntity.getResult().getLatestUpdate().getList().get(i),i));
        }
        items.add(new BangumiHeadItem("",BangumiHeadItem.BANGUMI_TYPE_2,false));
        for(int i =0;i<3 ;i++){
            items.add(new BangumiComplete(homeBangumiMainEntity.getResult().getEnds().get(i),i));
        }

        items.add(new BangumiHeadItem("",BangumiHeadItem.BANGUMI_TYPE_3,false));

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
        for(int i =0;i< homeBangumiRecEntity.getResult().size();i++){
            items.add(new BangumiRecommand(homeBangumiRecEntity.getResult().get(i),i));
        }

    }
}
