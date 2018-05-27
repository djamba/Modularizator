package ru.roman.home.featureone.details.di;

import dagger.Module;
import dagger.Provides;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.core.di.FeatureDetailScope;
import ru.roman.home.core.di.FeatureModule;
import ru.roman.home.featureone.FeatureOneActivity;
import ru.roman.home.featureone.FeatureOneInteractor;
import ru.roman.home.featureone.details.FeatureOneDetailViewModel;
import ru.roman.home.featureone.di.FeatureOneComponent;

@Module
public class FeatureOneDetailModule implements FeatureModule {

	@Provides
	FeatureOneInteractor provideFeatureOneInteractor(ComponentsHolder componentsHolder) {
		FeatureOneComponent parentComponent = (FeatureOneComponent) componentsHolder.getFeatureComponent(FeatureOneActivity.class);
		return parentComponent.getFeatureOneInteractor();
	}

	@Provides
	@FeatureDetailScope
	FeatureOneDetailViewModel provideFeatureOneDetailViewModel(FeatureOneInteractor interactor) {
		return new FeatureOneDetailViewModel(new FeatureOneInteractor());
	}
}
