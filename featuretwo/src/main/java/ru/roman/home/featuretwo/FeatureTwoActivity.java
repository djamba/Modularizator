package ru.roman.home.featuretwo;

import android.os.Bundle;
import ru.roman.home.core.BaseActivity;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.featuretwo.di.FeatureTwoModule;

import javax.inject.Inject;

public class FeatureTwoActivity extends BaseActivity {

	@Inject FeatureTwoViewModel viewModel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feature_two);
	}

	@Override
	protected void onInject(ComponentsHolder componentsHolder, Bundle state) {

		componentsHolder.getFeatureComponent(getClass(), new FeatureTwoModule()).inject(this);
	}

	@Override
	protected void onRelease(ComponentsHolder componentsHolder) {

		componentsHolder.releaseFeatureComponent(getClass());
	}
}
