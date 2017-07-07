package com.shinian.spider.poster;

import java.util.List;

/**
 * 
 * @ClassName: Iposter
 * @Description: 这是一个发送者的接口,并且获得所有的信息
 * @author shinian
 * @date 2017年7月7日 下午11:16:37
 * 
 */
public interface Iposter {

	/**
	 * 
	 * @Title: accessToNetworkResources
	 * @Description: 通过url 获得流
	 * @param url
	 *            目标网站URL
	 * @return List<String> 返回类型
	 * @throws 网络连接异常
	 *             或者 IO异常
	 */
	public List<String> accessToNetworkResources() throws Exception;

}
