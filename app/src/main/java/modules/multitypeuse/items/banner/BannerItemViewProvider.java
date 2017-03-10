package modules.multitypeuse.items.banner;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;
import widget.banner.BannerView;

/**
 * Created by ly on 2017/3/9.
 */
public class BannerItemViewProvider
        extends ItemViewProvider<BannerItem, BannerItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_live_banner, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BannerItem bannerItem) {
        holder.bannerView.buildBanner(bannerItem.dataList);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.section_banner)
        BannerView bannerView;
        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}