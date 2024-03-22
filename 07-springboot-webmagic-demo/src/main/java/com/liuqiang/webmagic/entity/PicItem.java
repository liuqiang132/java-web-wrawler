package com.liuqiang.webmagic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: TODO
 * @date 2024/3/3 13:28
 */
@Data
@TableName("pic_item")
public class PicItem implements Serializable {


    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @TableField("pic_name")
    private String picName;

    @TableField("pic_url")
    private String picUrl;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;


}
