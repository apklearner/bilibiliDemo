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
import widget.extra.CommonFootView;

/**
 * Created by ly on 2017/3/11.
 */
public class FootItemViewProvider
        extends ItemViewProvider<FootItem, FootItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_common_foot, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull FootItem footItem) {
        switch (footItem.type){
            case FootItem.TYPE_ON_CHANGE:
                holder.footView.onChangeShow();
                break;
            case FootItem.TYPE_ON_COMMON:
                holder.footView.onNormal();
                break;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.commonfooot)
        CommonFootView footView;
        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}