package base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bilibili.demoforbilibili.R;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ly on 2017/2/18.
 */

public abstract class HomeBaseFragment extends  BaseFramgment {

    protected View view;
    private Unbinder unbinder;
    protected SwipeRefreshLayout mswipeRefresh;
    protected RecyclerView mrecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fg_base_recyclerview,container,false);
        mswipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.home_swiperefresh);
        mrecyclerView = (RecyclerView) view.findViewById(R.id.home_recycle);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this,view);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        loadData();
    }

    protected  void loadData(){};
    protected  void initView(){};


}
