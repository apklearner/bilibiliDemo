package widget.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

import bilibili.demoforbilibili.R;
import utils.DensityUtils;

/**
 * Created by ly on 2017/2/19.
 */

public class BannerView  extends RelativeLayout implements ViewPager.OnPageChangeListener {

   private ViewPager bannerPager;
   private LinearLayout llDots;
   private List<ImageView> imageList = new ArrayList<>();
//   private List<View> dotsList = new ArrayList<>();
   private  List<BannerEntity> dataList;
   private BannerAdapter adapter;
   private ScheduledExecutorService scheduledExecutorService;
   private int currentPositon = 0;
    private boolean isStop = false;

    public BannerView(Context context) {
        this(context,null);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public BannerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.layout_banner,this,true);
        bannerPager = (ViewPager) findViewById(R.id.vp_banner);
        llDots = (LinearLayout) findViewById(R.id.ll_banner);
//        scheduledExecutorService = Executors.newScheduledThreadPool(1);
    }

    public void buildBanner(List<BannerEntity> dataList){
        imageList.clear();
        this.dataList = dataList;
        if(dataList == null || dataList.size() ==0) return;
//        int tempCount = dataList.size() ==2?4:dataList.size();
        for(int i= 0 ;i< dataList.size() ;i++){
//            ImageView imageView = new ImageView(getContext());
////            imageView.setLayoutParams(new MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//            Glide.with(getContext())
//                    .load(dataList.get(i).getImgUrl())
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .placeholder(R.drawable.ic_launcher)
//                    .centerCrop()
//                    .dontAnimate()
//                    .into(imageView);
            ImageView imageView = createImageView(dataList.get(i).getImgUrl());
            imageList.add(imageView);
        }

        if(dataList.size() == 2){
            imageList.add(createImageView(dataList.get(0).getImgUrl()));
            imageList.add(createImageView(dataList.get(1).getImgUrl()));
        }

        initDots();
        resetIndiactor(currentPositon);

        adapter = new BannerAdapter(imageList);
        bannerPager.setAdapter(adapter);
        bannerPager.setOnPageChangeListener(this);
//        bannerPager.setOffscreenPageLimit(5);
//        scheduledExecutorService.scheduleAtFixedRate(taskRunnable,3000,3000, TimeUnit.MILLISECONDS);
        bannerPager.setCurrentItem(currentPositon);
        handler.removeCallbacksAndMessages(null);
        handler.sendEmptyMessageDelayed(0,10000);

    }

    private void initDots(){
        llDots.removeAllViews();
        for(int i =0;i<dataList.size();i++){
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(DensityUtils.Dp2px(getContext(),5),DensityUtils.Dp2px(getContext(),5)));
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
            params.leftMargin = 10;
            view.setBackgroundResource(R.drawable.selector_banner_dot);
            view.setLayoutParams(params);
            view.setSelected(false);
            llDots.addView(view);
        }

    }


    private void resetIndiactor(int position){
        for(int i = 0;i< llDots.getChildCount();i++){
            llDots.getChildAt(i).setSelected(false);
        }
        llDots.getChildAt(position%dataList.size()).setSelected(true);

    }

    private ImageView createImageView(String imgUrl){
        ImageView imageView = new ImageView(getContext());
//            imageView.setLayoutParams(new MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Glide.with(getContext())
                .load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher)
                .centerCrop()
                .dontAnimate()
                .into(imageView);
        return imageView;
    }


    private Runnable taskRunnable = new Runnable() {
        @Override
        public void run() {
//            currentPositon = bannerPager.getCurrentItem();
            if(!isStop)
            handler.sendEmptyMessage(0);
        }
    };

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            handler.removeCallbacksAndMessages(null);
            if(!isStop) {
                currentPositon = bannerPager.getCurrentItem();
                bannerPager.setCurrentItem(currentPositon += 1);
                resetIndiactor(currentPositon);
            }
            handler.sendEmptyMessageDelayed(0,3500);
        }
    };

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPositon = bannerPager.getCurrentItem();
        resetIndiactor(position%dataList.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state){
            case ViewPager.SCROLL_STATE_IDLE:
                isStop = false;
//                handler.sendEmptyMessageDelayed(0,3500);
                break;
            case ViewPager.SCROLL_STATE_DRAGGING:
                isStop = true;
//                handler.removeCallbacksAndMessages(null);
                break;
        }
    }
}
