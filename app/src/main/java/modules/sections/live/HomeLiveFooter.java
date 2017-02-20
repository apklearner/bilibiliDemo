package modules.sections.live;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import bilibili.demoforbilibili.R;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeLiveFooter extends HomeSections {
    private Context context;

    public HomeLiveFooter(Context context){
        super(R.layout.section_live_foot);
        this.context = context;
    }


    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
//        super.onBindItemView(viewHolder, position);
    }

    @Override
    public int getTotalItemCount() {
        return 1;
    }

    @Override
    public int getSectionType(int postion) {
        return SectionRecyclerAdapter.VIEW_TYPE_ITEM_1;
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
