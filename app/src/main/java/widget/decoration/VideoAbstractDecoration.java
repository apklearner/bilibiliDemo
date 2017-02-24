package widget.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import modules.sections.SectionRecyclerAdapter;

/**
 * Created by ly on 2017/2/24.
 */

public class VideoAbstractDecoration extends RecyclerView.ItemDecoration {

    private int spacing;
    public VideoAbstractDecoration(int spacing){
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        SectionRecyclerAdapter adapter = (SectionRecyclerAdapter) parent.getAdapter();
        int _position  = adapter.getItemSectionPosition(position);
        switch (adapter.getSpanViewType(position)){
            case SectionRecyclerAdapter.VIEW_TYPE_ITEM_1:
                outRect.left = spacing;
                outRect.right = spacing;
                outRect.bottom = spacing/2;
                if(_position == 0){
                  outRect.top = 0;
                }else {
                    outRect.top = spacing/2;
                }


                break;
        }

    }
}
