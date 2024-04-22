package com.jlwl.lhcnyxxglxt.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.lhcnyxxglxt.dao.GonggaoDao;
import com.jlwl.lhcnyxxglxt.entity.GonggaoEntity;
import com.jlwl.lhcnyxxglxt.entity.view.GonggaoView;
import com.jlwl.lhcnyxxglxt.service.GonggaoService;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.Query;
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
