package ru.roman.home.core.di;

/**
 * User: roman
 * Date: 21.05.18
 * Time: 22:37
 */
public interface ComponentsHolder {

	FeatureComponent getFeatureComponent(Class<?> cls);

	FeatureComponent getFeatureComponent(Class<?> cls, FeatureModule module);

	void releaseFeatureComponent(Class<?> cls);
}
