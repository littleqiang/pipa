package com.wxq.pipa;

import java.io.UnsupportedEncodingException;

import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.wxq.pipa.utils.Constants;
import com.wxq.pipa.utils.CustomReqeust;


public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    RequestQueue mQueue= Volley.newRequestQueue(MainActivity.this);
    String param="¼¸Ã×";
    final String url= Constants.BASEURL+Constants.URLBOOK+ Constants.METHOD.search+"?"+"tag="+param+"&start=0&count=";
    Log.d("TAG",url);
    CustomReqeust request = new CustomReqeust(url, "CustomVolley", new Listener<String>() {  
      
      @Override  
      public void onResponse(String arg0) {  
          Log.d("onResponse", arg0);  
      }  
  }, new ErrorListener() {  

      @Override  
      public void onErrorResponse(VolleyError arg0) {  
          Log.d("onErrorResponse", arg0.toString());  
      }  
  }); 
    mQueue.add(jsonObjectRequest); 
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
