package com.wxq.pipa.common;


public class Constants {
  public static final String BASEURL="https://api.douban.com/";
  public static final String URLBOOK="v2/book/";//豆瓣读书
  public static final String APPKEY="";
  public static final String APPSECRET="";
  public static final String TOKEN="";


  public enum METHOD{
      DOUBAN_BOOKS
  }
  public static String getURL(METHOD act,String url) {
    switch(act) {
    case DOUBAN_BOOKS:
        return BASEURL+URLBOOK+url;
    default:
        return "";
    }
}
}
