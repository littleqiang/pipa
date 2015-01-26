package com.wxq.pipa.app;

import java.util.LinkedList;

import android.app.Activity;
import android.app.Application;

public class InitApplication extends Application{
  private static final String Tag="InitApplication";
  private static boolean isLogged = false;     
  private static InitApplication instance;
  private Activity activity;
  private static LinkedList<Activity> activityList;
  
  @Override
  public void onCreate()
  {
      instance = this;
      super.onCreate();
//      if (!BuildConfig.DEBUG) {
//          /* 全局异常崩溃处理 */
//          CrashHandler catchExcep = new CrashHandler(this);
//          Thread.setDefaultUncaughtExceptionHandler(catchExcep);  
//      }
      activityList = new LinkedList<Activity>();
      super.onCreate();
  }
  
  /** 
   * Activity关闭时，删除Activity列表中的Activity对象*/  
  public void removeActivity(Activity a){  
      activityList.remove(a);  
  }  
  
  /** 
   * 向Activity列表中添加Activity对象*/  
  public void addActivity(Activity a){  
      activityList.add(a);  
  }  
  
  /** 
   * 关闭Activity列表中的所有Activity*/  
  public void finishActivity(){  
      for (Activity activity : activityList) {    
          if (null != activity) {    
              activity.finish();    
          }    
      }
      activityList.clear();
      //杀死该应用进程  
      android.os.Process.killProcess(android.os.Process.myPid());    
  }
  
  private static InitApplication getInstance(){
    return instance;
  }
  
  public Activity getActivity() {
    return activity;
  }
  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public static boolean isLogged() {
    return isLogged;
  }

  public static void setLogged(boolean isLogged) {
    InitApplication.isLogged = isLogged;
  }
  
}
