package ru.roman.home.featureone.di;

import dagger.Subcomponent;
import ru.roman.home.core.di.FeatureComponent;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.core.di.FeatureScope;
import ru.roman.home.featureone.FeatureOneActivity;
import ru.roman.home.featureone.FeatureOneInteractor;

@FeatureScope
@Subcomponent(modules = FeatureOneModule.class)
public interface FeatureOneComponent extends FeatureComponent<FeatureOneActivity> {

	FeatureOneInteractor getFeatureOneInteractor();

	@Subcomponent.Builder
	interface Builder extends FeatureComponentBuilder<FeatureOneComponent, FeatureOneModule> {
	}
}
