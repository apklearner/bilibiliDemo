package modules.multitypeuse.items.bangumi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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
public class BangumiHeadItemViewProvider
        extends ItemViewProvider<BangumiHeadItem, BangumiHeadItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_header_common, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BangumiHeadItem bangumiHeadItem) {
            switch (bangumiHeadItem.type){
                case BangumiHeadItem.BANGUMI_TYPE_1:
                    holder.commonHeaderView.onBangumi();
                    holder.commonHeaderView.loadIconAndTitle(R.drawable.ic_launcher,"新番连载");

                    if(bangumiHeadItem.isRecommand){
                        holder.commonHeaderView.onEnter();
                        holder.commonHeaderView.setRightBtnText("更多");
                        return;
                    }
                    SpannableStringBuilder stringBuilder = new SpannableStringBuilder("今日更新"+bangumiHeadItem.updateCount);
                    ForegroundColorSpan span = new ForegroundColorSpan(holder.commonHeaderView.getContext().getResources().getColor(R.color.colorPrimary));
                    stringBuilder.setSpan(span,stringBuilder.length()-1,stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    holder.commonHeaderView.setBangumiNum(stringBuilder);

                    break;
                case BangumiHeadItem.BANGUMI_TYPE_2:
                    holder.commonHeaderView.onBangumi();
                    holder.commonHeaderView.loadIconAndTitle(R.drawable.ic_launcher,"番剧推荐");
                    break;
                case BangumiHeadItem.BANGUMI_TYPE_3:
                    holder.commonHeaderView.onEnter();
                    holder.commonHeaderView.loadIconAndTitle(R.drawable.ic_launcher,"完结动画");
                    break;

            }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.commonheader)
            CommonHeaderView commonHeaderView;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);

        }
    }
}