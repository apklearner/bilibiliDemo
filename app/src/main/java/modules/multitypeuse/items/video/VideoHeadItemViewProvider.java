package modules.multitypeuse.items.video;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import me.drakeet.multitype.ItemViewProvider;
import utils.GlideUtils;

/**
 * Created by ly on 2017/3/11.
 */
public class VideoHeadItemViewProvider
        extends ItemViewProvider<VideoHeadItem, VideoHeadItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.section_video_abstract_head, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull VideoHeadItem videoHeadItem) {
        final Context context = holder.title.getContext();
        holder.title.setText(videoHeadItem.data.getTitle());
        holder.playCount.setText(videoHeadItem.data.getStat().getView()+"");
        holder.danmCount.setText(videoHeadItem.data.getStat().getDanmaku()+"");
        holder.content.setText(videoHeadItem.data.getDesc());
        holder.tvShare.setText(videoHeadItem.data.getStat().getShare()+"");
        holder.tvCoin.setText(videoHeadItem.data.getStat().getCoin()+"");
        holder.tvCollect.setText(videoHeadItem.data.getStat().getFavorite()+"");
        GlideUtils.loadImg(context,videoHeadItem.data.getOwner().getFace(),holder.ivUpIcon,new CropCircleTransformation(context));
        holder.tvUpName.setText(videoHeadItem.data.getOwner().getName());
        holder.tvTime.setText(videoHeadItem.data.getCtime()+"");
        holder.tagFlowLayout.setAdapter(new TagAdapter<String>(videoHeadItem.data.getTags()) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_tags,null);
                TextView title = (TextView) view.findViewById(R.id.tv_tags);
                title.setText(s);
                return view;
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_video_abstract_title)
        TextView title;
        @BindView(R.id.tv_video_abstract_play_count)
        TextView playCount;
        @BindView(R.id.tv_video_abstract_danm_count)
        TextView danmCount;
        @BindView(R.id.tv_video_abstract_content)
        TextView content;
        @BindView(R.id.tv_vide_abstract_share)
        TextView tvShare;
        @BindView(R.id.iv_vide_abstract_share)
        ImageView ivShare;
        @BindView(R.id.tv_vide_abstract_coin)
        TextView tvCoin;
        @BindView(R.id.iv_vide_abstract_coin)
        ImageView ivCoin;
        @BindView(R.id.tv_vide_abstract_collect)
        TextView tvCollect;
        @BindView(R.id.iv_vide_abstract_collect)
        ImageView ivCollect;
        @BindView(R.id.iv_video_abstract_up_icon)
        ImageView ivUpIcon;
        @BindView(R.id.tv_video_abstract_up_name)
        TextView tvUpName;
        @BindView(R.id.tv_video_abstract_up_time)
        TextView tvTime;
        @BindView(R.id.tv_video_abstract_focus)
        TextView tvFocus;
        @BindView(R.id.tags_video_abstract)
        TagFlowLayout tagFlowLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}