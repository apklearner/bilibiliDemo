package modules.multitypeuse.items.live;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;
import network.entity.HomeLiveEntity;
import network.entity.HomeRecContentEntity;
import widget.extra.SectionLiveItemView;

/**
 * Created by ly on 2017/3/9.
 */
public class LiveTextItemViewProvider
        extends ItemViewProvider<LiveTextItem, LiveTextItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_live_item_view, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull LiveTextItem liveTextItem) {
        if(!liveTextItem.isRecommamd){
            HomeLiveEntity.DataBean.PartitionsBean.LivesBeanX data = liveTextItem.data;
            holder.sectionLive.build(data.getCover().getSrc(),
                    data.getOwner().getFace(),
                    data.getOwner().getName(),
                    data.getTitle(),
                    data.getOnline()+""
            );
        }else {
             HomeRecContentEntity.ResultBean.BodyBean resultBean = liveTextItem.resultBean;
            holder.sectionLive.build(resultBean.getCover(),
                    resultBean.getUp_face(),
                    resultBean.getUp(),
                    resultBean.getTitle(),
                    resultBean.getOnline()+"");
        }

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.section_live)
        SectionLiveItemView sectionLive;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}