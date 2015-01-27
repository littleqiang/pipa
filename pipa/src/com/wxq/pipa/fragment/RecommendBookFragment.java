package com.wxq.pipa.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.wxq.pipa.R;
import com.wxq.pipa.adapter.RecommendBookAdapter;
import com.wxq.pipa.common.bean.BookInfo;
import com.wxq.pipa.waterfall.base.PLA_AdapterView;
import com.wxq.pipa.waterfall.base.PLA_AdapterView.OnItemClickListener;
import com.wxq.pipa.waterfall.widget.XListView;
import com.wxq.pipa.waterfall.widget.XListView.IXListViewListener;


public class RecommendBookFragment extends BaseFragment implements IXListViewListener{
	@ViewInject(R.id.water_list)
	private XListView mWaterList;
	private List<BookInfo> mListInfos= new ArrayList<BookInfo>();
	private RecommendBookAdapter mAdapter;
	
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
      ViewUtils.inject(this,contentView);
      mWaterList.setPullLoadEnable(true);
      mWaterList.setXListViewListener(this);
      mAdapter = new RecommendBookAdapter(getActivity(), mImageFetcher);
	    mWaterList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(PLA_AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
//				if(position<1)return;
//				FindHairItem info=mAdapter.mListInfos.get(position-1);
//				Intent intent = new Intent(getActivity(),HairCommentActivity.class);
//				Bundle mBundle = new Bundle();    
//			    mBundle.putSerializable("hairInfo",info);    
//			    intent.putExtras(mBundle);
//			    startActivity(intent);
			}
		});
	    parseArgument();
      return contentView;
  }

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub

	}

}
