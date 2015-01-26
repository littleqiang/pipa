package com.wxq.pipa.utils;

import java.io.UnsupportedEncodingException;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;

public class CustomReqeust extends Request<String> {  
  /** http«Î«Û±‡¬Î∑Ω Ω */  
  private static final String PROTOCOL_CHARSET = "gbk";  

  private Listener<String> mListener;  
  private String mUserName;  

  public CustomReqeust(String url, String userName, Listener<String> listener, ErrorListener errorListener) {  
      super(Method.POST, url, errorListener);  
      mUserName = userName;  
      mListener = listener;  
  }  

  @Override  
  protected Response<String> parseNetworkResponse(NetworkResponse response) {  
      String parsed;  
      try {  
          parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));  
      } catch (UnsupportedEncodingException e) {  
          parsed = new String(response.data);  
      }  
      return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));  
  }  

  @Override  
  protected void deliverResponse(String response) {  
      mListener.onResponse(response);  
  }  

  @Override  
  public byte[] getBody() {  
      try {  
          return mUserName == null ? null : mUserName.getBytes(PROTOCOL_CHARSET);  
      } catch (UnsupportedEncodingException uee) {  
          VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mUserName, PROTOCOL_CHARSET);  
          return null;  
      }  
  }  
}  
