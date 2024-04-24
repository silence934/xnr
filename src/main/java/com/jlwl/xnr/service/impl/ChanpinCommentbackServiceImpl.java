package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.ChanpinCommentbackDao;
import com.jlwl.xnr.entity.ChanpinCommentbackEntity;
import com.jlwl.xnr.entity.view.ChanpinCommentbackView;
import com.jlwl.xnr.service.ChanpinCommentbackService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 农产品评价 服务实现类
 */
@Service("chanpinCommentbackService")
@Transactional
public class ChanpinCommentbackServiceImpl extends ServiceImpl<ChanpinCommentbackDao, ChanpinCommentbackEntity> implements ChanpinCommentbackService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ChanpinCommentbackView> page =new Query<ChanpinCommentbackView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
