package com.yyw.abc.ganhuo.presenter.domain;

import com.yyw.abc.ganhuo.Type;
import com.yyw.abc.ganhuo.model.domain.DomainModelImpl;
import com.yyw.abc.ganhuo.model.domain.DomianModel;
import com.yyw.abc.ganhuo.ui.view.IShowMain;

import java.util.List;

/**
 * Created by abc on 2016/6/21.
 */
public class DomianPresenterImpl implements DomianPresenter ,OnLoadTypeListener{

    private IShowMain iShowMain;
    private DomianModel domianModel;

    public DomianPresenterImpl(IShowMain iShowMain) {
        this.iShowMain = iShowMain;
        domianModel = new DomainModelImpl();
    }

    @Override
    public void loadType() {
        domianModel.loadType(this);
    }

    @Override
    public void onSuccess(List<Type> list) {
        iShowMain.setType(list);
    }

    @Override
    public void onError() {

    }
}
