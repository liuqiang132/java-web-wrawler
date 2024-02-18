package com.liuqiang.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: httpClient连接池管理器的使用
 * @date 2024/2/13 22:27
 */
public class HttpClientPoolManger06 {
    public static void main(String[] args) throws Exception{

        //创建httpclient管理器对象
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //配置httpclient管理器
        cm.setDefaultMaxPerRoute(10);
        cm.setMaxTotal(100);
        //使用httpclient管理器对象发起请求
        doGet(cm);
        //doGet(cm);

    }

    private static void doGet(PoolingHttpClientConnectionManager cm) throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        CloseableHttpResponse response = httpClient.execute(new HttpGet("http://www.itcast.cn"));
        if (response.getStatusLine().getStatusCode()==200){
            String content = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(content);
        }

    }
}
