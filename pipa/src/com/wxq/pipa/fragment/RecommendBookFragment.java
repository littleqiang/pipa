package com.wxq.pipa.fragment;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.wxq.pipa.R;
import com.wxq.pipa.adapter.RecommendBookAdapter;
import com.wxq.pipa.common.Constants;
import com.wxq.pipa.common.Constants.METHOD;
import com.wxq.pipa.common.bean.BookInfo;
import com.wxq.pipa.common.bean.SearchBooks;
import com.wxq.pipa.common.net.GsonRequest;
import com.wxq.pipa.volley.RequestQueue;
import com.wxq.pipa.volley.Response;
import com.wxq.pipa.volley.VolleyError;
import com.wxq.pipa.volley.toolbox.Volley;
import com.wxq.pipa.waterfall.base.PLA_AdapterView;
import com.wxq.pipa.waterfall.base.PLA_AdapterView.OnItemClickListener;
import com.wxq.pipa.waterfall.widget.XListView;
import com.wxq.pipa.waterfall.widget.XListView.IXListViewListener;


public class RecommendBookFragment extends BaseFragment implements IXListViewListener{
	@ViewInject(R.id.water_list)
	private XListView mWaterList;
	private LinkedList<BookInfo> mListInfos= new LinkedList<BookInfo>();
	private RecommendBookAdapter mAdapter;
	private int currentPage = 1;
	
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
      mAdapter = new RecommendBookAdapter(getActivity());
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
  private void parseArgument() {
    mWaterList.setAdapter(mAdapter);
    Bundle bundle = getArguments();
    int position=bundle.getInt("position");
    switch(position) {
    case 0:
    case 1:
        AddItemToContainer(++currentPage, 1);
        break;
    }
}
  private void AddItemToContainer(int pageindex, final int type) {
    String param="";
    try {
      param=URLEncoder.encode("幾米", "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    int offset=pageindex*20;
    String url = Constants.getURL(METHOD.DOUBAN_BOOKS, "search?tag="+param+"&start="+offset);
    RequestQueue mRequestQueue=Volley.newRequestQueue(getActivity());
    GsonRequest<SearchBooks> mGsonRequest=new GsonRequest<SearchBooks>(url,SearchBooks.class,new Response.Listener<SearchBooks>() {

      @Override
      public void onResponse(SearchBooks response) {
        mListInfos=response.getBooks();
        if (type == 1) {
          mAdapter.mListInfos=mListInfos;
          mAdapter.notifyDataSetChanged();
          mWaterList.stopRefresh();
      } else if (type == 2) {
          mWaterList.stopLoadMore();
          mAdapter.addItemLast(mListInfos);
          mAdapter.notifyDataSetChanged();
      }
      }},new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
          
        }});
    mRequestQueue.add(mGsonRequest);
}
	@Override
	public void onRefresh() {
	  currentPage=1;
      AddItemToContainer(currentPage, 1);
	}

	@Override
	public void onLoadMore() {
      AddItemToContainer(++currentPage, 2);
	}

}
