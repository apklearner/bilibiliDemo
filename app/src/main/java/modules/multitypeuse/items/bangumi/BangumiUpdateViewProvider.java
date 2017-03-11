package modules.multitypeuse.items.bangumi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;
import widget.extra.SectionBangumiItemView;

/**
 * Created by ly on 2017/3/11.
 */
public class BangumiUpdateViewProvider
        extends ItemViewProvider<BangumiUpdate, BangumiUpdateViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_bangum_items, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BangumiUpdate bangumiUpdate) {
        if(bangumiUpdate.isRecommand){
            holder.bangumiItemView.build(bangumiUpdate.data2.getCover(),
                    bangumiUpdate.data2.getTitle(),
                    bangumiUpdate.data2.getDesc1(),"","");

            return;
        }


        holder.bangumiItemView.build(bangumiUpdate.data.getCover(),
                bangumiUpdate.data.getTitle(),
                "第"+bangumiUpdate.data.getNewest_ep_index()+"话",
                bangumiUpdate.data.getLast_time(),
                bangumiUpdate.data.getWatchingCount());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bangumisection)
        SectionBangumiItemView bangumiItemView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}