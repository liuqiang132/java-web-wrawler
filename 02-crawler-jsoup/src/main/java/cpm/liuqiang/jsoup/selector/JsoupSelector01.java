package cpm.liuqiang.jsoup.selector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: Selector选择器的使用
 * @date 2024/2/14 11:29
 */
public class JsoupSelector01 {
    public static void main(String[] args) throws Exception{

        //获取dom对象
        Document document = Jsoup.parse(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\02-crawler-jsoup\\src\\main\\resources\\File.html"), "utf-8");

        /**
         *  1.tagName:通过标签查找元素: 比如: span
         *  2.#id: 通过ID查找元素: 比如: #city_bj
         *  3. .class: 通过class名称查找元素： 比如: .class_a
         *  4. [attribute]: 通过属性值查找元素: 比如： [abc]
         *  5.[attr=value]: 利用属性值来查找元素: 比如: [class=s_name]
         */
        //1.tagName:通过标签查找元素: 比如: span
        String span = document.select("title").first().text();
        System.out.println("通过标签查找到的元素: "+span);
        //2.#id: 通过ID查找元素: 比如: #city_bj
        String id = document.select("#LiuQiang132").first().text();
        System.out.println("通过id查找到的元素:"+id);
        // 3. .class: 通过class名称查找元素： 比如: .class_a
        Elements elements = document.select(".clears");
        System.out.println("通过.class名称查找到的元素:");
        for (Element element : elements) {
            System.out.println(element.text());
        }
        //  4. [attribute]: 通过属性值查找元素: 比如： [abc]
        String attribute = document.select("[id]").first().text();
        System.out.println("通过属性值查找到的元素:"+attribute);
        // 5.[attr=value]: 利用属性值来查找元素: 比如: [class=s_name]
        String attr = document.select("[id=LiuQiang132]").first().text();
        System.out.println("利用属性值来查找元素:"+attr);


    }
}
