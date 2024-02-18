package cpm.liuqiang.jsoup.selector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: Selector选择器的组合使用
 * @date 2024/2/14 11:29
 */
public class JsoupSelector02 {
    public static void main(String[] args) throws Exception{

        //获取dom对象
        Document document = Jsoup.parse(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\02-crawler-jsoup\\src\\main\\resources\\File.html"), "utf-8");

        /**
         * 选择器的组合使用:
         *  1. el#id: 元素+ID 比如: h3#city_bj
         *  2. el.class: 元素+class 比如: li.class_a
         *  3. el[attr]: 元素+属性名 比如: span[abc]
         *  4.  任意组合:  比如: span[abc].s_name
         *  5.  ancestor child: 查找某个元素下子元素, 比如: .city_con li 查找"city_con"下的所有li
         *  6.parent > child : 查找某个父元素下的直接子元素 比如: .city_con>ul>li 查找city_con第一级(直接子元素)的ul，再找所有ul下的第一级li
         *  7.parent > * : 查找某个父元素下的所有子元素
         */
        //1. el#id: 元素+ID 比如: h3#city_bj
        String text = document.select("p#city_bj").first().text();
        System.out.println(text);
        //2. el.class: 元素+class 比如: li.class_a
        String text1 = document.select("div.city").first().text();
        System.out.println(text1);
        //3. el[attr]: 元素+属性名 比如: span[abc]
        String text2 = document.select("span[class]").first().text();
        System.out.println(text2);
        //4.  任意组合:  比如: span[abc].s_name
        Elements elements = document.select("div.inner >a");
        for (Element element : elements) {
            System.out.println(element.text());
        }
        /**
         * JavaEE
         * 鸿蒙应用开发
         * HTML&JS+前端
         * Python+大数据开发
         * 人工智能开发
         * 电商视觉设计
         * 软件测试
         * 新媒体+短视频 直播运营
         * 产品经理
         * 集成电路应用开发 (含嵌入式)
         * C/C++
         * 狂野架构师
         * IP短视频 带货训练营
         */
        //5.  ancestor child: 查找某个元素下子元素, 比如: .city_con li 查找"city_con"下的所有li
        Elements select = document.select("ul.cur li");
        for (Element element : select) {
            System.out.println(element.text());
        }
        /**
         * 传智教育与华为签署HarmonyOS合作协议，共同为企业助培鸿蒙人才！
         * 传智教育成为阿里云授权培训认证合作伙伴，相关认证课程同步推出
         * 黑马全网首发！鸿蒙应用开发学习路线图标准版！
         * 传智教育与华为开发者联盟、天津经开区人社局达成鸿蒙生态人才共建合作
         * 160+所高校600+位教师参与，开启新的十年！2024年全国高校IT骨干教师寒假研修班圆满闭幕
         * 传智教育入选全国鸿蒙端云智能行业产教融合共同体常务理事单位
         * 传智教育与腾讯云达成课程合作，携手培养AI应用型数字化人才
         * 关于申办“大同数据科技职业学院”列入《山西省“十四五” 高校设置规划》的公告
         * 人已学0基础快速入门
         * 人已学鸿蒙开发轻松学
         * 人已学快速进阶
         * 人已学自学不走弯路
         * 人已学轻松入门
         * 人已学轻松玩转软硬件
         * 人已学进阶高级设计师
         * 人已学这么入行更轻松
         * 人已学玩儿转新媒体
         * 人已学入门-实战-就业
         */
        //6.parent > child : 查找某个父元素下的直接子元素 比如: .city_con>ul>li 查找city_con第一级(直接子元素)的ul，再找所有ul下的第一级li
        Elements select1 = document.select(".inner> a");
        for (Element element : select1) {
            System.out.println(element.text());
        }
        /**
         * JavaEE
         * 鸿蒙应用开发
         * HTML&JS+前端
         * Python+大数据开发
         * 人工智能开发
         * 电商视觉设计
         * 软件测试
         * 新媒体+短视频 直播运营
         * 产品经理
         * 集成电路应用开发 (含嵌入式)
         * C/C++
         * 狂野架构师
         * IP短视频 带货训练营
         */
        //7.parent > * : 查找某个父元素下的所有子元素
        Elements select2 = document.select(".list_main> *");
        for (Element element : select2) {
            System.out.println(element.text());
        }
        /**
         * 传智教育与华为签署HarmonyOS合作协议，共同为企业助培鸿蒙人才！
         * 传智教育成为阿里云授权培训认证合作伙伴，相关认证课程同步推出 黑马全网首发！鸿蒙应用开发学习路线图标准版！
         * 传智教育与华为开发者联盟、天津经开区人社局达成鸿蒙生态人才共建合作 160+所高校600+位教师参与，开启新的十年！2024年全国高校IT骨干教师寒假研修班圆满闭幕
         * 传智教育入选全国鸿蒙端云智能行业产教融合共同体常务理事单位 传智教育与腾讯云达成课程合作，携手培养AI应用型数字化人才 关于申办“大同数据科技职业学院”列入《山西省“十四五” 高校设置规划》的公告
         * 大同市委副书记、市长张强赴数科学院项目现场办公 热烈庆祝：大同数据科技职业学院建设项目全面封顶！ 大同市市委副书记、市长张强赴大同数据科技职业学院项目现场办公 全力奋战30天！大同数据科技职业学院将于9月30日前实现全面封顶 山西省教育厅副厅长李金碧一行莅临数科学院建设项目参观指导 大同市人大常委莅临大同数据科技职业学院调研指导 大同市云州区区委书记宁文鑫及历届区委书记一行莅临大同数据科技职业学院参观指导 大同市副市长孟维君赴大同数据科技职业学院指导建设工作
         * 微服务架构是什么？
         * 有哪些优点和不足？
         * Java培训讨论：Java难学吗？
         * 数据分析师的职业前景怎么样？需要掌握哪些技能？
         * MapReduce性能调优方法有哪些？
         * 产品的可行性分析要从哪几个方面入手？
         * 鸿蒙开发培训哪里好？
         * MySQL数据库基本操作—— DQL查询
         * JavaScript中形参和实参指的是什么？
         * FFA技术盛宴！传智黑马专家带来深度分享！
         * 黑马研究院权威发布：Java学科最新家政服务项目 电商设计必备！打破二维束缚，开启你的三维创新之门
         * 黑马研究院权威发布：Three.js，前端工程师的3D开发神器
         * 黑马研究院：新推工作流组件课程，据说99%的程序员都需要 设计师必备利器！AIGC，电商领域的高效引领者 一文搞定多端开发，附三大企业实战项目！
         * 黑马研究院权威发布——AIGC激活未来，引领你的设计学习之旅
         */


    }
}
