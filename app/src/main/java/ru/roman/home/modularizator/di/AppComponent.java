package ru.roman.home.modularizator.di;

import dagger.Component;
import ru.roman.home.core.di.AppScope;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {

	void injectComponentsHolder(ComponentsHolderImpl componentsHolder);
}
