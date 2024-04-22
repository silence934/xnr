package com.jlwl.lhcnyxxglxt.service;

import com.baomidou.mybatisplus.service.IService;
import com.jlwl.lhcnyxxglxt.entity.CartEntity;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;

import java.util.Map;

/**
 * 购物车 服务类
 */
public interface CartService extends IService<CartEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}