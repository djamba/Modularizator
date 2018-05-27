package ru.roman.home.modularizator;

import android.app.Application;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.core.di.ComponentsHolderOwner;
import ru.roman.home.modularizator.di.ComponentsHolderImpl;

public class App extends Application implements ComponentsHolderOwner {

	private ComponentsHolderImpl componentsHolder;

	@Override
	public void onCreate() {
		super.onCreate();

		componentsHolder = new ComponentsHolderImpl(this);
		componentsHolder.init();
	}

	@Override
	public ComponentsHolder getComponentsHolder() {
		return componentsHolder;
	}
}
