package com.shinian.spider.poster.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.shinian.spider.poster.Iposter;
import com.shinian.spider.utils.WebUtils;

/**
 * 
 * @ClassName: BiliBiliPoster
 * @Description: 访问BiliBili的直播间 获得各种信息
 * @author shinian
 * @date 2017年7月7日 下午11:20:33
 * 
 */
public class BiliBiliPoster implements Iposter {
	private String url;

	public BiliBiliPoster(String url) {
		this.url = url;
	}

	@Override
	public List<String> accessToNetworkResources() throws Exception {
		List<String> list = new ArrayList<>();
		// 可以对这个连接 进行一系列操作
		InputStream in = WebUtils.getInputStreamByURL(url);
		BufferedReader bf = new BufferedReader(new InputStreamReader(in));
		// 然后获得流 返回字符串
		String line = null;
		while ((line = bf.readLine()) != null) {
			list.add(line);
		}
		return list;
	}

}
