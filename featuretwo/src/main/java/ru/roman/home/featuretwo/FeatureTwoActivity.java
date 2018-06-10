package ru.roman.home.featuretwo;

import android.os.Bundle;
import ru.roman.home.core.BaseActivity;

import javax.inject.Inject;

public class FeatureTwoActivity extends BaseActivity {

	@Inject FeatureTwoViewModel viewModel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feature_two);
	}
}
