package ru.roman.home.core.di;

public interface FeatureComponent<F> {

	void inject(F feature);
}
