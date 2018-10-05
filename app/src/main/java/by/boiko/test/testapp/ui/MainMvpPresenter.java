package by.boiko.test.testapp.ui;

import by.boiko.test.testapp.ui.base.MvpPresenter;

public interface MainMvpPresenter <V extends MainMvpView> extends MvpPresenter<V> {

    void getInfo();
}
