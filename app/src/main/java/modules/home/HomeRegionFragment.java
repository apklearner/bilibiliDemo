package modules.home;

import android.support.v7.widget.GridLayoutManager;

import base.HomeBaseFragment;
import modules.sections.SectionRecyclerAdapter;
import modules.sections.region.RegionSection;

/**
 * Created by ly on 2017/2/24.
 */

public class HomeRegionFragment extends HomeBaseFragment {

    private GridLayoutManager manager;
    private SectionRecyclerAdapter adapter;


    public static HomeRegionFragment newInstance(){
        HomeRegionFragment instance = new HomeRegionFragment();
        return instance;
    }


    @Override
    protected void initView() {
        mswipeRefresh.setEnabled(false);
        manager = new GridLayoutManager(getActivity(),3);
        adapter = new SectionRecyclerAdapter();
        mrecyclerView.setLayoutManager(manager);
        mrecyclerView.setAdapter(adapter);

    }

    @Override
    protected void loadData() {
        adapter.addSections(new RegionSection(getActivity()));
        adapter.notifyDataSetChanged();

    }
}
