package ru.roman.home.featureone.di;

import dagger.Module;
import dagger.Provides;
import ru.roman.home.core.di.FeatureModule;
import ru.roman.home.core.di.FeatureScope;
import ru.roman.home.featureone.FeatureOneInteractor;
import ru.roman.home.featureone.FeatureOneViewModel;

@Module
public class FeatureOneModule implements FeatureModule {

	@Provides
	@FeatureScope
	FeatureOneInteractor provideFeatureOneInteractor() {
		return new FeatureOneInteractor();
	}

	@Provides
	@FeatureScope
	FeatureOneViewModel provideFeatureOneViewModel(FeatureOneInteractor interactor) {
		return new FeatureOneViewModel(interactor);
	}
}
