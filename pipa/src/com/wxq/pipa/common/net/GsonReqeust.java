package com.wxq.pipa.common.net;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.wxq.pipa.volley.AuthFailureError;
import com.wxq.pipa.volley.NetworkResponse;
import com.wxq.pipa.volley.ParseError;
import com.wxq.pipa.volley.Request;
import com.wxq.pipa.volley.Response;
import com.wxq.pipa.volley.Response.ErrorListener;
import com.wxq.pipa.volley.Response.Listener;
import com.wxq.pipa.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class GsonReqeust<T> extends Request<T> { 
	private final Gson gson=new Gson();
//	private final Class<T> clazz;
	private final Map<String, String> headers;
	private final Listener<T> listener;

	/**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url URL of the request to make
     * @param clazz Relevant class object, for Gson's reflection
     * @param headers Map of request headers
     */
    public GsonReqeust(String url, Map<String, String> headers,
            Listener<T> listener, ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
//        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
    }
    
	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return headers != null ? headers : super.getHeaders();
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
//		 try {
//	            String json = new String(
//	                    response.data,
//	                    HttpHeaderParser.parseCharset(response.headers));
//	            return Response.success(
//	                    gson.fromJson(json, clazz),
//	                    HttpHeaderParser.parseCacheHeaders(response));
//	        } catch (UnsupportedEncodingException e) {
//	            return Response.error(new ParseError(e));
//	        } catch (JsonSyntaxException e) {
//	            return Response.error(new ParseError(e));
//	        }
//		 
		 String parsed;  
	        try {  
	            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));  
	        } catch (UnsupportedEncodingException e) {  
	            parsed = new String(response.data);  
	        }  
	        return (Response<T>) Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response)); 
	}

	@Override
	protected void deliverResponse(T response) {
		listener.onResponse(response);
	}
    

}  
