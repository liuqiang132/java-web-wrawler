package com.liuqiang.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 启动类
 * @date 2024/2/14 12:43
 */
@SpringBootApplication
@EnableScheduling //开启定时任务
public class JdSpiderApplication {
    public static void main(String[] args) {

        SpringApplication.run(JdSpiderApplication.class,args);

    }
}
