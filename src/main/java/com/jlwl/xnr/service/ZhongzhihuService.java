package com.jlwl.xnr.service;

import com.baomidou.mybatisplus.service.IService;
import com.jlwl.xnr.entity.ZhongzhihuEntity;
import com.jlwl.xnr.utils.PageUtils;

import java.util.Map;

/**
 * 种植户 服务类
 */
public interface ZhongzhihuService extends IService<ZhongzhihuEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}