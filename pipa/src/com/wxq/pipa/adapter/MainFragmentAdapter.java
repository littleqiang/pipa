package com.wxq.pipa.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wxq.pipa.fragment.HotTagsFragment;
import com.wxq.pipa.fragment.RecommendBookFragment;

public class MainFragmentAdapter extends FragmentPagerAdapter{
    protected static final String[] CONTENT = new String[] { "推荐图书", "热门标签" };

    private int mCount = CONTENT.length;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return RecommendBookFragment.newInstance(position);
        case 1:
          return HotTagsFragment.newInstance(position);
      }
      return null;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return MainFragmentAdapter.CONTENT[position % CONTENT.length];
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}