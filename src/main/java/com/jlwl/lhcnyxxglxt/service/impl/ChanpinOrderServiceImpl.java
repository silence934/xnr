package com.jlwl.lhcnyxxglxt.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.lhcnyxxglxt.dao.ChanpinOrderDao;
import com.jlwl.lhcnyxxglxt.entity.ChanpinOrderEntity;
import com.jlwl.lhcnyxxglxt.entity.view.ChanpinOrderView;
import com.jlwl.lhcnyxxglxt.service.ChanpinOrderService;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.Query;
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
