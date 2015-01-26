package com.wxq.pipa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wxq.pipa.R;


public class RecommendBookFragment extends BaseFragment{

  public static RecommendBookFragment newInstance(int position) {
    RecommendBookFragment fragment = new RecommendBookFragment();
      Bundle bundle = new Bundle();
      bundle.putInt("position", position);
      fragment.setArguments(bundle);
      return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View contentView = inflater.inflate(R.layout.recommend_book_fragment, container, false);
      return contentView;
  }

}
