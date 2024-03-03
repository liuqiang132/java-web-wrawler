package com.liuqiang.webmagic.demo01;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: webMagic的简单使用
 * @date 2024/2/19 13:33
 */

public class WebMagicDemo02 implements PageProcessor {

    private static final String ZHI_HU_URL = "https://pic.netbian.com/4kmeinv/";

    //页面的提取
    @Override
    public void process(Page page) {
        List<String> all = page.getHtml().xpath("//div[@class=slist]/ul/li/a/img/@src").all();
        for (String s : all) {
            System.out.println("https://pic.netbian.com/"+s);
        }

    }

    //设置配置信息
    private final Site site = Site.me().setTimeOut(10000).setRetryTimes(3);
    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {

        //启动程序
        Spider.create(new WebMagicDemo02())
                .addUrl(ZHI_HU_URL)
                .thread(10)
                .run();

    }
}
