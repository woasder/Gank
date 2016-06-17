package com.yyw.abc.ganhuo.presenter;

import android.util.Log;

import com.yyw.abc.ganhuo.model.Ganhuo;
import com.yyw.abc.ganhuo.model.GankModel;
import com.yyw.abc.ganhuo.model.GankModelImpl;
import com.yyw.abc.ganhuo.model.entity.Gank;
import com.yyw.abc.ganhuo.model.entity.GankInfo;
import com.yyw.abc.ganhuo.ui.view.IShowGankView;

import java.util.List;

/**
 *
 * Created by abc on 2016/5/27.
 */
public class GankPresenterImpl implements GankPresenter, OnGankListener,OnAddMarkListener{
    private IShowGankView iShowGankView;
    private GankModel gankModel;
    public GankPresenterImpl(IShowGankView iShowGankView){
        this.iShowGankView = iShowGankView;
        gankModel = new GankModelImpl();
    }

    @Override
    public void onSuccess(List<Ganhuo> list) {
        Log.d("TAG","P onSuccess");
        iShowGankView.hideLoading();
        iShowGankView.setGankInfo(list);
    }



    @Override
    public void onError() {
        iShowGankView.hideLoading();
        iShowGankView.showFailedError();
    }



    @Override
    public void getGank(String type, int count, int page) {
        iShowGankView.showLoading();
        gankModel.loadGank(type,count,page,this);
    }

    @Override
    public void refresh(String type, int count) {
        Log.d("TAG","P refresh");
        iShowGankView.showLoading();
        gankModel.loadGank(type,count,1,this);
    }

    @Override
    public void addToMark(com.yyw.abc.ganhuo.Gank gank) {
        iShowGankView.showMark();
        gankModel.addToMark(gank,this);
    }



    @Override
    public void onAddSuccess() {

    }

    @Override
    public void onAddError() {

    }

    @Override
    public void delFromMark(com.yyw.abc.ganhuo.Gank gank) {

        gankModel.delFromMark(gank);
    }
}
