package modules.video;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.OnClick;
import network.entity.VideoDetailEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import utils.ApiGengder;
import utils.ConsValues;
import utils.DensityUtils;
import utils.GlideUtils;
import utils.IntentHelper;
import widget.callback.VideoStatusCallBack;
import widget.media.IjkVideoView;
import widget.media.TVMediaController;

/**
 * Created by ly on 2017/2/24.
 */

public class VideoDetailActivity extends BaseActivity implements VideoStatusCallBack {

    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.tb_video)
    Toolbar toolbar;
    @BindView(R.id.tabs_video)
    TabLayout tabLayout;
    @BindView(R.id.iv_video_bg)
    ImageView cover;
    @BindView(R.id.vp_video)
    ViewPager viewPager;
    @BindView(R.id.fbtn_video)
    FloatingActionButton fbtn;
    @BindView(R.id.tv_video_av)
    TextView avText;
    @BindView(R.id.tv_video_icon_toobar_mid)
    TextView icon;
    @BindView(R.id.collsp_video)
    CollapsingToolbarLayout collapsing;


    private PagerAdapter adapter;
    private String avNum;
    private List<Fragment> fralist = new ArrayList<>();
    private String titles[] = new String[]{"简介","评论"};

    @Override
    protected void initView() {
        avText.setText("av"+avNum);

        fralist.add(AbstractFragment.newInstance());
        fralist.add(ComentFragment.newInstance(avNum));

        tabLayout.addTab(tabLayout.newTab().setText(titles[0]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[1]));

        adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

//        fbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(VideoDetailActivity.this,VideoPlayActivity.class);
//                startActivity(intent);
//            }
//        });



        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(isPlayerMode) return;

//                Log.i("123","veOffset-->>"+verticalOffset + "       total"+appBarLayout.getTotalScrollRange());
                if(Math.abs(verticalOffset)  < appBarLayout.getTotalScrollRange()*3/4){
                    avText.setVisibility(View.VISIBLE);
                    icon.setVisibility(View.GONE);
//                    fbtn.setVisibility(View.VISIBLE);
                    showFbtn(true);
                }else {
                    avText.setVisibility(View.INVISIBLE);
                    icon.setVisibility(View.VISIBLE);
//                    fbtn.setVisibility(View.GONE);
                    showFbtn(false);
                }
            }
        });

        initVideo();

    }


    @Override
    protected void loadData() {
        ApiGengder.getVideoDetailService().getVideoDetails(avNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<VideoDetailEntity>() {
                    @Override
                    public void call(VideoDetailEntity videoDetailEntity) {
                        GlideUtils.loadImg(VideoDetailActivity.this, videoDetailEntity.getData().getPic(), cover);
                        ((AbstractFragment)fralist.get(0)).setData(videoDetailEntity);
//                        ((ComentFragment)fralist.get(1)).setData(videoDetailEntity.getData().getAid()+"");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });



    }




    @Override
    protected void getIntentData() {
        avNum = getIntent().getStringExtra(IntentHelper.AV);
    }

    @Override
    protected void initToolBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_video_detail;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.video,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showFbtn(boolean value){
        if(value){
            fbtn.animate().scaleX(1f).scaleY(1f)
                    .setInterpolator(new OvershootInterpolator()).start();
        }else {
            fbtn.animate().scaleX(0f).scaleY(0f)
                    .setInterpolator(new AccelerateInterpolator()).start();
        }
    }




    class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fralist.get(position);
        }

        @Override
        public int getCount() {
            return fralist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }




    /**
     * ************************************************************************************************
     *  这下面是新添加的配置
     */

    @BindView(R.id.videoview)
    IjkVideoView videoView;
    TVMediaController mediaController;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.rl)
    RelativeLayout rl;

    private int initHeigtht;
    private boolean isPlayerMode;
    private CollapsingToolbarLayout.LayoutParams params;

    private void initVideo(){

        initHeigtht = getResources().getDimensionPixelSize(R.dimen.video_height);
        mediaController = new TVMediaController(this);
        mediaController.setVideoStatusCallBack(this);
        videoView.setMediaController(mediaController);
        videoView.setOnSeekCompleteListener(onSeekCompleteListener);
        videoView.setOnInfoListener(onInfoListener);
        videoView.setOnCompletionListener(onCompletionListener);

    }

    private void loadVideo(){
        videoView.setVideoPath(ConsValues.PATH);
        videoView.start();
    }


    /**
     *  横竖屏 切换策略是更改 videoview所在布局的高度 去除或显示toobar 然后禁用滑动策略
     *   因为video在布局中位于最上面  显示高度时实际是最先显示（此时appbarlayout是展开的--> 播放强制展开）
     *   其实下面的内容都是仍然存在的  但是不可见 这样返回竖屏时 当前页面的状态也能得到保留
     * @param newConfig
     */
     @Override
     public void onConfigurationChanged(Configuration newConfig) {
      resetVideoLaytouParams(true);
     super.onConfigurationChanged(newConfig);
         params = (CollapsingToolbarLayout.LayoutParams) rl.getLayoutParams();


         switch (newConfig.orientation){
             case Configuration.ORIENTATION_LANDSCAPE:


                 viewPager.setVisibility(View.GONE);
                 tabLayout.setVisibility(View.GONE);

                 params.height =Math.min( DensityUtils.getWindowWidth(this),DensityUtils.getWindowHieght(this));
                 getSupportActionBar().hide();
//
                 rl.setLayoutParams(params);

                 //延迟设置
                 handler.sendEmptyMessageDelayed(0,500);
                 break;
             case Configuration.ORIENTATION_PORTRAIT:


                 viewPager.setVisibility(View.VISIBLE);
                 tabLayout.setVisibility(View.VISIBLE);

                 params.height = initHeigtht;

                 getSupportActionBar().show();
                 rl.setLayoutParams(params);
//
                 //延迟设置
//                 handler.sendEmptyMessageDelayed(0,500);
                 if(mediaController.isplaying()){
                     handler.sendEmptyMessageDelayed(0,500);
                 }
                 break;
         }
//         handler.sendEmptyMessageDelayed(0,500);

//         resetVideoLaytouParams(false);


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

//    private boolean zoom_out = false;

    @OnClick(R.id.fbtn_video)
    void playVideo(){

        isPlayerMode = true;

        cover.setVisibility(View.GONE);

        loadVideo();

        fbtn.setVisibility(View.GONE);

        appBarLayout.setExpanded(true);

        resetVideoLaytouParams(false);

//        avText.setVisibility(View.VISIBLE);
//        icon.setVisibility(View.INVISIBLE);


    }

    /**
     * 用scrollflag = 0 默认 不滑动，固定，但横竖屏切换会特别卡
     * 用 SCROLL_FLAG_SCROLL|SCROLL_FLAG_EXIT_UNTIL_COLLAPSED 切换时并不会有这种现象
     * 奇怪
     * 我这里横竖屏切换都先设置成第二种模式 然后切换完成在设置成不可滑动状态
     * 做了延迟处理 ，不然还是会很卡 搞不懂
     *
     */


    private void resetVideoLaytouParams(boolean scroll){
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) collapsing.getLayoutParams();
        if(!scroll){
            params.setScrollFlags(0);
        }else {
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL| AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        }

        collapsing.setLayoutParams(params);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (event.getKeyCode()){
            case KeyEvent.KEYCODE_BACK:
                if(mediaController.isZoomOut()){
                    mediaController.zoom();
                    return true;

                }

                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            resetVideoLaytouParams(false);
        }
    };

    @Override
    public void pause() {
        isPlayerMode = false;
        checkPauseStatus(true);
    }

    @Override
    public void start() {
        isPlayerMode = true;
        appBarLayout.setExpanded(true);
        checkPauseStatus(false);
    }

    /**
     *  这个主要设置暂停状态 可以滚动 ——>>>竖屏
     *
     */
    private void checkPauseStatus(boolean scrollable){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            resetVideoLaytouParams(scrollable);
        }
    }

//    @OnClick(R.id.tv_video_icon_toobar_mid)
//    void onTopIconClick(){
//        avText.setVisibility(View.VISIBLE);
//        icon.setVisibility(View.GONE);
//        appBarLayout.setExpanded(true);
//        resetVideoLaytouParams(false);
//        mediaController.pla
//    }

}
