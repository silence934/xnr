package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.NongziOrderDao;
import com.jlwl.xnr.entity.NongziOrderEntity;
import com.jlwl.xnr.entity.view.NongziOrderView;
import com.jlwl.xnr.service.NongziOrderService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 农资订单 服务实现类
 */
@Service("nongziOrderService")
@Transactional
public class NongziOrderServiceImpl extends ServiceImpl<NongziOrderDao, NongziOrderEntity> implements NongziOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<NongziOrderView> page =new Query<NongziOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
