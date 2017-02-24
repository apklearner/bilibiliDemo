package modules.sections.region;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;

/**
 * Created by ly on 2017/2/24.
 */

public class RegionSection extends HomeSections {
    private Context context;
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

    public RegionSection(Context context)
    {
        super(R.layout.item_home_region);
        this.context = context;
    }


    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        itemViewHolder.imageView.setImageResource(resIds[position]);
        itemViewHolder.textView.setText(titles[position]);
    }

    @Override
    public int getTotalItemCount() {
        return titles.length;
    }

    @Override
    public int getSectionType(int postion) {
        return SectionRecyclerAdapter.VIEW_TYPE_ITEM_3;
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
