package modules.multitypeuse.decorations;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.drakeet.multitype.Items;
import modules.multitypeuse.items.live.LiveTextItem;

/**
 * Created by ly on 2017/3/9.
 */

public class LiveItemDecoration extends RecyclerView.ItemDecoration{

    private int spacing;


    private Items items;

    public LiveItemDecoration(int spacing, Items items) {

        this.spacing = spacing;
        this.items = items;

    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if(items.get(position) instanceof LiveTextItem){
            int _position = ((LiveTextItem) items.get(position)).position;
            int column  = _position/2;
                int row = _position%2;

                if (row == 0) {
                    outRect.left = spacing;
                    outRect.right = spacing/2;

                }else {
                    outRect.left = spacing/2;
                    outRect.right = spacing;

                }

                if(column ==0){
                    outRect.bottom = spacing/2 -1;
                }else {
                    outRect.top = spacing/2 -1;
                }
        }


    }
}
