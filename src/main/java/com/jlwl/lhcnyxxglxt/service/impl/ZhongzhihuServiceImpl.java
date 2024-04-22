package com.jlwl.lhcnyxxglxt.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.lhcnyxxglxt.dao.ZhongzhihuDao;
import com.jlwl.lhcnyxxglxt.entity.ZhongzhihuEntity;
import com.jlwl.lhcnyxxglxt.entity.view.ZhongzhihuView;
import com.jlwl.lhcnyxxglxt.service.ZhongzhihuService;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 种植户 服务实现类
 */
@Service("zhongzhihuService")
@Transactional
public class ZhongzhihuServiceImpl extends ServiceImpl<ZhongzhihuDao, ZhongzhihuEntity> implements ZhongzhihuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ZhongzhihuView> page =new Query<ZhongzhihuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
