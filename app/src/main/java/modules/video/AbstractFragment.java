package modules.video;

import android.support.v7.widget.LinearLayoutManager;

import base.HomeBaseFragment;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import modules.multitypeuse.items.video.VideoHeadItem;
import modules.multitypeuse.items.video.VideoHeadItemViewProvider;
import modules.multitypeuse.items.video.VideoMainItem;
import modules.multitypeuse.items.video.VideoMainItemViewProvider;
import network.entity.VideoDetailEntity;
import utils.DensityUtils;
import widget.decoration.VideoAbstractDecoration;

/**
 * Created by ly on 2017/2/24.
 */

public class AbstractFragment extends HomeBaseFragment {

    private MultiTypeAdapter adapter;
    private LinearLayoutManager manager;
    private Items items = new Items();

    public static AbstractFragment newInstance(){
        AbstractFragment instance = new AbstractFragment();
        return instance;
    }


    @Override
    protected void initView() {
        super.initView();
        mswipeRefresh.setEnabled(false);
        manager = new LinearLayoutManager(getActivity());
        mrecyclerView.setLayoutManager(manager);
        adapter = new MultiTypeAdapter();

        adapter.register(VideoHeadItem.class,new VideoHeadItemViewProvider());
        adapter.register(VideoMainItem.class,new VideoMainItemViewProvider());
        adapter.setItems(items);

        mrecyclerView.addItemDecoration(new VideoAbstractDecoration(DensityUtils.Dp2px(getActivity(),10),items));
        mrecyclerView.setAdapter(adapter);
    }

    public void setData(VideoDetailEntity data){
        items.add(new VideoHeadItem(data.getData()));
        for(int i =0;i< data.getData().getRelates().size();i++){
            items.add(new VideoMainItem(data.getData().getRelates().get(i),i));
        }
        adapter.notifyDataSetChanged();
    }
}
