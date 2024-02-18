package com.liuqiang.jd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.jd.entity.JdItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: jd商城接口
 * @date 2024/2/14 13:03
 */
@Mapper
public interface JdMapper extends BaseMapper<JdItem> {
}
