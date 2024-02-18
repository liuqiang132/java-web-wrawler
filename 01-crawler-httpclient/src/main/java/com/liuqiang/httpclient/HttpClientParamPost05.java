package com.liuqiang.httpclient;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: httpClient-post带参数的请求
 * @date 2024/2/13 21:26
 */
public class HttpClientParamPost05 {
    public static void main(String[] args) throws Exception{
        /**
         * 存在问题:
         *  在使用httpClient发起post请求时，出现返回结果为301时经查阅资料
         *  是因为httpClient版本在4.0以上，此时创建httpClient对象的方式就变为:
         *  CloseableHttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
         */

        /**
         * 封装携带参数:
         *
         */

        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("keys","java"));
        //创建forentity
        UrlEncodedFormEntity FormEntity = new UrlEncodedFormEntity(list,"utf-8");
        //1.创建httpClient对象以及HttpPost对象并发起请求
        HttpPost httpPost = new HttpPost("https://yun.itheima.com/search");
        httpPost.setEntity(FormEntity);
        CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost);

        //2.处理响应结果
        if (response.getStatusLine().getStatusCode()==200){
            String content = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(content.length());
        }


    }
}
