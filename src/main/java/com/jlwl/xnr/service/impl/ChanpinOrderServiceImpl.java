package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.ChanpinOrderDao;
import com.jlwl.xnr.entity.ChanpinOrderEntity;
import com.jlwl.xnr.entity.view.ChanpinOrderView;
import com.jlwl.xnr.service.ChanpinOrderService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 农产品订单 服务实现类
 */
@Service("chanpinOrderService")
@Transactional
public class ChanpinOrderServiceImpl extends ServiceImpl<ChanpinOrderDao, ChanpinOrderEntity> implements ChanpinOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ChanpinOrderView> page =new Query<ChanpinOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
