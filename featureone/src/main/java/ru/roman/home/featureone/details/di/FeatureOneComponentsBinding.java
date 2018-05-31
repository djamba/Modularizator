package ru.roman.home.featureone.details.di;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.featureone.FeatureOneActivity;
import ru.roman.home.featureone.details.FeatureOneDetailActivity;
import ru.roman.home.featureone.di.FeatureOneComponent;

@Module(subcomponents = { FeatureOneComponent.class, FeatureOneDetailComponent.class })
public interface FeatureOneComponentsBinding {

	@Binds
	@IntoMap
	@ClassKey(FeatureOneActivity.class)
	FeatureComponentBuilder provideFeatureOneBuilder(FeatureOneComponent.Builder builder);

	@Binds
	@IntoMap
	@ClassKey(FeatureOneDetailActivity.class)
	FeatureComponentBuilder provideFeatureOneDetailBuilder(FeatureOneDetailComponent.Builder builder);
}
