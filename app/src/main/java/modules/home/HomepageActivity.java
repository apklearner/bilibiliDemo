package modules.home;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.OnClick;
import utils.StatusBarCompat;

/**
 * Created by ly on 2017/2/18.
 */

public class HomepageActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.naviview_home)
    NavigationView navigationView;
    @BindView(R.id.tb_home)
     Toolbar toolbar;
    @BindView(R.id.vp_home)
    ViewPager viewPager;
    @BindView(R.id.tabs_home)
    TabLayout tabLayout;
    @BindView(R.id.drawer_layout_home)
    DrawerLayout drawerLayout;
    @BindView(R.id.drawer_home)
    ImageView drawerIcon;

    private String[] titles;
    private List<Fragment> fralist = new ArrayList<>();


    @Override
    protected void initView() {
        titles = getResources().getStringArray(R.array.home_titles);
        initTabs();

        navigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
        navigationView.setNavigationItemSelectedListener(this);

        StatusBarCompat.compat(this,getResources().getColor(R.color.colorPrimary));

    }

    @Override
    protected void initToolBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

    private void initTabs(){
        for(int i =0;i<titles.length;i++){
            tabLayout.addTab(tabLayout.newTab().setText(titles[0]));
//            if(i == 2){
//                fralist.add(HomeBangumiFragment.newInstance());
//            }else {
//                fralist.add(HomeLiveFragment.newInstance());
//
//            }
            switch (i){
                case 0:
//                    fralist.add(HomeLiveFragment.newInstance());
                    fralist.add(HomeLiveFragment.newInstance());
                    break;
                case 1:
                    fralist.add(HomeRecommandFragment.newInstance());
                    break;
                case 2:
                    fralist.add(HomeBangumiFragment.newInstance());
                    break;
                case 3:
                    fralist.add(HomeRegionFragment.newInstance() );
                    break;
                case 4:
                    fralist.add(HomeBangumiFragment.newInstance());
                    break;
                case 5:
                    fralist.add(HomeDisFragment.newInstance());
                    break;
            }

        }
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(new HomePageAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home_section,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_game:
                break;
            case R.id.menu_down:
                break;
            case R.id.menu_search:
                break;
        }

        Toast.makeText(this,"1234",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(Gravity.LEFT);

        switch (item.getItemId()){
            case R.id.menu_cache:
                Toast.makeText(this,"cache",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.menu_collcet:
                Toast.makeText(this,"collect",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.menu_history:
                return  true;
            case R.id.menu_focus:
                return  true;
            case R.id.menu_money:
                return  true;
            case R.id.menu_theme:
                return  true;
            case R.id.menu_app:
                return  true;
            case R.id.menu_set:
                return  true;
        }
        return false;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick(R.id.drawer_home)
     void toogleDrawer(){
        if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT);
        }else {
            drawerLayout.openDrawer(Gravity.LEFT);
        }

    }


    class HomePageAdapter extends FragmentPagerAdapter{

        public HomePageAdapter(FragmentManager fm) {
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
