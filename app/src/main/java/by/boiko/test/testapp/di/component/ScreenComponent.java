package by.boiko.test.testapp.di.component;

import by.boiko.test.testapp.di.PerScreen;
import by.boiko.test.testapp.di.module.ScreenModule;
import by.boiko.test.testapp.ui.MainActivity;
import dagger.Component;

@PerScreen
@Component(modules = ScreenModule.class, dependencies = ApplicationComponent.class)
public interface ScreenComponent {

    void inject(MainActivity activity);

}
