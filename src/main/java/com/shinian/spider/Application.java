package com.shinian.spider;

import java.util.List;

import com.shinian.spider.poster.Iposter;
import com.shinian.spider.poster.impl.BiliBiliPoster;

/**
 * 
 * @ClassName: Application
 * @Description: 这个程序负责启动
 * @author shinian
 * @date 2017年7月7日 下午11:09:50
 * 
 */
public class Application {
	// 想写一个简单的网(zhua)络(qu)爬(shu)虫(ju)Demo
	// 那么先来理清一下逻辑和要干的事情
	// 1:java 基本上百分之90的工作都是在和Web打交道,那么应该都知道WEB通信的基础就是
	// 我给你请求 , 你还我响应,无论这个响应是404,还是500(都应该考虑到)
	// 2:确认你要请求的网站,和你要获取什么内容
	// 3:处理结果

	public static void main(String[] args) throws Exception {
		Iposter poster = new BiliBiliPoster("http://live.bilibili.com/15044");// 一个网站连接
		// 发送请求 获得数据
		List<String> list = poster.accessToNetworkResources();
		// 那我们就来拔下来这个网站的所有图片地址
		// 处理数据 传入一个集合 和一个正则 然后把符合条件的全部输出到指定文件
		for (String string : list) {
			System.out.println(string);
		}
	}

}
