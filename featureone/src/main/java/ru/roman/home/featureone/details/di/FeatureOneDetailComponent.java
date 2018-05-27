package ru.roman.home.featureone.details.di;

import dagger.Subcomponent;
import ru.roman.home.core.di.FeatureComponent;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.core.di.FeatureDetailScope;
import ru.roman.home.featureone.details.FeatureOneDetailActivity;

@FeatureDetailScope
@Subcomponent(modules = FeatureOneDetailModule.class)
public interface FeatureOneDetailComponent extends FeatureComponent<FeatureOneDetailActivity> {

	@Subcomponent.Builder
	interface Builder extends FeatureComponentBuilder<FeatureOneDetailComponent, FeatureOneDetailModule> {
	}
}
