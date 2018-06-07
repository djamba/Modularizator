package ru.roman.home.core.di;

import dagger.BindsInstance;

public interface FeatureComponentBuilder<C extends FeatureComponent, M extends FeatureModule>   {

	C build();

	FeatureComponentBuilder<C, M> module(M module);

	@BindsInstance
	FeatureComponentBuilder<C, M> parentComponent(@ParentComponent FeatureComponent parentComponent);
}