package com.jlwl.xnr.service;

import com.baomidou.mybatisplus.service.IService;
import com.jlwl.xnr.entity.YonghuEntity;
import com.jlwl.xnr.utils.PageUtils;

import java.util.Map;

/**
 * 用户 服务类
 */
public interface YonghuService extends IService<YonghuEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}