package modules.video;

import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import base.BaseActivity;
import bilibili.demoforbilibili.R;
import butterknife.BindView;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import widget.media.IjkVideoView;
import widget.media.TVMediaController;

/**
 * Created by ly on 2017/2/26.
 */

public class VideoPlayActivity extends BaseActivity   {

    @BindView(R.id.videoview)
    IjkVideoView videoView;
    @BindView(R.id.mediacontroller)
    TVMediaController mediaController;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    private String path = "/storage/extSdCard/Videos/Others/灵梦和幽幽子的弹幕.mp4";
    @Override
    protected void initView() {
        videoView.setMediaController(mediaController);
        videoView.setOnSeekCompleteListener(onSeekCompleteListener);
        videoView.setOnInfoListener(onInfoListener);
        videoView.setOnCompletionListener(onCompletionListener);

    }

    @Override
    protected void loadData() {
        super.loadData();
        videoView.setVideoPath(path);
        videoView.start();
    }

    @Override
    protected void initToolBar() {
        super.initToolBar();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setBackgroundDrawable(null);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_play_video;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (videoView != null) {
            videoView.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null && videoView.isDrawingCacheEnabled()) {
            videoView.destroyDrawingCache();
        }
    }






    IMediaPlayer.OnCompletionListener onCompletionListener = new IMediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            videoView.pause();
            mediaController.completePlay();
        }
    };

    IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() {
        @Override
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            mediaController.completeSeek((int) iMediaPlayer.getCurrentPosition());
        }
    };

    IMediaPlayer.OnInfoListener onInfoListener = new IMediaPlayer.OnInfoListener() {
        @Override
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
            if (i == IMediaPlayer.MEDIA_INFO_BUFFERING_START) {
                progressBar.setVisibility(View.VISIBLE);

            } else if (i == IMediaPlayer.MEDIA_INFO_BUFFERING_END) {
                progressBar.setVisibility(View.GONE);
            }else if(i == IMediaPlayer.MEDIA_INFO_AUDIO_RENDERING_START){
                mediaController.setDuraitonInfo((int) iMediaPlayer.getDuration());
            }
            return true;
        }
    };
}


