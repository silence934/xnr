package com.jlwl.lhcnyxxglxt.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.lhcnyxxglxt.entity.NongziOrderEntity;
import com.jlwl.lhcnyxxglxt.entity.view.NongziOrderView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 农资订单 Dao 接口
 *
 * @author 
 */
@Mapper
public interface NongziOrderDao extends BaseMapper<NongziOrderEntity> {

   List<NongziOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
