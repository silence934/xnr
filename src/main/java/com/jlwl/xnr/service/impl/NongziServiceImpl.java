package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.NongziDao;
import com.jlwl.xnr.entity.NongziEntity;
import com.jlwl.xnr.entity.view.NongziView;
import com.jlwl.xnr.service.NongziService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 农资 服务实现类
 */
@Service("nongziService")
@Transactional
public class NongziServiceImpl extends ServiceImpl<NongziDao, NongziEntity> implements NongziService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<NongziView> page =new Query<NongziView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
