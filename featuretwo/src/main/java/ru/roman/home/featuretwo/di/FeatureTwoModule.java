package ru.roman.home.featuretwo.di;

import dagger.Module;
import dagger.Provides;
import ru.roman.home.core.di.FeatureModule;
import ru.roman.home.core.di.FeatureScope;
import ru.roman.home.featuretwo.FeatureTwoViewModel;

@Module
public class FeatureTwoModule implements FeatureModule {

	@Provides
	@FeatureScope
	FeatureTwoViewModel provideFeatureOneViewModel() {
		return new FeatureTwoViewModel();
	}
}
