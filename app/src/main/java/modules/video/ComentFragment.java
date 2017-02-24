package modules.video;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import base.HomeBaseFragment;
import modules.adapters.VideoReplyAdapter;
import network.entity.ReplyChildEntity;
import network.entity.VideoReplyEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import widget.adapters.HeadRecyclerAdapter;
import widget.extra.SimpleFootView;
import widget.listeners.LinearRecyclerScroll;

/**
 * Created by ly on 2017/2/25.
 */

public class ComentFragment extends HomeBaseFragment {

    private LinearLayoutManager manager;
    private HeadRecyclerAdapter adapter;
    private List<ReplyChildEntity>  dataList = new ArrayList<>();
    private int pageSize = 20;
    private int pageNumber = 1;
    private String av;
    private boolean  isLoading = true;
    private SimpleFootView footView;


    public static ComentFragment newInstance(String avNum){
        ComentFragment instance = new ComentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("av",avNum);
        instance.setArguments(bundle);
        return instance;
    }


    @Override
    protected void getmArguments() {
        super.getmArguments();
        av = getArguments().getString("av");
    }

    public  void setData(String av){
        this.av = av;
    }

    @Override
    protected void initView() {
        super.initView();
        mswipeRefresh.setEnabled(false);
        dataList.clear();
        footView = new SimpleFootView(getContext());
        footView.setLoading();
        adapter = new HeadRecyclerAdapter(new VideoReplyAdapter(getActivity(),dataList));
        manager = new LinearLayoutManager(getActivity());
        mrecyclerView.setLayoutManager(manager);
        mrecyclerView.setAdapter(adapter);

        adapter.addFootView(footView);
        mrecyclerView.setOnScrollListener(new LinearRecyclerScroll() {
            @Override
            public void loadMore() {
                if(!isLoading){
                    isLoading = true;
                    pageNumber+=1;
                    loadData();
                }

            }
        });
    }

    @Override
    protected void loadData() {
        super.loadData();
        ApiGengder.getVideoCommentService()
                .getVideoReply(av,pageNumber+"",pageSize+"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<VideoReplyEntity>() {
                    @Override
                    public void call(VideoReplyEntity videoReplyEntity) {
                        if(videoReplyEntity.getData().getReplies().size() == 0){
                            footView.setNoMoreData();
                            return;
                        }

                        isLoading = false;
                        try {
                            if(pageNumber == 1)
                            dataList.addAll(videoReplyEntity.getData().getHots());
                            dataList.addAll(videoReplyEntity.getData().getReplies());
                            adapter.notifyDataSetChanged();
                        }catch (Exception e){
                            Log.i("CommentFragment",e.toString());

                        }

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        isLoading = false;
                        Log.i("CommentFragment",throwable.toString());
                    }
                });

    }





}
