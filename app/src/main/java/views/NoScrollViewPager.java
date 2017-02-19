package views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by ly on 2017/2/18.
 */

public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context) {
        this(context,null);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }
}
