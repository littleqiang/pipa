package com.wxq.pipa.common;


public class Constants {
  public static final String BASEURL="https://api.douban.com/";
  public static final String URLBOOK="v2/book/";//豆瓣读书
  public static final String APPKEY="EDF4B85EBCCC888D5A6516CD0209F449";
  public static final String APPSECRET="193d6ae63d714310b1d44fbfd09cee2b";
  public static final String TOKEN="e79f24dd-a70e-4f94-937a-84ce797a3988";


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
