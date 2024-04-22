package com.jlwl.lhcnyxxglxt.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.lhcnyxxglxt.dao.CartDao;
import com.jlwl.lhcnyxxglxt.entity.CartEntity;
import com.jlwl.lhcnyxxglxt.entity.view.CartView;
import com.jlwl.lhcnyxxglxt.service.CartService;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 购物车 服务实现类
 */
@Service("cartService")
@Transactional
public class CartServiceImpl extends ServiceImpl<CartDao, CartEntity> implements CartService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<CartView> page =new Query<CartView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
