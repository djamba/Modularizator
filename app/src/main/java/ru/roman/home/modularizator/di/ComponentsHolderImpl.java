package ru.roman.home.modularizator.di;

import android.content.Context;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.core.di.FeatureComponent;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.core.di.FeatureModule;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.HashMap;
import java.util.Map;

public class ComponentsHolderImpl implements ComponentsHolder {

	private final Context context;

	@Inject
	Map<Class<?>, Provider<FeatureComponentBuilder>> builders;

	private Map<Class<?>, FeatureComponent> components;

	public ComponentsHolderImpl(Context context) {
		this.context = context;
	}

	public void init() {
		AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(context)).build();
		appComponent.injectComponentsHolder(this);
		components = new HashMap<>();
	}

	@Override
	public FeatureComponent getFeatureComponent(Class<?> cls) {
		return getFeatureComponent(cls, null);
	}

	@Override
	public FeatureComponent getFeatureComponent(Class<?> cls, FeatureModule module) {

		FeatureComponent component = components.get(cls);

		if (component == null) {
			FeatureComponentBuilder builder = builders.get(cls).get();

			if (module != null) {
				builder.module(module);
			}

			component = builder.build();
			components.put(cls, component);
		}

		return component;
	}

	@Override
	public void releaseFeatureComponent(Class<?> cls) {
		components.put(cls, null);
	}
}
