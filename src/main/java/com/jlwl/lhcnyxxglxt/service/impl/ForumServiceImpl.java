package com.jlwl.lhcnyxxglxt.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.lhcnyxxglxt.dao.ForumDao;
import com.jlwl.lhcnyxxglxt.entity.ForumEntity;
import com.jlwl.lhcnyxxglxt.entity.view.ForumView;
import com.jlwl.lhcnyxxglxt.service.ForumService;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.Query;
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
