package ru.roman.home.featureone;

import android.os.Bundle;
import android.view.View;
import ru.roman.home.core.BaseActivity;
import ru.roman.home.core.Session;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.featureone.details.FeatureOneDetailActivity;
import ru.roman.home.featureone.di.FeatureOneModule;

import javax.inject.Inject;

public class FeatureOneActivity extends BaseActivity {

	@Inject
	FeatureOneViewModel viewModel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feature_one);

		((Session) getApplication()).createSession();

		findViewById(R.id.btn_details).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FeatureOneDetailActivity.start(FeatureOneActivity.this);
			}
		});
	}

	@Override
	protected void onInject(ComponentsHolder componentsHolder, Bundle state) {

		componentsHolder.getFeatureComponent(getClass(), new FeatureOneModule()).inject(this);
	}

	@Override
	protected void onRelease(ComponentsHolder componentsHolder) {

		componentsHolder.releaseFeatureComponent(getClass());
	}
}
