package widget.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import modules.sections.SectionRecyclerAdapter;

/**
 * Created by ly on 2017/2/21.
 */

public class LiveItemDecoration  extends RecyclerView.ItemDecoration{


    private int spacing;

    public LiveItemDecoration( int spacing) {

        this.spacing = spacing;

    }

//    @Override
//    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        int position = parent.getChildAdapterPosition(view); // item position
//        int column = position % spanCount; // item column
//
//        if (includeEdge) {
//            outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
//            outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)
//
//            if (position < spanCount) { // top edge
//                outRect.top = spacing;
//            }
//            outRect.bottom = spacing; // item bottom
//        } else {
//            outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
//            outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
//            if (position >= spanCount) {
//                outRect.top = spacing; // item top
//            }
//        }
//    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        SectionRecyclerAdapter adapter = (SectionRecyclerAdapter) parent.getAdapter();
        switch (adapter.getSpanViewType(position)){
            case SectionRecyclerAdapter.VIEW_TYPE_ITEM_2:
                int _position  = adapter.getItemSectionPosition(position);
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


                break;
        }

    }
}
