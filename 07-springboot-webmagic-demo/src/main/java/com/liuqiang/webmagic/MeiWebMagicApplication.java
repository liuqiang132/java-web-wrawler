package com.liuqiang.webmagic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: TODO
 * @date 2024/3/3 13:26
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.liuqiang.webmagic.mapper")
public class MeiWebMagicApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeiWebMagicApplication.class,args);
    }
}
