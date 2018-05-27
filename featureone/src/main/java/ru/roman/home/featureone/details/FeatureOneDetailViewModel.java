package ru.roman.home.featureone.details;

import ru.roman.home.featureone.FeatureOneInteractor;

public class FeatureOneDetailViewModel {

	public FeatureOneDetailViewModel(FeatureOneInteractor interactor) {
		interactor.action();
	}
}
