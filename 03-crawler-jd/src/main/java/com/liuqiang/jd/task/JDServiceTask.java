package com.liuqiang.jd.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liuqiang.jd.entity.JdItem;
import com.liuqiang.jd.service.JdService;
import com.liuqiang.jd.utils.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 定时任务抓取京东商城手机数据
 * @date 2024/2/14 13:02
 */
@Component
public class JDServiceTask {
    public static final String JD_URL = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&wq=%E6%89%8B%E6%9C%BA&pvid=4bd98ad9c31a43c29c3621f6362c797e";

    @Autowired
    private JdService jdService;
    @Autowired
    private HttpClientUtils httpClientUtils;


    @Scheduled(fixedDelay = 10*1000)
    public void jdTask() throws Exception {
            String html = httpClientUtils.doGetHTML(JD_URL);
            //解析页面,获取数据并存储
            parse(html);
        System.out.println("页面数据抓取完成！！！！！");

    }

    /**
     * //解析页面,获取数据并存储
     * @param html 页面
     */
    public void parse(String html) throws Exception {
        //设置Cookie
        Map<String,String> map = new HashMap<>();
        map.put("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC310118B00BB2D86BF13138562604DF02FDB998D78DB63BFB283868E2D17D5543E6C7AA0B084CE9C75E9A388" +
                "714CB7EFB56A57F37A3428D6813617AC5F85987B1D8645E099ECE831C57510C6E8049F12C426C4EE81F287A08E7C4D20A10EE8A0916E7E3D4742A71" +
                "092ED2DC65BF1D76B3FEC6D00F3C91DC98896ABA8D0407AAF8BA29300BAF");
        Document Jd_document = Jsoup.connect(JD_URL).cookies(map).get();
        //获取spu
        Elements spuElements = Jd_document.select("div#J_goodsList > ul > li");
        if (spuElements.size()>0){
            for (Element spuElement : spuElements) {
                Long spu = Long.parseLong(spuElement.attr("data-spu"));
                //获取sku
                Elements skuElements = spuElement.select("li.ps-item");
                for (Element skuElement : skuElements) {
                    Long sku = Long.parseLong(skuElement.select("[data-sku]").attr("data-sku"));
                    //根据sku查询商品
                    List<JdItem> jdItemList = jdService.list(new LambdaQueryWrapper<JdItem>().eq(JdItem::getSku, sku));
                    if (jdItemList.size()>0){
                        throw  new Exception("你的数据库已经存在该商品！！！！");
                    }
                    //设置商品sku
                    JdItem jdItem = new JdItem();
                    jdItem.setSku(sku);
                    jdItem.setSpu(spu);
                    //设置商品详情url
                    jdItem.setUrl("https://item.jd.com/"+sku+".html");
                    //设置商品图片
                    String picUrl = "http://"+skuElement.select("img[data-sku]").first().attr("src");
                    String replace = picUrl.replace("/n9/", "/n1/");
                    jdItem.setUrl(httpClientUtils.doGetImage(replace));
                    //设置商品价格

                    //设置商品标题

                    //设置创建时间
                    jdItem.setCreate_time(new Date());
                    //设置更新时间
                    jdItem.setUpdate_time(jdItem.getCreate_time());

                    //存储数据到数据库
                    jdService.save(jdItem);
                }
            }

        }


    }

}
