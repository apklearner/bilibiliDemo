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
public class BangumiCompleteViewProvider
        extends ItemViewProvider<BangumiComplete, BangumiCompleteViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_bangumi_wanjie, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BangumiComplete bangumiComplete) {
        GlideUtils.loadImgWidthDefaultCorner(holder.cover.getContext(),bangumiComplete.data.getCover(),holder.cover);
        holder.title.setText(bangumiComplete.data.getTitle());
        holder.total.setText(bangumiComplete.data.getTotal_count()+"话全");
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_banguumi_cover)
        ImageView cover;
        @BindView(R.id.tv_bangumi_title)
        TextView title;
        @BindView(R.id.tv_bangumi_complete_num)
        TextView total;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}