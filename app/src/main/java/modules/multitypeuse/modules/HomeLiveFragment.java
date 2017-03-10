package modules.multitypeuse.modules;

import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import base.HomeBaseFragment;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import modules.multitypeuse.decorations.LiveItemDecoration;
import modules.multitypeuse.items.banner.BannerItem;
import modules.multitypeuse.items.banner.BannerItemViewProvider;
import modules.multitypeuse.items.base.ItemTypeValues;
import modules.multitypeuse.items.footer.FootItem;
import modules.multitypeuse.items.footer.FootItemViewProvider;
import modules.multitypeuse.items.live.LiveCenterItem;
import modules.multitypeuse.items.live.LiveCenterItemViewProvider;
import modules.multitypeuse.items.live.LiveFooterItem;
import modules.multitypeuse.items.live.LiveFooterItemViewProvider;
import modules.multitypeuse.items.live.LiveHeadItem;
import modules.multitypeuse.items.live.LiveHeadItemViewProvider;
import modules.multitypeuse.items.live.LiveTextItem;
import modules.multitypeuse.items.live.LiveTextItemViewProvider;
import modules.multitypeuse.items.live.LiveTypeItem;
import modules.multitypeuse.items.live.LiveTypeItemViewProvider;
import network.entity.HomeLiveEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import utils.DensityUtils;
import widget.banner.BannerEntity;

/**
 * Created by ly on 2017/3/9.
 */

public class HomeLiveFragment extends HomeBaseFragment {

    private List<BannerEntity> bannerList = new ArrayList<>();
    private MultiTypeAdapter adapter;

    private Items items = new Items();


    public static HomeLiveFragment newInstance(){
       HomeLiveFragment fragment = new HomeLiveFragment();
        return fragment;

    }

    @Override
    protected void initView() {
        super.initView();
        adapter = new MultiTypeAdapter();
        GridLayoutManager manager = new GridLayoutManager(getActivity(),12);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (ItemTypeValues.getChildTypes(items.get(position))){
                    case ItemTypeValues.VIEW_TYPE_HEADER:
                    case ItemTypeValues.VIEW_TYPE_FOOTER:
                    case ItemTypeValues.VIEW_TYPE_ITEM_1:
                        return 12;
                    case ItemTypeValues.VIEW_TYPE_ITEM_2:
                        return 6;
                    case ItemTypeValues.VIEW_TYPE_ITEM_4:
                        return 3;
                    default:
                        return 12;
                }

            }
        };

        adapter.register(BannerItem.class, new BannerItemViewProvider());
        adapter.register(LiveTypeItem.class, new LiveTypeItemViewProvider());
        adapter.register(LiveHeadItem.class,new LiveHeadItemViewProvider());
        adapter.register(LiveTextItem.class,new LiveTextItemViewProvider());
        adapter.register(LiveFooterItem.class,new LiveFooterItemViewProvider());
        adapter.register(FootItem.class,new FootItemViewProvider());
        adapter.register(LiveCenterItem.class,new LiveCenterItemViewProvider());

        adapter.setItems(items);

        manager.setSpanSizeLookup(spanSizeLookup);
        mrecyclerView.setLayoutManager(manager);
        mrecyclerView.addItemDecoration(new LiveItemDecoration(DensityUtils.Dp2px(getActivity(),10),items));
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
                        items.clear();
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
        items.add(new BannerItem(bannerList));


//        bannerView.buildBanner(bannerList);
    }
    private void addTypes(HomeLiveEntity homeLiveEntity) {
        List<HomeLiveEntity.DataBean.EntranceIconsBean> datalist = homeLiveEntity.getData().getEntranceIcons();
        for(int i =0;i<datalist.size() ;i++){
          items.add(new LiveTypeItem(datalist.get(i).getName(),datalist.get(i).getEntrance_icon().getSrc(),
                  Integer.valueOf(datalist.get(i).getEntrance_icon().getWidth()),
                  Integer.valueOf(datalist.get(i).getEntrance_icon().getHeight())));
        }
        items.add(new LiveTypeItem("全部分类",""));
        items.add(new LiveTypeItem("全部直播",""));

        items.add(new LiveCenterItem());

    }

    private void addItems(HomeLiveEntity homeLiveEntity){
        List<HomeLiveEntity.DataBean.PartitionsBean> datalist = homeLiveEntity.getData().getPartitions();
        for(HomeLiveEntity.DataBean.PartitionsBean bean :datalist){
            items.add(new LiveHeadItem(bean.getPartition().getName(),bean.getPartition().getCount()+"",bean.getPartition().getSub_icon().getSrc(),
                    Integer.valueOf(bean.getPartition().getSub_icon().getWidth()),
                    Integer.valueOf(bean.getPartition().getSub_icon().getHeight())));


            for(int i =0;i<4;i++){
                items.add(new LiveTextItem(bean.getLives().get(i),i));
            }

            items.add(new LiveFooterItem());

        }

        items.add(new FootItem());
    }
}
