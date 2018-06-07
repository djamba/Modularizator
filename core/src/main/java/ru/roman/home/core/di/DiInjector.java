package ru.roman.home.core.di;

/**
 * User: ischenko
 * Date: 07.06.2018
 * Time: 9:44
 */
public interface DiInjector {

	<K> Class<?> inject(K injectableObject);

	<K> Class<?> inject(K injectableObject, FeatureModule module);

	<K> Class<?> inject(final Class<?> parentGraphKey, final K injectableObject, final FeatureModule module);
}
