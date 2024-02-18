package com.liuqiang.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: httpClient-get请求
 * @date 2024/2/13 21:09
 */
public class HttpClientParamGet03 {
    public static void main(String[] args) throws Exception {
        //1.设置请求地址: https://yun.itheima.com/search?keys=java
        URIBuilder uriBuilder =  new URIBuilder("https://yun.itheima.com/search");
        //设置参数
        uriBuilder.setParameter("keys","java");

        //2。创建httpClient对象以及HttpGet对象，并发送请求
        CloseableHttpResponse response = HttpClients.createDefault().execute(new HttpGet(uriBuilder.build()));
        //处理响应结果
        if (response.getStatusLine().getStatusCode()==200){
            String content = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(content);
        }


        /**
         * response:
         *
         * <h2>由浅入深了解店铺数据分析及爆款打造</h2>
         * <p class="p1">打造爆款宝贝，爆款可以给店铺引入自然流量，带动全店宝贝销量，提升店铺人气。打造爆款一直是店铺运营的头等大事，那么，卖家如何选择产品打造爆款?淘宝潜力爆款宝贝都有哪些特点? 打造爆款的前提需要确定好爆款...</p>
         */


    }
}
