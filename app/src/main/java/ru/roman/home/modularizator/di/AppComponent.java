package ru.roman.home.modularizator.di;

import dagger.Component;
import ru.roman.home.core.di.AppScope;
import ru.roman.home.core.di.FeatureComponent;
import ru.roman.home.modularizator.App;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent extends FeatureComponent<App> {

	SessionComponent.Builder sessionComponent();

	@Override
	void inject(App app);
}
