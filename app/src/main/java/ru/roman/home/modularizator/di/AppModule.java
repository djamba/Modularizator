package ru.roman.home.modularizator.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import ru.roman.home.core.di.AppScope;
import ru.roman.home.core.di.ComponentsHolder;

@Module
public class AppModule {

	private final Context context;
	private final ComponentsHolder componentsHolder;

	public AppModule(Context context, ComponentsHolder componentsHolder) {
		this.context = context;
		this.componentsHolder = componentsHolder;
	}

	@AppScope
	@Provides
	Context provideContext() {
		return context;
	}

	@AppScope
	@Provides
	ComponentsHolder provideComponentsHolder() {
		return componentsHolder;
	}
}