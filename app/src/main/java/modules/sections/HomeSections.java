package modules.sections;

import android.support.v7.widget.RecyclerView;

/**
 * Created by ly on 2017/2/19.
 */

public abstract class HomeSections {

    protected  int resourseId;
    protected  int headsourceId;
    protected  int footSourceId;
    protected  boolean hasHeader;
    protected  boolean hasFooter;

    public HomeSections(int resourseId){
        this.resourseId = resourseId;
    }

    public HomeSections(int resourseId,int targetesourceid,boolean isHeder){
        this.resourseId = resourseId;
        if(isHeder){
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


    protected RecyclerView.ViewHolder onCreateItemHolder(){ return  null;};

    protected  void onBindItemView(){}

    protected  void onBindHeaderView(){}

    protected  void onBindFooterView(){}



    protected abstract int  getTotalCount();



}
