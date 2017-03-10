package modules.multitypeuse.items.live;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bilibili.demoforbilibili.R;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by ly on 2017/3/9.
 */
public class LiveCenterItemViewProvider
        extends ItemViewProvider<LiveCenterItem, LiveCenterItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_live_middle, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull LiveCenterItem liveCenterItem) {

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}