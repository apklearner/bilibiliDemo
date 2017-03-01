package widget.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bilibili.demoforbilibili.R;
import utils.DurationUtils;
import widget.callback.VideoControllCallBack;

/**
 * Created by ly on 2017/3/1.
 */

public class VideoTouchView extends RelativeLayout {

//    private GestureDetector gestureDetector;
    private TextView progressText;
    private int width;
    private int height;

    private AudioManager audioManager;
    private int mMaxVloume;
    private float mbrightness;
    private int mVolume;

    private float mOldX;
    private float mOldY;

    private long curDuration;
    private long totalDuration;

    private boolean isBrightness;
    private boolean isProgressSlide;

    private final int MESSAGE_BRIGHTNESS = 0;

    private VideoControllCallBack callBack;


    public VideoTouchView(Context context) {
        this(context,null);
    }

    public VideoTouchView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public VideoTouchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        initData();
    }

    public void setVideoControllCallBack(VideoControllCallBack callBack){
        this.callBack = callBack;
    }


    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.layout_video_touch__view,this,true);
        progressText = (TextView) findViewById(R.id.tv_progress);
//        gestureDetector = new GestureDetector(getContext(),new MyGestureListener());

        audioManager  = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

    }

    private void initData(){
        mVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mMaxVloume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        mbrightness = ((Activity)getContext()).getWindow().getAttributes().screenBrightness;
        if(mbrightness <0) mbrightness = 0f;
    }


//
//    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
//
//        private boolean isBrightness; //左边的
//
//
//        @Override
//        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            mOldX =  e1.getX();  mOldY = e1.getY();
//            float mNewX =  e2.getX(); float mNewY = e2.getY();
//            float deltaX = mNewX - mOldX;
//            float deltaY = mNewY - mOldY;
//
//            mOldX = mNewX;
//            mOldY = mNewY;
//
//            isBrightness = mOldX <  width * 0.5f;
//
//            if(Math.abs(distanceY) > Math.abs(distanceX)){
//
//                if(isBrightness){
//                    onSlideBrightness((float) ((-deltaY+0.5f)*0.5/height));
//                    Log.i("VideoTouchView",deltaY +"     "+height +"     "+(deltaY+0.5f)*0.5/height);
//                }
//            }
//
//            return super.onScroll(e1, e2, distanceX, distanceY);
//        }
//
//        @Override
//        public boolean onSingleTapUp(MotionEvent e) {
//            handler.sendEmptyMessageDelayed(MESSAGE_BRIGHTNESS,2000);
//            return super.onSingleTapUp(e);
//        }
//
//    }


    private void onSlideBrightness(float percent){
        mbrightness += percent;
        if(mbrightness < 0f){
            mbrightness = 0f;
        }else  if(mbrightness >1f){
            mbrightness = 1f;
        }


        WindowManager.LayoutParams lp = ((Activity)getContext()).getWindow().getAttributes();
        lp.screenBrightness = mbrightness;
        ((Activity)getContext()).getWindow().setAttributes(lp);

        progressText.setText("亮度 "+(int)(mbrightness*100) + "%");
        progressText.setVisibility(View.VISIBLE);


    }


    private void onSlideVolume(float percent){

//        Log.i("VideoTouchView",mVolume +"    "+ mMaxVloume);
        if(Math.abs(percent) < 10) return;

        if(percent >0){
            mVolume  += 1;
        }else {
            mVolume  -= 1;
        }



        if(mVolume <0){
            mVolume = 0;
        }else if(mVolume > mMaxVloume){
            mVolume = mMaxVloume;
        }

        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,mVolume,0);
        progressText.setText("声音 "+(mVolume*100)/mMaxVloume + "%");
        progressText.setVisibility(View.VISIBLE);


    }


    /**
     * progress 按秒进行
     *
     */
    private void onSlideProgress(int seconds){
        if(callBack != null){
            curDuration += seconds*1000;
            if(curDuration > totalDuration){
                curDuration = totalDuration;
            }else if(curDuration <0){
                curDuration = 0;
            }
//            Log.i("VideoTouchView",curDuration + "   "+totalDuration);

            progressText.setVisibility(View.VISIBLE);
            progressText.setText(DurationUtils.calculateTime((int) curDuration/1000));
//            Log.i("VideoTouchView",curDuration + "    "+  seconds + "     "+DurationUtils.calculateTime((int) curDuration/1000) );
        }
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
//        gestureDetector.onTouchEvent(event);
//        return  true;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                handler.removeCallbacksAndMessages(null);
                progressText.setVisibility(View.GONE);

                mOldX = event.getX();
                mOldY = event.getY();
                if(mOldX > width*0.5){
                    isBrightness = false;
                }else {
                    isBrightness = true;
                }

                if(callBack!=null){
                    curDuration = callBack.getCurDuration();
                    totalDuration = callBack.getTotalDuration();
                }

                break;
            case MotionEvent.ACTION_MOVE:
                float newY = event.getY();
                float newX = event.getX();
                int deltaY = (int) (newY - mOldY);
                if(Math.abs(newY - mOldY) > Math.abs(newX - mOldX)){
                    if(!isProgressSlide) {
                        if (isBrightness) {
                            onSlideBrightness((-deltaY + 0.5f) * 0.5f / height);

                        } else {
//                            onSlideVolume((-deltaY + 0.5f)/ height);
                            onSlideVolume(-deltaY);
                        }
                    }
                }else {
                    int deltaX = (int) (newX - mOldX);
//                    Log.i("VideoTouchView","deltaX         "+deltaX );
                    if(Math.abs(deltaX) >5){
                        isProgressSlide = true;
                        onSlideProgress(deltaX/5);
                    }

                }

                mOldX = newX;
                mOldY = newY;

                    break;
            case MotionEvent.ACTION_UP:
                if(isProgressSlide&&callBack!=null){
                    callBack.seekTo((int) curDuration);
                    progressText.setVisibility(View.GONE);
                }

                isProgressSlide = false;
                handler.sendEmptyMessageDelayed(MESSAGE_BRIGHTNESS,2000);
                break;
        }

        return true;
//       return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MESSAGE_BRIGHTNESS:
                    progressText.setVisibility(View.GONE);
                    break;
            }
        }
    };
}
