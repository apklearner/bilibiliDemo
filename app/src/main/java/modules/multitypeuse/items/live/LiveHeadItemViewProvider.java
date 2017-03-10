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
import widget.extra.CommonHeaderView;

/**
 * Created by ly on 2017/3/9.
 */
public class LiveHeadItemViewProvider
        extends ItemViewProvider<LiveHeadItem, LiveHeadItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_header_common, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull LiveHeadItem liveHeadItem) {
        if(liveHeadItem.isRecommand){
            holder.commonHeaderView.loadOnlyTitle(liveHeadItem.title);
            holder.commonHeaderView.setLiveNum("更多"+ liveHeadItem.liveNum+"个直播");
            return;
        }

        holder.commonHeaderView.loadIconAndTitle(liveHeadItem.src,liveHeadItem.title,
                liveHeadItem.width,liveHeadItem.height);
        holder.commonHeaderView.setLiveNum("更多"+liveHeadItem.liveNum+"个直播");
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.commonheader)
        CommonHeaderView commonHeaderView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            commonHeaderView.onLive();
        }
    }
}