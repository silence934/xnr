package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.ForumDao;
import com.jlwl.xnr.entity.ForumEntity;
import com.jlwl.xnr.entity.view.ForumView;
import com.jlwl.xnr.service.ForumService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 论坛 服务实现类
 */
@Service("forumService")
@Transactional
public class ForumServiceImpl extends ServiceImpl<ForumDao, ForumEntity> implements ForumService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ForumView> page =new Query<ForumView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        page.setTotal(baseMapper.countListView(params));
        return new PageUtils(page);
    }


}
