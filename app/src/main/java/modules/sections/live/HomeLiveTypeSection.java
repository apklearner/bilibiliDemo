package modules.sections.live;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;
import network.entity.HomeLiveEntity;

/**
 * Created by ly on 2017/2/20.
 */

public class HomeLiveTypeSection extends HomeSections {

    private List<HomeLiveEntity.DataBean.EntranceIconsBean> datalist = new ArrayList<>();
    private int width;
    private int height;

    public HomeLiveTypeSection(List<HomeLiveEntity.DataBean.EntranceIconsBean> datalist ){
        super(R.layout.section_live_head_types);
        this.datalist = datalist;

    }


    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
        LiveTypeHolder liveTypeHolder  = new LiveTypeHolder(view);
        return liveTypeHolder;
    }


    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
//        super.onBindItemView(viewHolder, position);
        LiveTypeHolder liveTypeHolder = (LiveTypeHolder) viewHolder;

        if(position < datalist.size()) {
            width = Integer.valueOf(datalist.get(position).getEntrance_icon().getWidth());
            height = Integer.valueOf(datalist.get(position).getEntrance_icon().getHeight());
            liveTypeHolder.textView.setText(datalist.get(position).getName());
            Glide.with(liveTypeHolder.textView.getContext())
                    .load(datalist.get(position).getEntrance_icon().getSrc())
                    .skipMemoryCache(true)
                    .override(width, height)
                    .placeholder(R.drawable.ic_launcher)
                    .dontAnimate()
                    .into(liveTypeHolder.imageView);
        }else {
            String content = position == datalist.size()?"全部分类":"全部直播";
            liveTypeHolder.textView.setText(content);
            Glide.with(liveTypeHolder.imageView.getContext())
                    .load("")
                    .skipMemoryCache(true)
                    .override(width, height)
                    .placeholder(R.drawable.ic_launcher)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(liveTypeHolder.imageView);

        }

    }


    @Override
    public int getTotalItemCount() {
        return datalist.size() + 2;
    }

    @Override
    public int getSectionType(int position) {
        return SectionRecyclerAdapter.VIEW_TYPE_ITEM_4;
    }

    class LiveTypeHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_live_head_type)
        ImageView imageView;
        @BindView(R.id.tv_live_head_type)
        TextView textView;

        public LiveTypeHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
