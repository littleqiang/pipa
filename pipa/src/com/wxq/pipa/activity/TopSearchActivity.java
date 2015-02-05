package com.wxq.pipa.activity;

import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.wxq.pipa.BaseActivity;
import com.wxq.pipa.R;

public class TopSearchActivity extends BaseActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_topic_search);
		ViewUtils.inject(this);
	}
}
