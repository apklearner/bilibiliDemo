package modules.home;

import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import base.HomeBaseFragment;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import widget.decoration.BaseDecoration;
import modules.multitypeuse.items.bangumi.BangumiHeadItem;
import modules.multitypeuse.items.bangumi.BangumiHeadItemViewProvider;
import modules.multitypeuse.items.bangumi.BangumiUpdate;
import modules.multitypeuse.items.bangumi.BangumiUpdateViewProvider;
import modules.multitypeuse.items.banner.BannerItem;
import modules.multitypeuse.items.banner.BannerItemViewProvider;
import modules.multitypeuse.items.base.ItemTypeValues;
import modules.multitypeuse.items.extra.FootItem;
import modules.multitypeuse.items.extra.FootItemViewProvider;
import modules.multitypeuse.items.extra.HeadItem;
import modules.multitypeuse.items.extra.HeadItemViewProvider;
import modules.multitypeuse.items.live.LiveHeadItem;
import modules.multitypeuse.items.live.LiveHeadItemViewProvider;
import modules.multitypeuse.items.live.LiveTextItem;
import modules.multitypeuse.items.live.LiveTextItemViewProvider;
import modules.multitypeuse.items.recommand.RecBangumiFoot;
import modules.multitypeuse.items.recommand.RecBangumiFootViewProvider;
import modules.multitypeuse.items.recommand.RecHotitem;
import modules.multitypeuse.items.recommand.RecHotitemViewProvider;
import modules.multitypeuse.items.recommand.RecTopicItem;
import modules.multitypeuse.items.recommand.RecTopicItemViewProvider;
import network.entity.HomeRecBannerEntity;
import network.entity.HomeRecContentEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import utils.DensityUtils;
import widget.banner.BannerEntity;

/**
 * Created by ly on 2017/3/11.
 */

public class HomeRecommandFragment extends HomeBaseFragment {


    private GridLayoutManager manager;
    private MultiTypeAdapter adapter;
    private Items items = new Items();

    public static HomeRecommandFragment newInstance(){
        HomeRecommandFragment instance = new HomeRecommandFragment();
        return instance;
    }



    @Override
    protected void initView() {
        super.initView();
        adapter = new MultiTypeAdapter();
        manager = new GridLayoutManager(getActivity(),2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (ItemTypeValues.getChildTypes(items.get(position))){
                    case ItemTypeValues.VIEW_TYPE_HEADER:
                    case ItemTypeValues.VIEW_TYPE_FOOTER:
                    case ItemTypeValues.VIEW_TYPE_BANNER:
                    case  ItemTypeValues.VIEW_TYPE_ITEM_1:
                    case ItemTypeValues.VIEW_TYPE_ITEM_1_1:
                        return 2;
                    case ItemTypeValues.VIEW_TYPE_ITEM_2:
                        return 1;
                }
                return 0;
            }
        });

        adapter.register(BannerItem.class,new BannerItemViewProvider());
        adapter.register(RecHotitem.class,new RecHotitemViewProvider());
        adapter.register(RecTopicItem.class,new RecTopicItemViewProvider());
        adapter.register(LiveTextItem.class,new LiveTextItemViewProvider());
        adapter.register(BangumiUpdate.class,new BangumiUpdateViewProvider());
        adapter.register(FootItem.class,new FootItemViewProvider());
        adapter.register(HeadItem.class,new HeadItemViewProvider());
        adapter.register(BangumiHeadItem.class,new BangumiHeadItemViewProvider());
        adapter.register(RecBangumiFoot.class,new RecBangumiFootViewProvider());
        adapter.register(LiveHeadItem.class,new LiveHeadItemViewProvider());


        adapter.setItems(items);

        mrecyclerView.addItemDecoration(new BaseDecoration(DensityUtils.Dp2px(getActivity(),10),items));
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

        items.add(new BannerItem(datalist));

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
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                refreshComplete();

                            }
                        });
    }

    private void loadContentData(HomeRecContentEntity homeRecContentEntity){
        for(HomeRecContentEntity.ResultBean bean : homeRecContentEntity.getResult()){
            if(bean.getType().equals("recommend") || bean.getType().equals("region")){
                boolean isRecommend = bean.getType().equals("recommend");
                if(isRecommend){
                    items.add(new HeadItem(bean.getHead().getTitle(),HeadItem.TYPE_ORDER));
                }else {
                    items.add(new HeadItem(bean.getHead().getTitle(),HeadItem.TYPE_COMMON));
                }

                for(int i =0;i<4 ;i++){
                    items.add(new RecHotitem(bean.getBody().get(i),i));
                }

                if(isRecommend){
                    items.add(new FootItem(FootItem.TYPE_ON_CHANGE));
                }else {
                    items.add(new FootItem(FootItem.TYPE_ON_COMMON));
                }



            }else if(bean.getType().equals("live")){

                items.add(new LiveHeadItem(bean.getHead().getTitle(),bean.getHead().getCount()+""));
                for(int i =0;i<4 ;i++){
                    items.add(new LiveTextItem(bean.getBody().get(i),i));
                }

                items.add(new FootItem(FootItem.TYPE_ON_COMMON));

            }else if(bean.getType().equals("bangumi_2")){

                items.add(new BangumiHeadItem("",BangumiHeadItem.BANGUMI_TYPE_1,true));

                for(int i =0;i<4;i++){
                    items.add(new BangumiUpdate(bean.getBody().get(i),i));
                }

                items.add(new RecBangumiFoot());

            }else if(bean.getType().equals("weblink")){
                    items.add(new HeadItem("话题",HeadItem.TYPE_TOPIC));
                    items.add(new RecTopicItem(bean.getBody().get(0).getCover()));

            }


        }

    }


    private String types[] = new String[]{"recommend","live","bangumi_2","weblink","region","activity"};

}



