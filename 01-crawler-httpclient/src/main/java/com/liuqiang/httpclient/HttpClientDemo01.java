package com.liuqiang.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: httpclient的使用
 * @date 2024/2/12 11:50
 */
public class HttpClientDemo01 {
    public static void main(String[] args) throws Exception {

        /**
         * 1.打开浏览器，
         * 2.输入网址
         * 3.发起请求
         * 4.相应数据
         */
        CloseableHttpResponse response = HttpClients.createDefault().execute(new HttpGet("http://www.itcast.com"));
        //响应
        if (response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();

            String responses = EntityUtils.toString(entity, "utf-8");

            System.out.println(responses);
        }

        /**
         * 响应的数据:
         * 	<title>传智教育【官网】-好口碑IT职业教育,好口碑IT培训机构，一样的教育，不一样的品质</title>
         * <meta content="传智教育,传智播客,IT培训,IT培训机构,IT培训课程,IT培训学校,Java培训,人工智能培训,Python培训,大数据培训,前端开发培训,web前端培训,软件测试培训" name="keywords" />
         * <meta content="传智教育（“传智播客”全新升级为“传智教育”）专注IT培训，开设多种IT培训课程，提供java培训、前端开发培训、鸿蒙开发培训、大数据培训、人工智能培训、python培训、web前端培训、软件测试培训、ui设计培训、移动开发培训、新媒体运营培训、产品经理培训等IT培训服务，是好口碑的IT培训机构。" name="description" />
         * <meta content="http://www.itcast.cn/images/logo2020.jpg" property="og:image" />
         */


    }
}
