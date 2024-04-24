package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.JishuDao;
import com.jlwl.xnr.entity.JishuEntity;
import com.jlwl.xnr.entity.view.JishuView;
import com.jlwl.xnr.service.JishuService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 农业技术 服务实现类
 */
@Service("jishuService")
@Transactional
public class JishuServiceImpl extends ServiceImpl<JishuDao, JishuEntity> implements JishuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<JishuView> page =new Query<JishuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
