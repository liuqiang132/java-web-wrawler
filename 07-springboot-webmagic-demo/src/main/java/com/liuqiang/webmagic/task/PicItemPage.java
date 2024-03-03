package com.liuqiang.webmagic.task;

import com.liuqiang.webmagic.pipeline.SaveImgePipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: TODO
 * @date 2024/3/3 13:36
 */
@Component
public class PicItemPage implements PageProcessor {

    @Autowired
    private SaveImgePipeline saveImgePipeline;

    public static final String MEI_NV_URL = "https://pic.netbian.com/4kmeinv/";

    private Site site = Site.me().setRetryTimes(3).setTimeOut(10000).setSleepTime(1000);


    @Override
    public void process(Page page) {
      page.putField("meImg",page.getHtml().xpath("//div[@class=slist]/ul/li/a/img/@src").all());
      page.putField("meImgName",page.getHtml().xpath("//div[@class=slist]/ul/li/a/b/text()").all());
      if (page.getResultItems().get("meImg")==null || page.getResultItems().get("meImgName")==null){
          page.setSkip(true);
      }
        //发现连接并添加到队列中去
      page.addTargetRequests(page.getHtml().xpath("//div[@class='page']").links().all());

    }

    @Override
    public Site getSite() {
        return site;
    }

    @Scheduled(initialDelay = 1000,fixedDelay = 1000)
    public void initWebMagicSpider(){
        Spider.create(new PicItemPage())
                .addUrl(MEI_NV_URL)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .thread(20)
                .addPipeline(saveImgePipeline)
                .run();
    }
}
