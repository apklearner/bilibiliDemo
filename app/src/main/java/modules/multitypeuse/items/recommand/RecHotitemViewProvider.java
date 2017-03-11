package modules.multitypeuse.items.recommand;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;
import network.entity.HomeRecContentEntity;
import utils.IntentHelper;
import widget.extra.RecItemView;

/**
 * Created by ly on 2017/3/11.
 */
public class RecHotitemViewProvider
        extends ItemViewProvider<RecHotitem, RecHotitemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_rec_hot_items, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, @NonNull RecHotitem recHotitem) {
        final HomeRecContentEntity.ResultBean.BodyBean bodyBean =recHotitem.data;
        holder.recItemView.build(bodyBean.getCover(),
                bodyBean.getTitle(),bodyBean.getPlay(),bodyBean.getDanmaku(),
                bodyBean.getWidth(),bodyBean.getHeight()
        );

        holder.recItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentHelper.openVideoDetail(holder.recItemView.getContext(),bodyBean.getParam());
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rec_item_view)
        RecItemView recItemView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}