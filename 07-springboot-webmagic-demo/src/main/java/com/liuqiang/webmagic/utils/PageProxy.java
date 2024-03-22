package com.liuqiang.webmagic.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.ProxyProvider;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: webMagic的ProxyProvider
 * @date 2024/3/4 20:03
 */
public class PageProxy implements ProxyProvider {

    /**
     * 配置代理服务器
     */
    public static final Logger logger = LoggerFactory.getLogger(PageProxy.class);
    @Override
    public void returnProxy(Proxy proxy, Page page, Task task) {
        String host = proxy.getHost();
        int port = proxy.getPort();
        String username = proxy.getUsername();
        String password = proxy.getPassword();
        System.out.println(host+"--->"+port+"---->"+username+"---->"+password);
        logger.info("===========================info============================");
        logger.info("===========================info============================");
        logger.info("===========================info============================");

    }
    @Override
    public Proxy getProxy(Task task) {
        return null;
    }
}
