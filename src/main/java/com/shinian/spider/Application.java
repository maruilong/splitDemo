package com.shinian.spider;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    // 2:确认你要请求的网站,和你要获取什么内容 我想爬取所有的图片
    // 3:处理结果

    public static void main(String[] args) throws Exception {
        Iposter poster = new BiliBiliPoster("http://www.baidu.com");// 一个网站连接
        // 发送请求 获得数据
        List<String> list = poster.accessToNetworkResources();
        // 那我们就来拔下来这个网站的所有图片地址
        // 处理数据 传入一个集合 和一个正则 然后把符合条件的全部输出到指定文件
        // 页面上所有的img标签 <img(.*?)(src)=\"(?!.*?logo).*>
        // 页面上所有的a标签 <a[^>]+?href=["']?([^"']+)["']?[^>]*>([^<]+)</a>
        Pattern pattern = Pattern
                .compile("<a[^>]+?href=[\"']?([^\"']+)[\"']?[^>]*>([^<]+)</a>");
        for (String string : list) {
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                System.out.println(string);
            }
        }
    }

}
