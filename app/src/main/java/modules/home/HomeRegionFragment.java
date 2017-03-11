package modules.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import base.HomeBaseFragment;
import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ly on 2017/2/24.
 */

public class HomeRegionFragment extends HomeBaseFragment {

    private String titles[] = new String[]{
            "直播","番剧","动画",
            "音乐","舞蹈","游戏",
            "科技","生活","鬼畜",
            "时尚","娱乐","电影",
            "电视剧","游戏中心"};
    private int resIds[] = new int[]{
            R.drawable.ic_category_live,R.drawable.ic_category_t13,R.drawable.ic_category_t1,
            R.drawable.ic_category_t3,R.drawable.ic_category_t129,R.drawable.ic_category_t4,
            R.drawable.ic_category_t36,R.drawable.ic_category_t160,R.drawable.ic_category_t119,
            R.drawable.ic_category_t155,R.drawable.ic_category_t5,R.drawable.ic_category_t23,
            R.drawable.ic_category_t11,R.drawable.ic_category_game_center

    };

    private GridLayoutManager manager;
    private ReginAdapter adapter;


    public static HomeRegionFragment newInstance(){
        HomeRegionFragment instance = new HomeRegionFragment();
        return instance;
    }


    @Override
    protected void initView() {
        mswipeRefresh.setEnabled(false);
        manager = new GridLayoutManager(getActivity(),3);
        adapter = new ReginAdapter();
        mrecyclerView.setLayoutManager(manager);
        mrecyclerView.setAdapter(adapter);

    }

    @Override
    protected void loadData() {

    }


      class  ReginAdapter extends RecyclerView.Adapter<ReginAdapter.ItemViewHolder>{

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemViewHolder viewHolder = new ItemViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.item_home_region,null));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ReginAdapter.ItemViewHolder holder, int position) {
            holder.imageView.setImageResource(resIds[position]);
            holder.textView.setText(titles[position]);
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }



        class ItemViewHolder extends RecyclerView.ViewHolder{
            @BindView(R.id.iv_region_item)
            ImageView imageView;
            @BindView(R.id.tv_region_item)
            TextView textView;

            public ItemViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }

}
