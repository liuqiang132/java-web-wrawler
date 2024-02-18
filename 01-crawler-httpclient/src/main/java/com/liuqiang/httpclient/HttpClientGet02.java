package com.liuqiang.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: httpClient-get请求
 * @date 2024/2/13 21:09
 */
public class HttpClientGet02 {
    public static void main(String[] args) throws IOException {
        //1.创建httpClient对象以及HttpGet对象，并发送请求
        CloseableHttpResponse response = HttpClients.createDefault().execute(new HttpGet("http://www.itcast.cn"));
        //处理响应结果
        if (response.getStatusLine().getStatusCode()==200){
            String content = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(content.length());
        }

        /**
         * response:
         * <li><a href="/news/20220329/17575248138.shtml" target="_blank" title="微服务架构的定义及优缺点">微服务架构是什么？有哪些优点和不足？</a></li>
         * <li><a href="/news/20220225/14413718246.shtml" target="_blank" title="Java难学吗？">Java培训讨论：Java难学吗？</a></li>
         * <li><a href="/news/20220318/17003147637.shtml" target="_blank" title="数据分析师职业前景">数据分析师的职业前景怎么样？需要掌握哪些技能？</a></li>
         * <li><a href="/news/20220328/16461039101.shtml" target="_blank" title="MapReduce性能调优方法">MapReduce性能调优方法有哪些？</a></li>
         * <li><a href="/news/20220401/17401078811.shtml" target="_blank" title="产品经理可行性分析">产品的可行性分析要从哪几个方面入手？</a></li>
         * <li><a href="/news/20231129/17234511977.shtml" target="_blank" title="鸿蒙开发培训哪里好？">鸿蒙开发培训哪里好？</a></li>
         * <li><a href="/news/20230303/1458217717.shtml" target="_blank" title="MySQL数据库基本操作—— DQL查询">MySQL数据库基本操作&mdash;&mdash; DQL查询</a></li>
         * <li><a href="/news/20230201/14135638692.shtml" target="_blank" title="JavaScript中形参和实参指的是什么？">JavaScript中形参和实参指的是什么？</a></li>
         */


    }
}
