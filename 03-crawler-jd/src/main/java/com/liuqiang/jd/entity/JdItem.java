package com.liuqiang.jd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 京东商城实体类
 * @date 2024/2/14 13:11
 */
@Data
@TableName("jd_item")
public class JdItem {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("spu")
    private Long spu;
    @TableField("sku")
    private Long sku;

    @TableField("title")
    private String title;

    @TableField("price")
    private Double price;

    @TableField("url")
    private String url;

    @TableField("create_time")
    private Date create_time;

    @TableField("update_time")
    private Date update_time;
}
