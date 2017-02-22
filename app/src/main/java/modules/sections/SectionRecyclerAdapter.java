package modules.sections;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly on 2017/2/20.
 */

public class SectionRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final static int VIEW_TYPE_HEADER = 0; //占1
    public final static int VIEW_TYPE_FOOTER = 1; //占1
    public final static int VIEW_TYPE_ITEM_1= 2; //占1
    public final static int VIEW_TYPE_ITEM_2 = 3; //占1/2
    public final static int VIEW_TYPE_ITEM_3 = 4; //占1/3
    public final static int VIEW_TYPE_ITEM_4 = 5; //占1/4

    private final int VIEW_TYPE_COUNT = 6;

    private int sectionStart = 0;

    private List<HomeSections> sectionList = new ArrayList<>();


    public void addSections(HomeSections section){
        if(sectionList == null) sectionList = new ArrayList<>();
        section.setSectionNum(sectionStart++);
        sectionList.add(section);
    }





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HomeSections sections = null;
        for(HomeSections msection:sectionList) {
            if(viewType>= msection.getSectionNum()*VIEW_TYPE_COUNT &&viewType< msection.getSectionNum()*VIEW_TYPE_COUNT +VIEW_TYPE_COUNT){
                sections = msection;
            }
        }
            switch (viewType%VIEW_TYPE_COUNT) {
                case VIEW_TYPE_HEADER:
                    return sections.onCreateHeaderHolder(LayoutInflater.from(parent.getContext()).inflate(sections.getHeadsourceId(),null));
                case VIEW_TYPE_FOOTER:
                    return sections.onCreateFooterHolder(LayoutInflater.from(parent.getContext()).inflate(sections.getFootSourceId(),null));
                case VIEW_TYPE_ITEM_1:
                case VIEW_TYPE_ITEM_2:
                case VIEW_TYPE_ITEM_3:
                case VIEW_TYPE_ITEM_4:
                    return sections.onCreateItemHolder(LayoutInflater.from(parent.getContext()).inflate(sections.getResourseId(),null));

            }

        throw new RuntimeException("section adapter create holder error");
    }

    private long currentMills1= 0;
    private long currentMills2= 0;
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            HomeSections sections = getSectionFormPos(position);
        switch (getItemViewType(position)%VIEW_TYPE_COUNT){
            case VIEW_TYPE_HEADER:
                 sections.onBindHeaderView(holder,getPositionInSections(position));
                break;
            case VIEW_TYPE_FOOTER:
                 sections.onBindFooterView(holder,getPositionInSections(position));
                break;
            case VIEW_TYPE_ITEM_1:
            case VIEW_TYPE_ITEM_2:
            case VIEW_TYPE_ITEM_3:
            case VIEW_TYPE_ITEM_4:
                 sections.onBindItemView(holder,getPositionInSections(position));
                break;
        }


    }



    public  int getSpanViewType(int position){
        return getItemViewType(position)%VIEW_TYPE_COUNT;
    }


    @Override
    public int getItemViewType(int position) {

        int currentCount = 0;
        for(HomeSections msection:sectionList){
            int sectionNum = msection.getSectionNum()*VIEW_TYPE_COUNT ;
            if(position >= currentCount && position<= currentCount+msection.getTotalItemCount()-1){

                if(position > currentCount && position <currentCount + msection.getTotalItemCount()-1){
                    return sectionNum +  msection.getSectionType(getPositionInSections(position));
                }

                if(position == currentCount ){
                    if(msection.hasHeader){
                        return sectionNum + VIEW_TYPE_HEADER;
                    }else {
                        return sectionNum +  msection.getSectionType(getPositionInSections(position));
                    }

                }

                if(position == currentCount + msection.getTotalItemCount() -1){
                    if(msection.hasFooter){
                        return sectionNum + VIEW_TYPE_FOOTER;
                    }else {
                        return sectionNum +  msection.getSectionType(getPositionInSections(position));
                    }
                }

            }

            currentCount += msection.getTotalItemCount();
        }
        throw new RuntimeException("section adapter get view type error");

    }

    private HomeSections getSectionFormPos(int position) {
        int currentCount = 0;
        for (HomeSections msection : sectionList) {
            if (position >= currentCount && position <= currentCount + msection.getTotalItemCount() - 1) {
                return msection;
            }
            currentCount += msection.getTotalItemCount();
        }
        return null;
    }

    /**
     * 获取整体position在单个section里面位置(0 -->section.size -1)
     * @param position
     * @return
     */
    private int getPositionInSections(int position){
        int currentCount = 0;
        for (HomeSections msection : sectionList) {
            if (position >= currentCount && position <= currentCount + msection.getTotalItemCount() - 1) {
                return position - currentCount;
            }
            currentCount += msection.getTotalItemCount();
        }
        return -1;

    }

    public int getItemSectionPosition(int position){
        return getPositionInSections(position) -1;
    }


    @Override
    public int getItemCount() {
        int count = 0;
        for(HomeSections msection:sectionList){
            count += msection.getTotalItemCount();
        }
        return count;
    }
}
