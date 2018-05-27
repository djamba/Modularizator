package ru.roman.home.featureone.di;

import dagger.Subcomponent;
import ru.roman.home.core.di.FeatureComponent;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.core.di.FeatureScope;
import ru.roman.home.featureone.FeatureOneActivity;

@FeatureScope
@Subcomponent(modules = FeatureOneModule.class)
public interface FeatureOneComponent extends FeatureComponent<FeatureOneActivity> {

//	FeatureOneDetailComponent plus(FeatureOneDetailModule module);

	@Subcomponent.Builder
	interface Builder extends FeatureComponentBuilder<FeatureOneComponent, FeatureOneModule> {
	}
}
