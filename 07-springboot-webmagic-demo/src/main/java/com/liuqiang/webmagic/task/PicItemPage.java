package com.liuqiang.webmagic.task;

import com.liuqiang.webmagic.pipeline.SaveImgPipeline;
import com.liuqiang.webmagic.utils.WebURL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import javax.annotation.Resource;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: TODO
 * @date 2024/3/3 13:36
 */
@Component
public class PicItemPage implements PageProcessor {

    @Resource
    private SaveImgPipeline saveImgePipeline;


    @Resource
    private WebURL webURL;

    private final Site site = Site.me().setRetryTimes(3).setTimeOut(10000).setSleepTime(1000);


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
                .addUrl(webURL.MEI_NV_URL)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .thread(20)
                .addPipeline(saveImgePipeline)
                .run();
    }
}
