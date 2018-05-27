package ru.roman.home.core.di;

public interface FeatureComponentBuilder<C extends FeatureComponent, M extends FeatureModule>   {

	C build();

	FeatureComponentBuilder<C, M> module(M module);
}