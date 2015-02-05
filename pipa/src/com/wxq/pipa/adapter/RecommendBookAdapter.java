package com.wxq.pipa.adapter;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wxq.pipa.R;
import com.wxq.pipa.common.bean.BookInfo;

public class RecommendBookAdapter extends BaseAdapter {

	 private Context mContext;
     public LinkedList<BookInfo> mListInfos;
     DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()  
     .showImageOnLoading(R.drawable.img_loading)  
     .showImageOnFail(R.drawable.img_fail)  
     .cacheInMemory(true)  
     .cacheOnDisk(true)  
     .bitmapConfig(Bitmap.Config.RGB_565)  
     .build(); 

     public RecommendBookAdapter(Context context) {
         mContext = context;
         mListInfos = new LinkedList<BookInfo>();
     }

     @Override
     public int getCount() {
         return mListInfos.size();
     }

     @Override
     public Object getItem(int arg0) {
         return mListInfos.get(arg0);
     }

     @Override
     public long getItemId(int arg0) {
         return arg0;
     }

     public void addItemLast(List<BookInfo> datas) {
    	 mListInfos.addAll(datas);
     }

     public void addItemTop(List<BookInfo> datas) {
         for (BookInfo info : datas) {
        	 mListInfos.addFirst(info);
         }
     }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null) {
			convertView=LayoutInflater.from(mContext).inflate(R.layout.recommend_book_item, null);
			holder=new ViewHolder(convertView);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		BookInfo info=mListInfos.get(position);
		ImageLoader.getInstance().displayImage(info.getImages().getLarge(),holder.imageView, displayImageOptions);
		holder.bookName.setText(info.getTitle());
		holder.bookAuthor.setText(info.getAuthor().get(0));
		holder.bookEvaluateNumTv.setText(String.valueOf(info.getRating().getNumRaters()));
		if(Double.parseDouble(info.getRating().getAverage())>=9.0){
			holder.bookPraiseEvaluateNumTv.setTextColor(mContext.getResources().getColor(R.color.red));
		}else{
			holder.bookPraiseEvaluateNumTv.setTextColor(mContext.getResources().getColor(R.color.desc));
		}
		holder.bookPraiseEvaluateNumTv.setText(info.getRating().getAverage());
		return convertView;
	}
	public class ViewHolder{
		@ViewInject(R.id.network_image_view) ImageView imageView;
		@ViewInject(R.id.book_name) TextView bookName;
		@ViewInject(R.id.book_author) TextView bookAuthor;
		@ViewInject(R.id.book_evaluateNumTv) TextView bookEvaluateNumTv;
		@ViewInject(R.id.book_praiseEvaluateNumTv) TextView bookPraiseEvaluateNumTv;
		public ViewHolder(View view) {
			ViewUtils.inject(this, view);
		}
	}

}
