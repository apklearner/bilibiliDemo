package modules.video;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import base.BaseFramgment;
import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import network.entity.VideoDetailEntity;
import utils.GlideUtils;

/**
 * Created by ly on 2017/2/24.
 */

public class AbstractFragmentTemp extends BaseFramgment {

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

    private VideoDetailEntity data;
    private TagAdapter<String> adapter;
    private List<String> tags = new ArrayList<>();

    public static AbstractFragmentTemp newInstance(){
        AbstractFragmentTemp instance = new AbstractFragmentTemp();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("data",data);
//        instance.setArguments(bundle);
        return instance;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public  void setData(VideoDetailEntity data){
        this.data = data;
        loadCustonData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        data = (VideoDetailEntity) getArguments().getSerializable("data");
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_video_abstract,container,false);
    }


    @Override
    protected void initView() {
        super.initView();
        adapter = new TagAdapter<String>(tags) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.item_tags,null);
                TextView title = (TextView) view.findViewById(R.id.tv_tags);
                title.setText(s);
                return view;
            }
        };
        tagFlowLayout.setAdapter(adapter);

    }


    protected void loadCustonData() {
        title.setText(data.getData().getTitle());
        playCount.setText(data.getData().getStat().getView()+"");
        danmCount.setText(data.getData().getStat().getDanmaku()+"");
        content.setText(data.getData().getDesc());
        tvShare.setText(data.getData().getStat().getShare()+"");
        tvCoin.setText(data.getData().getStat().getCoin()+"");
        tvCollect.setText(data.getData().getStat().getFavorite()+"");
        GlideUtils.loadImg(getActivity(),data.getData().getOwner().getFace(),ivUpIcon,new CropCircleTransformation(getActivity()));
        tvUpName.setText(data.getData().getOwner().getName());
        tvTime.setText(data.getData().getCtime()+"");
        tags.addAll(data.getData().getTags());
        adapter.notifyDataChanged();

    }




    private class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =LayoutInflater.from(getActivity()).inflate(R.layout.item_video_relate,null);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder holder1 = (ViewHolder) holder;
            GlideUtils.loadImg(getActivity(),data.getData().getRelates().get(position).getPic(),holder1.cover);
            holder1.title.setText(data.getData().getRelates().get(position).getTitle());
            holder1.name.setText(data.getData().getRelates().get(position).getOwner().getName());
            holder1.playCount.setText(data.getData().getRelates().get(position).getStat().getView()+"");
            holder1.danmCount.setText(data.getData().getRelates().get(position).getStat().getDanmaku()+"");
        }

        @Override
        public int getItemCount() {
            return data.getData().getRelates().size();
        }
    }



    class ViewHolder extends RecyclerView.ViewHolder{

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
