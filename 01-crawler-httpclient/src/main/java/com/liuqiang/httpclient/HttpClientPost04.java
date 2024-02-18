package com.liuqiang.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: httpClient-post请求
 * @date 2024/2/13 21:26
 */
public class HttpClientPost04 {
    public static void main(String[] args) throws Exception{
        /**
         * 存在问题:
         *  在使用httpClient发起post请求时，出现返回结果为301时经查阅资料(301 Moved Permanently 永久跳转的意思)
         *  是因为httpClient版本在4.0以上，此时创建httpClient对象的方式就变为:
         *  CloseableHttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
         */
        CloseableHttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        //1.创建httpClient对象以及HttpPost对象并发起请求
        CloseableHttpResponse response = httpClient.execute(new HttpPost("http://www.itcast.cn"));
        //2.处理响应结果
        if (response.getStatusLine().getStatusCode()==200){
            String content = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(content.length());
        }

        /**
         * response:
         *
         * <li><a href="/news/20240119/18311474161.shtml" target="_blank" title="传智教育与华为签署HarmonyOS合作协议，共同为企业助培鸿蒙人才！">传智教育与华为签署HarmonyOS合作协议，共同为企业助培鸿蒙人才！</a></li>
         * <li><a href="/news/20240116/10283754571.shtml" target="_blank" title="传智教育成为阿里云授权培训认证合作伙伴，相关认证课程同步推出">传智教育成为阿里云授权培训认证合作伙伴，相关认证课程同步推出</a></li>
         * <li><a href="/news/20231219/16583389096.shtml" target="_blank" title="黑马全网首发！鸿蒙应用开发学习路线图标准版！">黑马全网首发！鸿蒙应用开发学习路线图标准版！</a></li>
         * <li><a href="/news/20231207/14532273453.shtml" target="_blank" title="传智教育与华为开发者联盟、天津经开区人社局达成鸿蒙生态人才共建合作">传智教育与华为开发者联盟、天津经开区人社局达成鸿蒙生态人才共建合作</a></li>
         * <li><a href="/news/20240130/15493641493.shtml" target="_blank" title="160+所高校600+位教师参与，开启新的十年！2024年全国高校IT骨干教师寒假研修班圆满闭幕">160+所高校600+位教师参与，开启新的十年！2024年全国高校IT骨干教师寒假研修班圆满闭幕</a></li>
         * <li><a href="/news/20231113/18203280716.shtml" target="_blank" title="传智教育入选全国鸿蒙端云智能行业产教融合共同体常务理事单位">传智教育入选全国鸿蒙端云智能行业产教融合共同体常务理事单位</a></li>
         * <li><a href="/news/20231110/13564026042.shtml" target="_blank" title="传智教育与腾讯云达成课程合作，携手培养AI应用型数字化人才">传智教育与腾讯云达成课程合作，携手培养AI应用型数字化人才</a></li>
         * <li><a href="/news/20230111/14014568928.shtml" target="_blank" title="关于申办“大同数据科技职业学院”列入《山西省“十四五” 高校设置规划》的公告">关于申办&ldquo;大同数据科技职业学院&rdquo;列入《山西省&ldquo;十四五&rdquo; 高校设置规划》的公告</a></li>
         */

    }
}
