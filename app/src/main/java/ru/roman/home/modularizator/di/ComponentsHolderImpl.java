package ru.roman.home.modularizator.di;

import android.content.Context;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.core.di.DiInjector;
import ru.roman.home.core.di.FeatureComponent;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.core.di.FeatureModule;
import ru.roman.home.modularizator.App;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.HashMap;
import java.util.Map;

public class ComponentsHolderImpl implements ComponentsHolder, DiInjector {

	private final Context context;
	private AppComponent appComponent;

	@Inject
	Map<Class<?>, Provider<FeatureComponentBuilder>> builders;

	private Map<Class<?>, FeatureComponent> components;

	public ComponentsHolderImpl(Context context) {
		this.context = context;
	}

	public void init(AppComponent appComponent) {
		this.appComponent = appComponent;
		this.components = new HashMap<>();
	}

	public void initSession() {
		SessionComponent sessionComponent = appComponent.sessionComponent().module(new SessionModule()).build();
		sessionComponent.inject(this);
	}

	@Override
	public FeatureComponent getFeatureComponent(Class<?> cls) {
		return getFeatureComponent(cls, null);
	}

	@Override
	public FeatureComponent getFeatureComponent(Class<?> cls, FeatureModule module) {
		return getFeatureComponent(App.class, cls, module);
	}

	@Override
	public FeatureComponent getFeatureComponent(Class<?> parentCls, Class<?> cls, FeatureModule module) {

		FeatureComponent component = components.get(cls);

		if (component == null) {
			FeatureComponentBuilder builder = builders.get(cls).get();

			if (module != null) {
				builder.module(module);
			}

			FeatureComponent parentComponent = components.get(parentCls);
			if (parentComponent != null) {
				builder.parentComponent(parentComponent);
			} else {
				builder.parentComponent(appComponent);
			}

			component = builder.build();
			components.put(cls, component);
		}

		return component;
	}

	@Override
	public <K> Class<?> inject(final K injectableObject) {
		final Class<?> cls = injectableObject.getClass();
		getFeatureComponent(cls).inject(injectableObject);
		return cls;
	}

	@Override
	public <K> Class<?> inject(final K injectableObject, final FeatureModule module) {
		final Class<?> cls = injectableObject.getClass();
		getFeatureComponent(cls, module).inject(injectableObject);
		return cls;
	}

	@Override
	public <K> Class<?> inject(final Class<?> parentGraphKey, final K injectableObject, final FeatureModule module) {
		final Class<?> cls = injectableObject.getClass();
		getFeatureComponent(parentGraphKey, cls, module).inject(injectableObject);
		return cls;
	}

	@Override
	public void releaseFeatureComponent(Class<?> cls) {
		components.put(cls, null);
	}
}
