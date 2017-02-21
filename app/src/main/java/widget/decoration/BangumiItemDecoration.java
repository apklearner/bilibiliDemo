package widget.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import modules.sections.SectionRecyclerAdapter;

/**
 * Created by ly on 2017/2/21.
 */

public class BangumiItemDecoration extends RecyclerView.ItemDecoration {

    private Context context;
    private int spacing;
    private int counts_2; //为偶数个
    public BangumiItemDecoration(Context context,int spacing,int counts_2){
        this.context = context;
        this.spacing =spacing;
        this.counts_2 = counts_2;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        SectionRecyclerAdapter adapter = (SectionRecyclerAdapter) parent.getAdapter();
        int _position  = adapter.getItemSectionPosition(position);
        switch (adapter.getSpanViewType(position)) {
            case SectionRecyclerAdapter.VIEW_TYPE_ITEM_1:
                solve1(outRect,position,_position);
                break;
            case SectionRecyclerAdapter.VIEW_TYPE_ITEM_2:
                solve2(outRect,_position);
                break;
            case SectionRecyclerAdapter.VIEW_TYPE_ITEM_3:
                solve3(outRect,_position);
                break;


        }
    }


    private void solve1(Rect outRect,int position,int _position){
        if(position <3) return;

        outRect.left = spacing;
        outRect.right = spacing;
        outRect.bottom = spacing/3;
        if(_position != 0)
        outRect.top = spacing/3;
    }


    private void solve2(Rect outRect,int position){
        int maxColums = counts_2/2 - 1;
        int colum  = position/2;
        int row = position%2;

        if(row == 0 ){
            outRect.left = spacing;
            outRect.right = spacing/2;
        }else {
            outRect.left = spacing/2;
            outRect.right = spacing;
        }

        if(colum == 0){
            outRect.bottom = spacing/2;
        }else if(colum == maxColums){
            outRect.top = spacing/2;
        }else {
            outRect.bottom = spacing/2;
            outRect.top = spacing/2;
        }

    }


    private void solve3(Rect outRect,int position){
        switch (position){
            case 0:
                outRect.left = spacing;
                outRect.right = spacing/3;
                break;
            case 1:
                outRect.left = spacing/3;
                outRect.right = spacing/3;
                break;
            case 2:
                outRect.left = spacing/3;
                outRect.right = spacing;
                break;
        }
    }
}
