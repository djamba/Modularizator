package ru.roman.home.modularizator.di;

import dagger.Subcomponent;
import ru.roman.home.core.di.SessionScope;

@SessionScope
@Subcomponent(modules = SessionModule.class)
public interface SessionComponent {

	void injectComponentsHolder(ComponentsHolderImpl componentsHolder);
}
