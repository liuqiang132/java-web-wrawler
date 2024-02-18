package com.liuqiang.jd.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: httpClient的工具类
 * @date 2024/2/14 13:24
 */
@Component
public class HttpClientUtils {

    private  PoolingHttpClientConnectionManager connectionManager;
    HttpClientUtils(){
        //创建httpClient管理器对象
        connectionManager = new PoolingHttpClientConnectionManager();
        //配置管理器
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(10);
    }

    /**
     * 根据请求地址下载请求页面
     * @param url
     * @return 页面数据
     */
    public String doGetHTML(String url){
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        //创建get请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config());
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200){
                if (response.getEntity()!=null){
                    String content = EntityUtils.toString(response.getEntity(), "utf-8");
                    return content;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    /**
     * 获取商品图片
     * @param url
     * @return 商品图片地址
     */
    public String doGetImage(String url){
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        //创建get请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config());
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200){
                if (response.getEntity()!=null){
                    //下载图片
                    String endImageName = url.substring(url.lastIndexOf("."));
                    //重命名图片
                    String NewImageName = (UUID.randomUUID().toString())+ endImageName;
                    //下载图片
                    OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\03-crawler-jd\\src\\main\\resources\\images"+NewImageName));
                    response.getEntity().writeTo(outputStream);
                    //return "http://"+NewImageName+".jpg";
                    return NewImageName;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    /**
     * 设置请求参数
     * @return
     */
    public RequestConfig config(){
      return   RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectionRequestTimeout(1000)
                .setConnectTimeout(1000)
                .build();
    }
}
