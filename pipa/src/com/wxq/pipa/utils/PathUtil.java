/**
 * 
 */
package com.wxq.pipa.utils;

import android.os.Environment;

/**
 * @author Administrator
 *
 * 描述:
 */
public class PathUtil {
	public static final String ROOT = Environment.getExternalStorageDirectory().getPath() + "/pipa/";
	public static final String CAMERA = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
	public static final String CACHE_IMG ="/cache/images/";
	 /**
     * 应用日志目录文件
     */
    public static String APP_LOG_PATH = ROOT + "log/";

	/** 
	 * 日志文件路径 
	 */
    public static String LOGFILE = APP_LOG_PATH + "log.txt";
}
