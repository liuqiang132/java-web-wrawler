package com.liuqiang.jd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.jd.entity.JdItem;
import com.liuqiang.jd.mapper.JdMapper;
import com.liuqiang.jd.service.JdService;
import org.springframework.stereotype.Service;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 京东商城业务类
 * @date 2024/2/14 13:19
 */
@Service
public class JdServiceImpl extends ServiceImpl<JdMapper, JdItem> implements JdService {
}
