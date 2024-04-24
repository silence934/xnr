package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.GonggaoDao;
import com.jlwl.xnr.entity.GonggaoEntity;
import com.jlwl.xnr.entity.view.GonggaoView;
import com.jlwl.xnr.service.GonggaoService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 公告 服务实现类
 */
@Service("gonggaoService")
@Transactional
public class GonggaoServiceImpl extends ServiceImpl<GonggaoDao, GonggaoEntity> implements GonggaoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<GonggaoView> page =new Query<GonggaoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
