package ru.roman.home.core;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;
import ru.roman.home.core.di.ComponentsHolder;
import ru.roman.home.core.di.ComponentsHolderOwner;
import ru.roman.home.core.di.DiInjector;

public class BaseActivity extends AppCompatActivity {

	private Class<?> classKeyComponent;

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		classKeyComponent = onInject(((ComponentsHolderOwner) getApplication()).getInjector(), savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		if (isFinishing()) {
			onRelease(((ComponentsHolderOwner) getApplication()).getComponentsHolder());
		}
	}

	protected Class<?> onInject(DiInjector injector, Bundle state) {
		return null;
	}

	@CallSuper
	protected void onRelease(final ComponentsHolder componentsHolder) {
		if (classKeyComponent != null) {
			componentsHolder.releaseFeatureComponent(classKeyComponent);
		}
	}
}
