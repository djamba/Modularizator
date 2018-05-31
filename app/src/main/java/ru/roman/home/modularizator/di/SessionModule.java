package ru.roman.home.modularizator.di;

import dagger.Module;
import dagger.Provides;
import ru.roman.home.core.di.SessionScope;
import ru.roman.home.core.di.SessionToken;
import ru.roman.home.featureone.details.di.FeatureOneComponentsBinding;

import java.util.UUID;

@Module(includes = { FeatureTwoComponentBinding.class, FeatureOneComponentsBinding.class })
public class SessionModule {

	@Provides
	@SessionScope
	@SessionToken
	String provideSessionToken() {
		return UUID.randomUUID().toString();
	}
}
