package widget.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.drakeet.multitype.Items;
import modules.multitypeuse.items.base.BaseItems;
import modules.multitypeuse.items.base.ItemTypeValues;

/**
 * Created by ly on 2017/2/24.
 */

public class VideoAbstractDecoration extends RecyclerView.ItemDecoration {

    private int spacing;
    private Items items;
    public VideoAbstractDecoration(int spacing, Items items){
        this.spacing = spacing;
        this.items = items;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);

        switch (ItemTypeValues.getChildTypes(items.get(position))){
            case ItemTypeValues.VIEW_TYPE_ITEM_1:
                outRect.left = spacing;
                outRect.right = spacing;
                outRect.bottom = spacing/2;
                if(((BaseItems)items.get(position)).position == 0){
                  outRect.top = 0;
                }else {
                    outRect.top = spacing/2;
                }


                break;
        }

    }
}
