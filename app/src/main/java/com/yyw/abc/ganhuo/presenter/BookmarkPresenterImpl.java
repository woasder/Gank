package com.yyw.abc.ganhuo.presenter;

import com.yyw.abc.ganhuo.Gank;
import com.yyw.abc.ganhuo.model.BookmarkModel;
import com.yyw.abc.ganhuo.model.BookmarkModelImpl;
import com.yyw.abc.ganhuo.ui.view.IShowBookmark;

import java.util.List;

/**
 *
 * Created by abc on 2016/6/7.
 */
public class BookmarkPresenterImpl implements BookmarkPresenter ,OnQueryListener,OnDeleteListener{
    private IShowBookmark iShowBookmark;
    private BookmarkModel bookmarkModel;
    public BookmarkPresenterImpl(IShowBookmark iShowBookmark){
        this.iShowBookmark = iShowBookmark;
        bookmarkModel = new BookmarkModelImpl();
    }


    @Override
    public void queryGank(int count, int page) {
        iShowBookmark.showLoading();
        bookmarkModel.quere(count,page,this);
    }

    @Override
    public void deleteGank(Gank gank) {
        iShowBookmark.showLoading();
        bookmarkModel.delete(gank,this);
    }

    @Override
    public void onDeleteSuccess(List<Gank> list) {
        iShowBookmark.hideLoading();
      //  iShowBookmark.setMatkGank(list);
    }

    @Override
    public void onDeleteError() {
        iShowBookmark.hideLoading();
    }



    @Override
    public void onQuerySuccess(List<Gank> list) {
        iShowBookmark.hideLoading();
        iShowBookmark.setMatkGank(list);
    }

    @Override
    public void onQueryError() {
        iShowBookmark.hideLoading();
    }
}
