package cpm.liuqiang.jsoup.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: jsoup解析文件文本
 * @date 2024/2/13 23:46
 */
public class JsoupParseFile02 {
    public static void main(String[] args) throws Exception{

        //获取dom对象
        Document document = Jsoup.parse(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\02-crawler-jsoup\\src\\main\\resources\\File.html"),"utf-8");
        //解析页面
        String title = document.getElementsByTag("title").text();
        System.out.println(title);


    }
}
