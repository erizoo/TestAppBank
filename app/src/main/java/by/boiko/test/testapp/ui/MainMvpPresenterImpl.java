package by.boiko.test.testapp.ui;

import javax.inject.Inject;

import by.boiko.test.testapp.data.RepositoryManager;
import by.boiko.test.testapp.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainMvpPresenterImpl <V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V>{

    @Inject
    public MainMvpPresenterImpl(RepositoryManager repositoryManager, CompositeDisposable compositeDisposable) {
        super(repositoryManager, compositeDisposable);
    }

    @Override
    public void getInfo() {
        getCompositeDisposable().add(
                getRepositoryManager().getServiceNetwork().getInfo()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::onInfoGeted,
                                Throwable::printStackTrace
                        )
        );
    }
}
