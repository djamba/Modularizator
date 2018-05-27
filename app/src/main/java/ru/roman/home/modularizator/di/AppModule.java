package ru.roman.home.modularizator.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ru.roman.home.core.di.AppScope;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.featureone.FeatureOneActivity;
import ru.roman.home.featureone.details.FeatureOneDetailActivity;
import ru.roman.home.featureone.details.di.FeatureOneDetailComponent;
import ru.roman.home.featureone.di.FeatureOneComponent;
import ru.roman.home.featuretwo.FeatureTwoActivity;
import ru.roman.home.featuretwo.di.FeatureTwoComponent;

@Module(subcomponents = { FeatureOneComponent.class, FeatureTwoComponent.class, FeatureOneDetailComponent.class })
class AppModule {

	private final Context context;
	private final ComponentsHolder componentsHolder;

	AppModule(Context context, ComponentsHolder componentsHolder) {
		this.context = context;
		this.componentsHolder = componentsHolder;
	}

	@AppScope
	@Provides
	Context provideContext() {
		return context;
	}

	@AppScope
	@Provides
	ComponentsHolder provideComponentsHolder() {
		return componentsHolder;
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

	@Provides
	@IntoMap
	@ClassKey(FeatureOneDetailActivity.class)
	FeatureComponentBuilder provideFeatureOneDetailBuilder(FeatureOneDetailComponent.Builder builder) {
		return builder;
	}
}