package by.boiko.test.testapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import by.boiko.test.testapp.di.ActivityContext;
import by.boiko.test.testapp.di.PerScreen;
import by.boiko.test.testapp.ui.MainMvpPresenter;
import by.boiko.test.testapp.ui.MainMvpPresenterImpl;
import by.boiko.test.testapp.ui.MainMvpView;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ScreenModule {

    private final AppCompatActivity activity;

    public ScreenModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerScreen
    MainMvpPresenter<MainMvpView> provideEquipmentDeliveryCertificateMvpPresenter(MainMvpPresenterImpl<MainMvpView> presenter) {
        return presenter;
    }
}
