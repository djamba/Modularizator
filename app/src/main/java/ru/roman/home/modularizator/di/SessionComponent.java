package ru.roman.home.modularizator.di;

import dagger.Subcomponent;
import ru.roman.home.core.di.FeatureComponent;
import ru.roman.home.core.di.SessionScope;

@SessionScope
@Subcomponent(modules = SessionModule.class)
public interface SessionComponent extends FeatureComponent<ComponentsHolderImpl> {

	@Override
	void inject(ComponentsHolderImpl componentsHolder);

	@Subcomponent.Builder
	interface Builder {

		Builder module(SessionModule module);

		SessionComponent build();
	}
}
