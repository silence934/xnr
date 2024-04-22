package com.jlwl.lhcnyxxglxt.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.lhcnyxxglxt.dao.NongziOrderDao;
import com.jlwl.lhcnyxxglxt.entity.NongziOrderEntity;
import com.jlwl.lhcnyxxglxt.entity.view.NongziOrderView;
import com.jlwl.lhcnyxxglxt.service.NongziOrderService;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.Query;
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
