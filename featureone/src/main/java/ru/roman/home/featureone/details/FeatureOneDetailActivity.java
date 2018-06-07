package ru.roman.home.featureone.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import ru.roman.home.core.BaseActivity;
import ru.roman.home.core.di.DiInjector;
import ru.roman.home.core.di.SessionToken;
import ru.roman.home.featureone.FeatureOneActivity;
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
	protected Class<?> onInject(final DiInjector injector, final Bundle state) {
		return injector.inject(FeatureOneActivity.class, this, new FeatureOneDetailModule());
	}
}
