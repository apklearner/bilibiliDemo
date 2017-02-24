package widget.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly on 2017/2/25.
 */

public class HeadRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerView.Adapter mWrapperAdapter;
    private List<View> headViews = new ArrayList<>();
    private List<View> footViews = new ArrayList<>();
    private int HEAD_TYPE_START = 100;
    private int FOOT_TYPE_START = 120;

    public HeadRecyclerAdapter(RecyclerView.Adapter adapter){
        super();
        if(mWrapperAdapter!=null) mWrapperAdapter.unregisterAdapterDataObserver(observer);
        mWrapperAdapter = adapter;
        mWrapperAdapter.registerAdapterDataObserver(observer);
    }


    public void setWrapperAdapter(RecyclerView.Adapter adapter){
        if(mWrapperAdapter!=null) mWrapperAdapter.unregisterAdapterDataObserver(observer);
        mWrapperAdapter = adapter;
        adapter.registerAdapterDataObserver(observer);
    }


    public void addHeadView(View view){
        headViews.add(view);
    }

    public void addFootView(View view){
        footViews.add(view);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if(viewType >= HEAD_TYPE_START && viewType <FOOT_TYPE_START){
           return new StaticViewHolder(headViews.get(viewType - HEAD_TYPE_START));
       }else if(viewType >=FOOT_TYPE_START){
           return new StaticViewHolder(footViews.get(viewType - FOOT_TYPE_START));
       }else {
           return mWrapperAdapter.onCreateViewHolder(parent,viewType);
       }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      if(position >= headViews.size() && position < getItemCount() -footViews.size()){
          mWrapperAdapter.onBindViewHolder(holder,position - headViews.size());
      }
    }


    @Override
    public int getItemViewType(int position) {
       if(position < headViews.size()){
           return HEAD_TYPE_START + position;

       }else if( headViews.size()<= position && position <getItemCount() -footViews.size() ) {
           return mWrapperAdapter.getItemViewType(position - headViews.size());
       }else {
           return FOOT_TYPE_START + position - mWrapperAdapter.getItemCount() - headViews.size();
       }

    }

    @Override
    public int getItemCount() {
        return mWrapperAdapter.getItemCount() +headViews.size() + footViews.size();
    }


    private RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            super.onItemRangeChanged(positionStart + headViews.size(), itemCount);
//            notifyItemRangeChanged(positionStart + headViews.size(),itemCount);
        }


        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart +headViews.size(), itemCount);
//            notifyItemRangeInserted(positionStart + headViews.size(),itemCount);
        }

    };


    class StaticViewHolder extends RecyclerView.ViewHolder{

        public StaticViewHolder(View itemView) {
            super(itemView);
        }
    }

}
