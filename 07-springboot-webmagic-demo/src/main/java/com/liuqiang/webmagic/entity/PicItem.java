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
@TableName("picitem")
public class PicItem implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("picName")
    private String picName;

    @TableField("picUrl")
    private String picUrl;

    @TableField("createTime")
    private Date createTime;

    @TableField("updateTime")
    private Date updateTime;


}
