package cpm.liuqiang.jsoup.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: jsoup获取url
 * @date 2024/2/13 23:39
 */
public class JsoupParseURL01 {
    public static void main(String[] args) throws Exception{
        //获取页面
        Document document = Jsoup.parse(new URL("http://www.itcast.cn"), 100000); //或者 Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        //解析页面
        Elements title = document.getElementsByTag("title");
        System.out.println("解析到的结果:"+title.text());


    }
}
