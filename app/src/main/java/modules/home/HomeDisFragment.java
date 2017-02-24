package modules.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import base.BaseFramgment;
import bilibili.demoforbilibili.R;
import butterknife.BindView;
import butterknife.OnClick;
import network.entity.HotTagEntity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.ApiGengder;
import utils.DensityUtils;

/**
 * Created by ly on 2017/2/23.
 */

public class HomeDisFragment extends BaseFramgment {

    @BindView(R.id.tv_fra_dis_search)
    TextView tv_search;
    @BindView(R.id.scroill_fra_dis)
    NestedScrollView scrollView;
    @BindView(R.id.tag_layou_fra_dis)
    TagFlowLayout tagFlowLayout;
    @BindView(R.id.tv_fra_dis_hobby)
    TextView tv_hobby;
    @BindView(R.id.tv_fra_dis_or_order)
    TextView tv_or_rank;
    @BindView(R.id.tv_fra_dis_gl_order)
    TextView tv_gl_rank;
    @BindView(R.id.tv_fra_dis_game)
    TextView tv_game;
    @BindView(R.id.tv_more)
    TextView tv_more;

    private List<HotTagEntity.ListBean> datalist = new ArrayList<>();
    private HotTagEntity hotTags;
    private MTagAdapter adapter;
    private boolean isUnFold = false;

    public static HomeDisFragment newInstance(){
        HomeDisFragment instance = new HomeDisFragment();
        return instance;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_home_discover,container,false);
        return view;
    }


    @Override
    protected void initView() {
        super.initView();
        adapter = new MTagAdapter(datalist);
        tagFlowLayout.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        super.loadData();
        ApiGengder.getHotTagService().getHotTags()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HotTagEntity>() {
                    @Override
                    public void call(HotTagEntity hotTagEntity) {
                        hotTags = hotTagEntity;
                        addTags(isUnFold);
                    }
                });
    }

    @OnClick(R.id.tv_more)
    void onMoreClick(){
        isUnFold = !isUnFold;
        tv_more.setText("查看更多");
        if(isUnFold) tv_more.setText("收起");
        tv_more.setSelected(isUnFold);
        addTags(isUnFold);


    }

    private void addTags(boolean isUnFold){
        if(hotTags !=null){
            datalist.clear();
            if(!isUnFold){
                datalist.addAll(hotTags.getList().subList(0,7));
            }else {
                datalist.addAll(hotTags.getList());
            }
            resetScrollLayout(isUnFold);

            adapter.notifyDataChanged();

        }


    }

    private void resetScrollLayout(boolean isUnFold){
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) scrollView.getLayoutParams();
        if(isUnFold){
            params.height = DensityUtils.Dp2px(getContext(),200);
        }else {
            params.height = ViewGroup.MarginLayoutParams.WRAP_CONTENT;
        }
        scrollView.setLayoutParams(params);
    }


    class MTagAdapter extends TagAdapter<HotTagEntity.ListBean> {

        public MTagAdapter(List<HotTagEntity.ListBean> datalist){
            super(datalist);
        }


        @Override
        public View getView(FlowLayout parent, int position, HotTagEntity.ListBean listBean) {
          View view = LayoutInflater.from(getContext()).inflate(R.layout.item_tags,null);
          TextView title = (TextView) view.findViewById(R.id.tv_tags);
          title.setText(listBean.getKeyword());
          return view;
        }
    }


}
