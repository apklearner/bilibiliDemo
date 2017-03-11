package widget.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import me.drakeet.multitype.Items;
import modules.multitypeuse.items.base.BaseItems;
import modules.multitypeuse.items.base.ItemTypeValues;

/**
 * Created by ly on 2017/3/11.
 */

public class BaseDecoration extends RecyclerView.ItemDecoration{
    private int spacing;

    private Items items;

    public BaseDecoration(int spacing, Items items) {
        this.spacing = spacing;
        this.items = items;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        switch (ItemTypeValues.getChildTypes(items.get(position))){
            case ItemTypeValues.VIEW_TYPE_ITEM_1:
                solve1(outRect,((BaseItems) items.get(position)).position);
               break;
            case ItemTypeValues.VIEW_TYPE_ITEM_1_1:
                solve1_1(outRect);
                break;
            case ItemTypeValues.VIEW_TYPE_ITEM_2:
                solve2(outRect,((BaseItems) items.get(position)).position);
                Log.i("123","position item     "+((BaseItems) items.get(position)).position +"      " +items.get(position));
                break;
            case ItemTypeValues.VIEW_TYPE_ITEM_3:
                solve3(outRect,((BaseItems) items.get(position)).position);
                break;
        }


    }




    private void solve1(Rect outRect,int position){

        outRect.left = spacing;
        outRect.right = spacing;
        outRect.bottom = spacing/3;
        if(position != 0)
            outRect.top = spacing/3;
    }

    private void solve1_1(Rect outRect){

        outRect.left = spacing;
        outRect.right = spacing;
    }



    private void solve2(Rect outRect,int position){
        int maxColums =  1;
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
