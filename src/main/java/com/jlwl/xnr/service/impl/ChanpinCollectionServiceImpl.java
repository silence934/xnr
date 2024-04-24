package com.jlwl.xnr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.xnr.dao.ChanpinCollectionDao;
import com.jlwl.xnr.entity.ChanpinCollectionEntity;
import com.jlwl.xnr.entity.view.ChanpinCollectionView;
import com.jlwl.xnr.service.ChanpinCollectionService;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 农产品收藏 服务实现类
 */
@Service("chanpinCollectionService")
@Transactional
public class ChanpinCollectionServiceImpl extends ServiceImpl<ChanpinCollectionDao, ChanpinCollectionEntity> implements ChanpinCollectionService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ChanpinCollectionView> page =new Query<ChanpinCollectionView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
