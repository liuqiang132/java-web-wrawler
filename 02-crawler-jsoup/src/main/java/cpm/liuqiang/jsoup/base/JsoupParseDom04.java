package cpm.liuqiang.jsoup.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 使用dom的方式遍历文档
 * @date 2024/2/14 0:10
 */
public class JsoupParseDom04 {
    public static void main(String[] args) throws Exception{
        /**
         * 元素的获取:
         *   1.根据id查询元素:getElementById
         *   2.根据标签获取元素: getElementByTag
         *   3.根据class获取元素: getElementByClass
         *   4.根据属性获取元素： getElementAttribute
         *   5.根据属性键值对获取元素: getElementsByAttributeValue
         */
        Document document = Jsoup.parse(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\02-crawler-jsoup\\src\\main\\resources\\File.html"), "utf-8");
        //1.根据id查询元素:getElementById
        String list = document.getElementById("city_list").text();
        System.out.println("获取到的id:"+list);
        //2.根据标签获取元素: getElementByTag
        String title = document.getElementsByTag("title").text();
        System.out.println("获取到的标题:"+title);
        //3.根据class获取元素: getElementByClass
        String text = document.getElementsByClass("cur").text();
        System.out.println("获取的class元素:"+text);
        //4.根据属性获取元素： getElementAttribute
        String titles = document.getElementsByAttribute("abc").text();
        System.out.println("获取到的abc的元素:"+titles);
        //根据属性键值对获取元素: getElementsByAttributeValue
        String href = document.getElementsByAttributeValue("href", "/news/20240119/18311474161.shtml").text();
        System.out.println(href);


    }
}
