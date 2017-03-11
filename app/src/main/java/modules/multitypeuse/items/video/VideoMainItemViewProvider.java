package modules.multitypeuse.items.video;

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
public class VideoMainItemViewProvider
        extends ItemViewProvider<VideoMainItem, VideoMainItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_video_relate, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull VideoMainItem videoMainItem) {
        GlideUtils.loadImg(holder.cover.getContext(),videoMainItem.data.getPic(),holder.cover);
        holder.title.setText(videoMainItem.data.getTitle());
        holder.name.setText(videoMainItem.data.getOwner().getName());
        holder.playCount.setText(videoMainItem.data.getStat().getView()+"");
        holder.danmCount.setText(videoMainItem.data.getStat().getDanmaku()+"");
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.iv_video_relate)
        ImageView cover;
        @BindView(R.id.tv_video_relate_title)
        TextView title;
        @BindView(R.id.tv_video_relate_up_name)
        TextView name;
        @BindView(R.id.tv_video_relate_play_count)
        TextView playCount;
        @BindView(R.id.tv_video_relate_danm_count)
        TextView danmCount;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}