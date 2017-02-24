package widget.listeners;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ly on 2017/2/25.
 */

public abstract class LinearRecyclerScroll extends RecyclerView.OnScrollListener {

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();

        int totalCount = recyclerView.getChildCount();
        int srartPosition = manager.findFirstVisibleItemPosition();
        int lastPosition = manager.findLastCompletelyVisibleItemPosition();
        if(srartPosition >= 0 && lastPosition >= totalCount -1){
            loadMore();
        }

    }

    public abstract void loadMore();

}
