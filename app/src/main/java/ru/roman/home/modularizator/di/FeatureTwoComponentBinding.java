package ru.roman.home.modularizator.di;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.featuretwo.FeatureTwoActivity;
import ru.roman.home.featuretwo.di.FeatureTwoComponent;

@Module(subcomponents = { FeatureTwoComponent.class })
public interface FeatureTwoComponentBinding {

	@Binds
	@IntoMap
	@ClassKey(FeatureTwoActivity.class)
	FeatureComponentBuilder provideFeatureTwoBuilder(FeatureTwoComponent.Builder builder);
}
