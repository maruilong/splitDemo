package com.shinian.spider.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.shinian.spider.HttpCode;
import com.shinian.spider.exception.ErrorCodeException;

/**
 * 
 * @ClassName: WebUtils
 * @Description: 网络工具类
 * @author shinian
 * @date 2017年7月7日 下午11:23:14
 * 
 */
public class WebUtils {

	private static URL url = null;
	private static URLConnection urlConnection;
	private static HttpURLConnection httpURLConnection;

	/**
	 * 
	 * @Title: getInputStreamByURL
	 * @Description: 根据网络连接 获得流
	 * @param @param webLink
	 * @param @return 设定文件
	 * @return InputStream 返回类型
	 * @throws
	 */
	public static InputStream getInputStreamByURL(String webLink) {
		Integer code = getCode(webLink);
		if (HttpCode.SUCCESS.getValue() == getCode(webLink)) {
			try {
				return httpURLConnection.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new ErrorCodeException(code);
		}
		return null;
	}

	private static Integer getCode(String webLink) {
		try {
			url = new URL(webLink);// 获得连接
			try {
				urlConnection = url.openConnection();
				httpURLConnection = (HttpURLConnection) urlConnection;
				return httpURLConnection.getResponseCode();
			} catch (IOException e) {
				e.printStackTrace(System.out);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	private WebUtils() {
	}
}
