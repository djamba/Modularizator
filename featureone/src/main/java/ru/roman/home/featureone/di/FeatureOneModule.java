package ru.roman.home.featureone.di;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.core.di.FeatureModule;
import ru.roman.home.core.di.FeatureScope;
import ru.roman.home.featureone.FeatureOneViewModel;
import ru.roman.home.featureone.details.FeatureOneDetailActivity;
import ru.roman.home.featureone.details.di.FeatureOneDetailComponent;

@Module(subcomponents = { FeatureOneDetailComponent.class })
public class FeatureOneModule implements FeatureModule {

	@Provides
	@FeatureScope
	FeatureOneViewModel provideFeatureOneViewModel() {
		return new FeatureOneViewModel();
	}

	@Provides
	@IntoMap
	@ClassKey(FeatureOneDetailActivity.class)
	FeatureComponentBuilder provideFeatureOneBuilder(FeatureOneDetailComponent.Builder builder) {
		return builder;
	}
}
