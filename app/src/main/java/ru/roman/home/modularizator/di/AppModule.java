package ru.roman.home.modularizator.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ru.roman.home.core.di.AppScope;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.featureone.FeatureOneActivity;
import ru.roman.home.featureone.di.FeatureOneComponent;
import ru.roman.home.featuretwo.FeatureTwoActivity;
import ru.roman.home.featuretwo.di.FeatureTwoComponent;

@Module(subcomponents = { FeatureOneComponent.class, FeatureTwoComponent.class })
class AppModule {

	private final Context context;

	AppModule(Context context) {
		this.context = context;
	}

	@AppScope
	@Provides
	Context provideContext() {
		return context;
	}

	@Provides
	@IntoMap
	@ClassKey(FeatureOneActivity.class)
	FeatureComponentBuilder provideFeatureOneBuilder(FeatureOneComponent.Builder builder) {
		return builder;
	}

	@Provides
	@IntoMap
	@ClassKey(FeatureTwoActivity.class)
	FeatureComponentBuilder provideFeatureTwoBuilder(FeatureTwoComponent.Builder builder) {
		return builder;
	}

//	@Provides
//	@IntoMap
//	@ClassKey(FeatureOneDetailActivity.class)
//	FeatureComponentBuilder provideFeatureOneDetailBuilder(FeatureOneDetailComponent.Builder builder) {
//		return builder;
//	}
}