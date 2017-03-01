package modules.video;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import bilibili.demoforbilibili.R;
import butterknife.BindView;
import network.entity.VideoDetailEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import utils.GlideUtils;
import utils.IntentHelper;

/**
 * Created by ly on 2017/2/24.
 */

public class VideoDetailActivity extends BaseActivity {

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

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoDetailActivity.this,VideoPlayActivity.class);
                startActivity(intent);
            }
        });



        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                Log.i("123","veOffset-->>"+verticalOffset + "       total"+appBarLayout.getTotalScrollRange());
                if(Math.abs(verticalOffset)  < appBarLayout.getTotalScrollRange()*3/4){
                    avText.setVisibility(View.VISIBLE);
                    icon.setVisibility(View.INVISIBLE);
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
}
