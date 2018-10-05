package by.boiko.test.testapp.di.module;

import android.content.Context;

import javax.inject.Singleton;

import by.boiko.test.testapp.Test;
import by.boiko.test.testapp.data.RepositoryManager;
import by.boiko.test.testapp.data.RepositoryManagerImpl;
import by.boiko.test.testapp.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Test application;

    public ApplicationModule(Test application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Test provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    RepositoryManager provideRepositoryManager(RepositoryManagerImpl repositoryManager) {
        return repositoryManager;
    }
}

