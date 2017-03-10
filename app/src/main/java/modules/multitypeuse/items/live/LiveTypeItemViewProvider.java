package modules.multitypeuse.items.live;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;
import utils.GlideUtils;

/**
 * Created by ly on 2017/3/9.
 */
public class LiveTypeItemViewProvider
        extends ItemViewProvider<LiveTypeItem, LiveTypeItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_live_head_types, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull LiveTypeItem liveTypeItem) {
        holder.textView.setText(liveTypeItem.title);
        GlideUtils.loadImg(holder.textView.getContext(),liveTypeItem.src,holder.imageView,liveTypeItem.width,liveTypeItem.height,true);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_live_head_type)
        ImageView imageView;
        @BindView(R.id.tv_live_head_type)
        TextView textView;
        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}