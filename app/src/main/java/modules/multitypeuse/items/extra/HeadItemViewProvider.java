package modules.multitypeuse.items.extra;

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
 * Created by ly on 2017/3/11.
 */
public class HeadItemViewProvider
        extends ItemViewProvider<HeadItem, HeadItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_header_common, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull HeadItem headItem) {
        switch (headItem.type){
            case HeadItem.TYPE_TOPIC:
                holder.commonHeaderView.onlyIconTitle();
                break;
            case HeadItem.TYPE_ORDER:
                holder.commonHeaderView.onOrder();
                break;
            case HeadItem.TYPE_COMMON:
                holder.commonHeaderView.onEnter();
                break;
        }
        holder.commonHeaderView.loadOnlyTitle(headItem.title);

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