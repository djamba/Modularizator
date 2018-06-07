package ru.roman.home.featureone.details.di;

import dagger.Module;
import dagger.Provides;
import ru.roman.home.core.di.FeatureComponent;
import ru.roman.home.core.di.FeatureDetailScope;
import ru.roman.home.core.di.FeatureModule;
import ru.roman.home.core.di.ParentComponent;
import ru.roman.home.featureone.FeatureOneInteractor;
import ru.roman.home.featureone.details.FeatureOneDetailViewModel;
import ru.roman.home.featureone.di.FeatureOneComponent;

@Module
public class FeatureOneDetailModule implements FeatureModule {

	@Provides
	FeatureOneInteractor provideFeatureOneInteractor(@ParentComponent FeatureComponent parentComponent) {
		return ((FeatureOneComponent) parentComponent).getFeatureOneInteractor();
	}

	@Provides
	@FeatureDetailScope
	FeatureOneDetailViewModel provideFeatureOneDetailViewModel(FeatureOneInteractor interactor) {
		return new FeatureOneDetailViewModel(new FeatureOneInteractor());
	}
}
