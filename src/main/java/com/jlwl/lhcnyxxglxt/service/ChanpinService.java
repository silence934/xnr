package com.jlwl.lhcnyxxglxt.service;

import com.baomidou.mybatisplus.service.IService;
import com.jlwl.lhcnyxxglxt.entity.ChanpinEntity;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;

import java.util.Map;

/**
 * 农产品 服务类
 */
public interface ChanpinService extends IService<ChanpinEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}