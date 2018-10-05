package by.boiko.test.testapp.di.component;

import android.content.Context;

import javax.inject.Singleton;

import by.boiko.test.testapp.Test;
import by.boiko.test.testapp.data.RepositoryManager;
import by.boiko.test.testapp.di.ApplicationContext;
import by.boiko.test.testapp.di.module.ApiModule;
import by.boiko.test.testapp.di.module.ApplicationModule;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(Test application);

    @ApplicationContext
    Context context();

    RepositoryManager getRepositoryManager();

}

