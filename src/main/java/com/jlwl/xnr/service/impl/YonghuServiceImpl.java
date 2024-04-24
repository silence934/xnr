package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.YonghuDao;
import com.jlwl.xnr.entity.YonghuEntity;
import com.jlwl.xnr.entity.view.YonghuView;
import com.jlwl.xnr.service.YonghuService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 用户 服务实现类
 */
@Service("yonghuService")
@Transactional
public class YonghuServiceImpl extends ServiceImpl<YonghuDao, YonghuEntity> implements YonghuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<YonghuView> page =new Query<YonghuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
