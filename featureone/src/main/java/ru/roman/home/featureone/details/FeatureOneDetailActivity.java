package ru.roman.home.featureone.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import ru.roman.home.core.BaseActivity;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.core.di.SessionToken;
import ru.roman.home.featureone.FeatureOneInteractor;
import ru.roman.home.featureone.R;
import ru.roman.home.featureone.details.di.FeatureOneDetailModule;

import javax.inject.Inject;

public class FeatureOneDetailActivity extends BaseActivity {

	public static void start(Context context) {
		context.startActivity(new Intent(context, FeatureOneDetailActivity.class));
	}

	@Inject
	FeatureOneInteractor interactor;

	@Inject
	FeatureOneDetailViewModel viewModel;

	@Inject
	@SessionToken
	String sessionToken;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feature_one_detail);
	}

	@Override
	protected void onInject(ComponentsHolder componentsHolder, Bundle state) {

		componentsHolder.getFeatureComponent(getClass(), new FeatureOneDetailModule()).inject(this);
	}

	@Override
	protected void onRelease(ComponentsHolder componentsHolder) {

		componentsHolder.releaseFeatureComponent(getClass());
	}
}
