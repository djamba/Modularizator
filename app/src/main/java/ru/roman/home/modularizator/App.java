package ru.roman.home.modularizator;

import android.app.Application;
import ru.roman.home.core.Session;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.core.di.ComponentsHolderOwner;
import ru.roman.home.core.di.DiInjector;
import ru.roman.home.modularizator.di.AppComponent;
import ru.roman.home.modularizator.di.AppModule;
import ru.roman.home.modularizator.di.ComponentsHolderImpl;
import ru.roman.home.modularizator.di.DaggerAppComponent;

public class App extends Application implements ComponentsHolderOwner, Session {

	private ComponentsHolderImpl componentsHolder;

	@Override
	public void onCreate() {
		super.onCreate();

		componentsHolder = new ComponentsHolderImpl(this);

		AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this, componentsHolder)).build();
		appComponent.inject(this);
		componentsHolder.init(appComponent);

		createSession();
	}

	@Override
	public ComponentsHolder getComponentsHolder() {
		return componentsHolder;
	}

	@Override
	public DiInjector getInjector() {
		return componentsHolder;
	}

	@Override
	public void createSession() {
		componentsHolder.initSession();
	}
}
