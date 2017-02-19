package widget.banner;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ly on 2017/2/19.
 */

public class BannerAdapter extends PagerAdapter{

    private List<ImageView> imageViews;

    public BannerAdapter(List<ImageView> imageViews){
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int _position = position %= imageViews.size();
        if(_position <0){
            _position += imageViews.size();
        }

        ImageView imageView = imageViews.get(_position);
        ViewPager viewPager = (ViewPager) imageView.getParent();
        if(viewPager !=null){
            ViewGroup viewGroup = (ViewGroup) viewPager;
            viewGroup.removeView(imageView);
        }

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
