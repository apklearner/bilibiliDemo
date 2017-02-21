package modules.sections.bangumi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import bilibili.demoforbilibili.R;
import modules.sections.HomeSections;
import modules.sections.SectionRecyclerAdapter;

/**
 * Created by ly on 2017/2/21.
 */

public class HomeBangumiTypeSection extends HomeSections {

    private Context context;
    public HomeBangumiTypeSection(Context context){
        super(R.layout.section_bangumi_type);
        this.context = context;
    }


    @Override
    protected RecyclerView.ViewHolder onCreateItemHolder(View view) {
//        return super.onCreateItemHolder(view);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder viewHolder, int position) {
        super.onBindItemView(viewHolder, position);
    }

    @Override
    public int getTotalItemCount() {
        return 1;
    }

    @Override
    public int getSectionType(int postion) {
        return SectionRecyclerAdapter.VIEW_TYPE_ITEM_1;
    }

    class ViewHolder extends  RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
