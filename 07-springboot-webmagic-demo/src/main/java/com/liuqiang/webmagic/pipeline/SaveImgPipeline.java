package com.liuqiang.webmagic.pipeline;

import com.liuqiang.webmagic.entity.PicItem;
import com.liuqiang.webmagic.service.PicItemService;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 图片的数据保存功能
 * @date 2024/3/3 13:48
 */
@Component
public class SaveImgPipeline implements Pipeline {
    @Resource
    private PicItemService picItemService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        //获取图片的地址
        List<String> meImg = resultItems.get("meImg");
        //获取图片的名称
        List<String> meImgName = resultItems.get("meImgName");
        for (String meiImgUrl : meImg) {
            String newMeiImgUrl = "https://pic.netbian.com"+meiImgUrl;
            for (String meiImgNames : meImgName) {
                PicItem picItem = PicItem.builder()
                        .id(UUID.randomUUID().toString().split("-")[0])
                        .picName(meiImgNames)
                        .picUrl(newMeiImgUrl)
                        .createTime(new Date())
                        .updateTime(new Date())
                        .build();
                //下载图片并保存
                saveImg(newMeiImgUrl,meiImgNames);
                //保存图片地址及名称到数据库中
                picItemService.save(picItem);

            }
        }
    }
    /**
     * 下载图片并保存
     * @param meiImgUrl 图片地址
     * @param meiImgNames 图片名称
     */
    private void saveImg(String meiImgUrl,String meiImgNames) {
        try {
            InputStream inputStream = new URL(meiImgUrl).openConnection().getInputStream();
            String replaceName = meiImgNames.replace("*", "");
            //判断文件夹是否存在
            if (Files.isDirectory(Paths.get("C:\\Users\\liuqiang132\\Desktop\\tupian"))){
                Files.copy(inputStream, Paths.get("C:\\Users\\liuqiang132\\Desktop\\tupian\\"+replaceName+".jpg"));
            }

        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
