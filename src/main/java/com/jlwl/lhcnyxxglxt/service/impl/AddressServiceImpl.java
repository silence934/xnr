package com.jlwl.lhcnyxxglxt.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.lhcnyxxglxt.dao.AddressDao;
import com.jlwl.lhcnyxxglxt.entity.AddressEntity;
import com.jlwl.lhcnyxxglxt.entity.view.AddressView;
import com.jlwl.lhcnyxxglxt.service.AddressService;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 收货地址 服务实现类
 */
@Service("addressService")
@Transactional
public class AddressServiceImpl extends ServiceImpl<AddressDao, AddressEntity> implements AddressService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<AddressView> page =new Query<AddressView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
