/*
 * Copyright (C) 2015 Zhang Rui <bbcallen@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package widget.media;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;

import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.DurationUtils;
import widget.callback.VideoControllCallBack;

public class TVMediaController extends FrameLayout implements IMediaController, SeekBar.OnSeekBarChangeListener, VideoControllCallBack {

    @BindView(R.id.iv_play_video_control)
    ImageView playBtn;
    @BindView(R.id.seekbar_play_vicdeo_control)
    SeekBar seekBar;
    @BindView(R.id.tv_total_video_control)
    TextView tvTotal;
    @BindView(R.id.tv_curpos_video_control)
    TextView tvCurP;
    @BindView(R.id.video_touch_view)
    VideoTouchView videoTouchView;
    @BindView(R.id.ll)
    LinearLayout ll;



    private MediaController.MediaPlayerControl mediaControl;
    private float currentProgress;
    private int curPosition;
    private int totalDuration;

    public TVMediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }


    public TVMediaController(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_tv_media_control,this,true);
        ButterKnife.bind(this);
        seekBar.setOnSeekBarChangeListener(this);
        playBtn.setSelected(true);
        videoTouchView.setVideoControllCallBack(this);
    }

    @OnClick(R.id.iv_play_video_control)
    void playVideo(){
        if(mediaControl.isPlaying()){
            handler.removeCallbacksAndMessages(null);
            playBtn.setSelected(false);
            mediaControl.pause();
        }else {
            if(curPosition == totalDuration && totalDuration >0){
                curPosition = 0;
                mediaControl.seekTo(0);
            }else {
                mediaControl.start();
            }
            playBtn.setSelected(true);

            handler.sendEmptyMessageDelayed(0,1000);
        }
    }


    @Override
    public void setMediaPlayer(MediaController.MediaPlayerControl player) {
        if(player !=null) this.mediaControl = player;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(b){
            seekBar.setProgress(i);
            currentProgress = (float)i/1000;
            videoTouchView.setProgressText((int) (currentProgress*totalDuration/1000));
        }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        totalDuration = mediaControl.getDuration();
        mediaControl.seekTo((int) (totalDuration*currentProgress));
        curPosition = (int) (totalDuration*currentProgress);
        tvCurP.setText(DurationUtils.calculateTime(curPosition/1000));
        if(currentProgress == 1000){
            completePlay();
        }
        videoTouchView.completeSeek();
    }

    @Override
    public void hide() {

    }

    @Override
    public boolean isShowing() {
        return false;
    }

    @Override
    public void setAnchorView(View view) {
        ((ViewGroup)view).addView(this);
    }


    @Override
    public void show(int timeout) {

    }

    @Override
    public void show() {

    }


    /**
     * 初始化 播放信息设置
     * @param total
     */
    public void setDuraitonInfo(int total){
        totalDuration = total;
        handler.removeCallbacksAndMessages(null);
        tvTotal.setText(DurationUtils.calculateTime(totalDuration/1000));
        handler.sendEmptyMessage(0);
    }

    /**
     *  seek完成之后的回调操作
     * @param currentDuratin
     */
    public void completeSeek(int currentDuratin){
        handler.removeCallbacksAndMessages(null);
        totalDuration = mediaControl.getDuration();
        curPosition = currentDuratin;
        handler.sendEmptyMessage(0);
    }


    public void completePlay(){
        handler.removeCallbacksAndMessages(null);
        playBtn.setSelected(false);
//        curPosition = 0;
//        mediaControl.seekTo(0);
//        mediaControl.pause();
    }

    /**
     * 调整 seekbar 进度
     */
    private void justSeekBar(){
        if(curPosition >= totalDuration){
            tvCurP.setText(DurationUtils.calculateTime(totalDuration/1000));
            seekBar.setProgress(1000);
            return;
        }else {
            tvCurP.setText(DurationUtils.calculateTime(curPosition/1000));
            seekBar.setProgress(curPosition*1000/totalDuration );
        }

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

//            if(totalDuration > 0 ){
//                tvTotal.setText(DurationUtils.calculateTime(totalDuration/1000));
//            }

            switch (msg.what) {
                case 0:

                   justSeekBar();
                    handler.sendEmptyMessageDelayed(0,1000);

                    curPosition +=1000;

                    break;
                case 1:
                    ll.setVisibility(View.GONE);
                    break;
            }



        }
    };


    @Override
    public void seekTo(int duration) {

        tvCurP.setText(DurationUtils.calculateTime(duration/1000));
        handler.removeCallbacksAndMessages(null);
        curPosition = duration;
        justSeekBar();

        mediaControl.seekTo(duration);
//        tvCurP.setText(DurationUtils.calculateTime(duration/1000));

    }



    @Override
    public int getCurDuration() {
        if(mediaControl!=null) return  mediaControl.getCurrentPosition();
        return 0;
    }

    @Override
    public int getTotalDuration() {
        if(mediaControl!=null) return  mediaControl.getDuration();
        return 0;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                handler.removeCallbacksAndMessages(null);
                ll.setVisibility(View.VISIBLE);
//                Log.i("TMController","ACTION_DOWN ");
                break;
            case MotionEvent.ACTION_UP:
                handler.sendEmptyMessageDelayed(1,3000);
//                Log.i("TMController","ACTION_UP ");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    //    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
////            super.handleMessage(msg);
//            ll.setVisibility(View.GONE);
//        }
//    };
}
