package com.jlwl.lhcnyxxglxt.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.lhcnyxxglxt.entity.CartEntity;
import com.jlwl.lhcnyxxglxt.entity.view.CartView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 购物车 Dao 接口
 *
 * @author 
 */
@Mapper
public interface CartDao extends BaseMapper<CartEntity> {

   List<CartView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
