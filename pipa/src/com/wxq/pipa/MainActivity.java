package com.wxq.pipa;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.wxq.pipa.adapter.MainFragmentAdapter;
import com.wxq.pipa.view.viewpagerindicator.PageIndicator;
import com.wxq.pipa.view.viewpagerindicator.TitlePageIndicator;

public class MainActivity extends FragmentActivity{

  MainFragmentAdapter mAdapter;
  ViewPager mPager;
  PageIndicator mIndicator;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      mAdapter = new MainFragmentAdapter(getSupportFragmentManager());

      mPager = (ViewPager)findViewById(R.id.pager);
      mPager.setAdapter(mAdapter);

      mIndicator = (TitlePageIndicator)findViewById(R.id.indicator);
      mIndicator.setViewPager(mPager);
  }
}
