package com.jlwl.xnr.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.xnr.entity.AddressEntity;
import com.jlwl.xnr.entity.view.AddressView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 收货地址 Dao 接口
 *
 * @author 
 */
@Mapper
public interface AddressDao extends BaseMapper<AddressEntity> {

   List<AddressView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
