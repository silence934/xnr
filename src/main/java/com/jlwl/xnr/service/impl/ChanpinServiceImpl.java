package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.ChanpinDao;
import com.jlwl.xnr.entity.ChanpinEntity;
import com.jlwl.xnr.entity.view.ChanpinView;
import com.jlwl.xnr.service.ChanpinService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 农产品 服务实现类
 */
@Service("chanpinService")
@Transactional
public class ChanpinServiceImpl extends ServiceImpl<ChanpinDao, ChanpinEntity> implements ChanpinService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ChanpinView> page =new Query<ChanpinView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
