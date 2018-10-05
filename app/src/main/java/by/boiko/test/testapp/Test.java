package by.boiko.test.testapp;

import android.app.Application;

import by.boiko.test.testapp.di.component.ApplicationComponent;
import by.boiko.test.testapp.di.component.DaggerApplicationComponent;
import by.boiko.test.testapp.di.module.ApplicationModule;

public class Test extends Application {


    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
