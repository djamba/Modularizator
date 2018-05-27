package ru.roman.home.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.core.di.ComponentsHolderOwner;
import ru.roman.home.core.di.FeatureComponent;

public class BaseActivity extends AppCompatActivity {

	private FeatureComponent<?> featureComponent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		onInject(((ComponentsHolderOwner) getApplication()).getComponentsHolder(), savedInstanceState);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		if (isFinishing()) {
			onRelease(((ComponentsHolderOwner) getApplication()).getComponentsHolder());
		}
	}

	protected void onInject(ComponentsHolder componentsHolder, Bundle state) {
	}

	protected void onRelease(ComponentsHolder componentsHolder) {
	}
}
