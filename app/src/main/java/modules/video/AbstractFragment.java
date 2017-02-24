package modules.video;

import android.support.v7.widget.LinearLayoutManager;

import base.HomeBaseFragment;
import modules.sections.SectionRecyclerAdapter;
import modules.sections.video.VideoAbstractSection;
import network.entity.VideoDetailEntity;
import utils.DensityUtils;
import widget.decoration.VideoAbstractDecoration;

/**
 * Created by ly on 2017/2/24.
 */

public class AbstractFragment extends HomeBaseFragment {

    private SectionRecyclerAdapter adapter;
    private LinearLayoutManager manager;

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
        adapter = new SectionRecyclerAdapter();
        mrecyclerView.addItemDecoration(new VideoAbstractDecoration(DensityUtils.Dp2px(getActivity(),10)));
        mrecyclerView.setAdapter(adapter);
    }

    public void setData(VideoDetailEntity data){
        adapter.addSections(new VideoAbstractSection(getActivity(),data));
        adapter.notifyDataSetChanged();
    }
}
