package com.jlwl.xnr.service;

import com.baomidou.mybatisplus.service.IService;
import com.jlwl.xnr.entity.AddressEntity;
import com.jlwl.xnr.utils.PageUtils;

import java.util.Map;

/**
 * 收货地址 服务类
 */
public interface AddressService extends IService<AddressEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}