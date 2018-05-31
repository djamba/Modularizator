package ru.roman.home.modularizator.di;

import dagger.Component;
import ru.roman.home.core.di.AppScope;
import ru.roman.home.modularizator.App;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {

	SessionComponent plus(SessionModule module);

	void injectApp(App app);
}
