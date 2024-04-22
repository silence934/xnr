package com.jlwl.lhcnyxxglxt.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.lhcnyxxglxt.dao.ChanpinCollectionDao;
import com.jlwl.lhcnyxxglxt.entity.ChanpinCollectionEntity;
import com.jlwl.lhcnyxxglxt.entity.view.ChanpinCollectionView;
import com.jlwl.lhcnyxxglxt.service.ChanpinCollectionService;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.Query;
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
