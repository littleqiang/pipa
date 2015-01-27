package com.wxq.pipa.common.net;

import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.wxq.pipa.volley.NetworkResponse;
import com.wxq.pipa.volley.ParseError;
import com.wxq.pipa.volley.Request;
import com.wxq.pipa.volley.Response;
import com.wxq.pipa.volley.Response.ErrorListener;
import com.wxq.pipa.volley.Response.Listener;
import com.wxq.pipa.volley.toolbox.HttpHeaderParser;

public class GsonRequest<T> extends Request<T> { 
  private final Listener<T> mListener;  
  
  private Gson mGson;  

  private Class<T> mClass;  

  public GsonRequest(int method, String url, Class<T> clazz, Listener<T> listener,  
          ErrorListener errorListener) {  
      super(method, url, errorListener);  
      mGson = new Gson();  
      mClass = clazz;  
      mListener = listener;  
  }  

  public GsonRequest(String url, Class<T> clazz, Listener<T> listener,  
          ErrorListener errorListener) {  
      this(Method.GET, url, clazz, listener, errorListener);  
  }  

  @Override  
  protected Response<T> parseNetworkResponse(NetworkResponse response) {  
      try {  
          String jsonString = new String(response.data,  
                  HttpHeaderParser.parseCharset(response.headers));
          System.out.println(jsonString);
          return Response.success(mGson.fromJson(jsonString, mClass),  
                  HttpHeaderParser.parseCacheHeaders(response));  
      } catch (UnsupportedEncodingException e) {  
          return Response.error(new ParseError(e));  
      }  
  }  

  @Override  
  protected void deliverResponse(T response) {  
      mListener.onResponse(response);  
  }  
    

}  
