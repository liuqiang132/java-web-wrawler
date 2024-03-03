package com.liuqiang.webmagic.pipeline;

import com.liuqiang.webmagic.entity.PicItem;
import com.liuqiang.webmagic.service.PicItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: TODO
 * @date 2024/3/3 13:48
 */
@Component
public class SaveImgePipeline implements Pipeline {
    @Autowired
    private PicItemService picItemService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String[] meImges = resultItems.get("meImg").toString().split(",");
        String[] meImgName = resultItems.get("meImgName").toString().split(",");
        PicItem picItem = new PicItem();
        picItem.setId(UUID.randomUUID().toString().split("-")[0]);
        for (String s : meImgName) {
            for (String meImge : meImges) {
                picItem.setPicName(s.replace("[","").replace("]",""));
                String newMeiImg ="https://pic.netbian.com"+meImge.replace(" [/","/").replace("]","");
                picItem.setPicUrl(newMeiImg);
                picItem.setCreateTime(new Date());
                picItem.setUpdateTime(picItem.getCreateTime());
                List<String> meiImgeList = new ArrayList<>(Collections.singletonList(newMeiImg));
                if (!CollectionUtils.isEmpty(meiImgeList)){
                    meiImgeList.forEach(this::saveImge);
                }
            }
        }
        picItemService.save(picItem);




    }
    private void saveImge(String url) {
        try {
            String replace = url.replace("]", "");
            InputStream inputStream = new URL(replace).openConnection().getInputStream();
            Files.copy(inputStream, Paths.get("https://pic.netbian.com"+"C:\\Users\\liuqiang132\\Desktop\\tupian\\"+System.currentTimeMillis()+".jpg"));
        } catch (IOException e) {
        }
    }
}
