package ru.roman.home.featuretwo.di;

import dagger.Subcomponent;
import ru.roman.home.core.di.FeatureComponent;
import ru.roman.home.core.di.FeatureComponentBuilder;
import ru.roman.home.core.di.FeatureScope;
import ru.roman.home.featuretwo.FeatureTwoActivity;

@FeatureScope
@Subcomponent(modules = FeatureTwoModule.class)
public interface FeatureTwoComponent extends FeatureComponent<FeatureTwoActivity> {

	@Subcomponent.Builder
	interface Builder extends FeatureComponentBuilder<FeatureTwoComponent, FeatureTwoModule> {

	}
}
