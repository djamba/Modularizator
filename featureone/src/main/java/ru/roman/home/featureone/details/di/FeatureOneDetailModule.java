package ru.roman.home.featureone.details.di;

import dagger.Module;
import dagger.Provides;
import ru.roman.home.core.di.FeatureDetailScope;
import ru.roman.home.core.di.FeatureModule;
import ru.roman.home.featureone.details.FeatureOneDetailViewModel;

@Module
public class FeatureOneDetailModule implements FeatureModule {

	@Provides
	@FeatureDetailScope
	FeatureOneDetailViewModel provideFeatureOneDetailViewModel() {
		return new FeatureOneDetailViewModel();
	}
}
