package modules.sections;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ly on 2017/2/19.
 */

public abstract class HomeSections {

    protected  int resourseId;
    protected  int headsourceId;
    protected  int footSourceId;
    protected  boolean hasHeader;
    protected  boolean hasFooter;
    private int sectionNum;

    public HomeSections(int resourseId){
        this.resourseId = resourseId;
    }

    public HomeSections(int headerOrFooterRes,boolean isHeader){
        if(isHeader){
            this.headsourceId = headerOrFooterRes;
            hasHeader = true;
        }else {
            this.footSourceId = headerOrFooterRes;
            hasFooter = true;
        }

    }


    public HomeSections(int resourseId,int targetesourceid,boolean isHeader){
        this.resourseId = resourseId;
        if(isHeader){
            this.headsourceId = targetesourceid;
            hasHeader = true;
        }else {
            this.footSourceId = targetesourceid;
            hasFooter = true;
        }

    }

    public HomeSections(int resourseId,int headsourceId,int footSourceId){
        this.resourseId = resourseId;
        this.headsourceId = headsourceId;
        this.footSourceId = footSourceId;
        this.hasHeader = true;
        this.hasFooter = true;
    }

    public abstract int getTotalItemCount();

    public abstract int getSectionType(int postion);


    protected RecyclerView.ViewHolder onCreateItemHolder(View view){ return  null;}

    protected RecyclerView.ViewHolder onCreateHeaderHolder(View view){return  null;}

    protected RecyclerView.ViewHolder onCreateFooterHolder(View view){return null;}

    protected  void onBindItemView(RecyclerView.ViewHolder viewHolder,int position){}

    protected  void onBindHeaderView(RecyclerView.ViewHolder viewHolder,int position){}

    protected  void onBindFooterView(RecyclerView.ViewHolder viewHolder,int position){}


    public boolean isHasHeader() {
        return hasHeader;
    }

    public boolean isHasFooter() {
        return hasFooter;
    }

    public void setSectionNum(int sectionNum) {
        this.sectionNum = sectionNum;
    }

    public int getSectionNum() {
        return sectionNum;
    }

    public int getHeadsourceId() {
        return headsourceId;
    }

    public int getResourseId() {
        return resourseId;
    }

    public int getFootSourceId() {
        return footSourceId;
    }
}
