package com.yyw.abc.ganhuo.presenter.select;

import com.yyw.abc.ganhuo.Type;
import com.yyw.abc.ganhuo.model.select.SelectModel;
import com.yyw.abc.ganhuo.model.select.SelectModelImpl;
import com.yyw.abc.ganhuo.ui.view.IShowSelect;

import java.util.List;

/**
 * Created by abc on 2016/6/19.
 */
public class SelectPresenterImpl implements SelectPresenter,LoadType,SaveTYpe.saveType {

    private SelectModel selectModel;
    private IShowSelect iShowSelect;

    public SelectPresenterImpl(IShowSelect iShowSelect) {
        this.iShowSelect = iShowSelect;
        selectModel = new SelectModelImpl();
    }

    @Override
    public void loadType() {
        iShowSelect.showLoad();
        selectModel.loadType(this);
    }

    @Override
    public void saveType(List<Type> list) {
        selectModel.saveType(list,this);
    }

    @Override
    public void loadSuccess(List<Type> list) {
        iShowSelect.hideLoad();
        iShowSelect.setType(list);
    }

    @Override
    public void loadError() {
        iShowSelect.hideLoad();
        iShowSelect.showError();
    }

    @Override
    public void saveSuccess(List<Type> list) {
        iShowSelect.showLoad();
    }

    @Override
    public void saveError() {
        iShowSelect.hideLoad();
        iShowSelect.showError();
    }
}
