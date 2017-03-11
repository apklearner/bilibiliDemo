package modules.multitypeuse.items.bangumi;

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
 * Created by ly on 2017/3/11.
 */
public class BangumiRecommandViewProvider
        extends ItemViewProvider<BangumiRecommand, BangumiRecommandViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_bangumi_recommand, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BangumiRecommand bangumiRecommand) {
        GlideUtils.loadImgWidthDefaultCorner(holder.cover.getContext(),bangumiRecommand.data.getCover(),holder.cover);
        holder.title.setText(bangumiRecommand.data.getTitle());
        holder.desc.setText(bangumiRecommand.data.getDesc());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_bangumi_item1_cover)
        ImageView cover;
        @BindView(R.id.tv_bangumi_item1_title)
        TextView title;
        @BindView(R.id.tv_bangumi_item1_des)
        TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}