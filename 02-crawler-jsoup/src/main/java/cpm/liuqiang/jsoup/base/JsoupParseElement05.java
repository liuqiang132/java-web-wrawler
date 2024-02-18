package cpm.liuqiang.jsoup.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 元素中获取数据
 * @date 2024/2/14 0:30
 */
public class JsoupParseElement05 {
    public static void main(String[] args) throws Exception {
        /**
         * 元素中获取数据:
         *  1.从元素中获取id
         *  2.从元素中获取className
         *  3.从元素中及其属性的值attr
         *  4.从元素中获取所有属性attribute
         *  5.从元素中获取文本内容text
         */

        Document document = Jsoup.parse(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\02-crawler-jsoup\\src\\main\\resources\\File.html"), "utf-8");
        //1.从元素中获取id
        Element cityList = document.getElementById("city_list");
        System.out.println("id:"+cityList.id());
        //2.从元素中获取className
        Elements classElement = document.getElementsByClass("cur");
        for (Element element : classElement) {
            System.out.println("className:"+element.className());
        }
        //3.从元素中及其属性的值attr
        Element elementById = document.getElementById("id");
        String id = elementById.attr("id");
        System.out.println("获取属性的值:"+id);


        //4.从元素中获取所有属性attribute
        Attributes attributes = document.getElementById("id").attributes();
        System.out.println(attributes.toString());


        //5.从元素中获取文本内容text
        String text = document.getElementsByTag("li").text();
        System.out.println("文本内容为"+text);


    }
}
