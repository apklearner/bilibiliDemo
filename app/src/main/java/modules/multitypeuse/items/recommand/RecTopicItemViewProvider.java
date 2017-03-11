package modules.multitypeuse.items.recommand;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;
import utils.GlideUtils;

/**
 * Created by ly on 2017/3/11.
 */
public class RecTopicItemViewProvider
        extends ItemViewProvider<RecTopicItem, RecTopicItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_topic, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull RecTopicItem recTopicItem) {
        GlideUtils.loadImgWidthDefaultCorner(holder.cover.getContext(),recTopicItem.cover,holder.cover);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_section_topic)
        ImageView cover;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}