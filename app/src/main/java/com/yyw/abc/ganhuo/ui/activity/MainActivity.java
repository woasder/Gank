package com.yyw.abc.ganhuo.ui.activity;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.yyw.abc.ganhuo.R;
import com.yyw.abc.ganhuo.RxBus.RxBus;
import com.yyw.abc.ganhuo.RxBus.UserEvent;
import com.yyw.abc.ganhuo.Type;
import com.yyw.abc.ganhuo.presenter.domain.DomianPresenter;
import com.yyw.abc.ganhuo.presenter.domain.DomianPresenterImpl;
import com.yyw.abc.ganhuo.ui.common.BaseDrawActivity;
import com.yyw.abc.ganhuo.ui.fragment.BaseFragment;
import com.yyw.abc.ganhuo.ui.common.BaseActivity;
import com.yyw.abc.ganhuo.ui.fragment.ListAdapter;
import com.yyw.abc.ganhuo.ui.fragment.ViewAdapter;
import com.yyw.abc.ganhuo.ui.view.IShowMain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends BaseDrawActivity implements IShowMain{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] types= {"福利","Android","iOS","休息视频","拓展资源","前端","all"};
    private Subscription subscription;
    private List<String> titleList;
    private List<FragmentEntity> fragmentList;
    private List<FragmentEntity> copyFragmentList;
    private ListAdapter listAdapter;
    private ViewAdapter viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initView() {
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
       // List<String> titleList = Arrays.asList(types);
        titleList = new ArrayList<>();
         fragmentList = new ArrayList<>();
       /* for (int i = 0;i<titleList.size();i++){
            Log.d("BM",titleList.get(i));
            BaseFragment baseFragment = BaseFragment.getInstance(titleList.get(i));
            fragmentList.add(baseFragment);
        }*/
         listAdapter = new ListAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewAdapter = new ViewAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(listAdapter);
      //  viewPager.setOffscreenPageLimit(7);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
        final DomianPresenter domianPresenter = new DomianPresenterImpl(this);
        domianPresenter.loadType();

        subscription = RxBus.getDefaultInstance().toObservable(UserEvent.class).subscribe(new Action1<UserEvent>() {
            @Override
            public void call(UserEvent userEvent) {
                long sid = userEvent.getId();
                if (sid == 102){
                   // domianPresenter.loadType();

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    @Override
    public void setType( List<Type> list) {
        if (list.isEmpty()){
            titleList = Arrays.asList(types);
            for (int i = 0;i<titleList.size();i++){
                Log.d("BM",titleList.get(i));
                BaseFragment baseFragment = BaseFragment.getInstance(titleList.get(i));
                fragmentList.add(new FragmentEntity(baseFragment,titleList.get(i)));
            }
        }else {

           /* List<String> typeList = new ArrayList<>();
            for (int i=0;i<fragmentList.size();i++){
                typeList.add(fragmentList.get(i).getType());
            }
            List<FragmentEntity> entityList = new ArrayList<FragmentEntity>();

            for (int i = 0;i<list.size();i++){
                if (list.get(i).getIsChecked()){
                    if (typeList.contains(list.get(i).getType())){
                        entityList.add(fragmentList.get(typeList.indexOf(list.get(i).getType())));
                    }else {
                        BaseFragment baseFragment = BaseFragment.getInstance(list.get(i).getType());
                        entityList.add(new FragmentEntity(baseFragment,list.get(i).getType()));
                    }
                }
            }
            fragmentList.clear();
            for (int i =0;i<entityList.size();i++){
                fragmentList.add(entityList.get(i));
            }*/
            fragmentList.clear();
            for (int i=0;i<list.size();i++){
                if (list.get(i).getIsChecked()){
                    BaseFragment baseFragment = BaseFragment.getInstance(list.get(i).getType());
                    fragmentList.add(new FragmentEntity(baseFragment,list.get(i).getType()));
                }
            }
        }
       // viewPager.setOffscreenPageLimit(fragmentList.size());
        listAdapter.notifyDataSetChanged();

        viewPager.setOffscreenPageLimit(fragmentList.size());
       // viewPager.setCurrentItem(0);

    }

    public Observable<List<FragmentEntity>> getFragmentEntity(final List<Type> list){
        return Observable.create(new Observable.OnSubscribe<List<FragmentEntity>>(){
            @Override
            public void call(Subscriber<? super List<FragmentEntity>> subscriber) {
                List<String> typeList = new ArrayList<String>();
                for (int i=0;i<fragmentList.size();i++){
                    typeList.add(fragmentList.get(i).getType());
                }
                List<FragmentEntity> entityList = new ArrayList<FragmentEntity>();
                for (int i = 0;i<list.size();i++){
                    if (typeList.contains(list.get(i).getType())){
                        entityList.add(fragmentList.get(typeList.indexOf(list.get(i).getType())));
                      //  subscriber.onNext(fragmentList.get(typeList.indexOf(list.get(i).getType())));
                    }else {
                        BaseFragment baseFragment = BaseFragment.getInstance(list.get(i).getType());
                        entityList.add(new FragmentEntity(baseFragment,list.get(i).getType()));
                       // subscriber.onNext(new FragmentEntity(baseFragment,list.get(i).getType()));
                    }
                }
                subscriber.onNext(entityList);
                subscriber.onCompleted();
            }
        });
    }

}
