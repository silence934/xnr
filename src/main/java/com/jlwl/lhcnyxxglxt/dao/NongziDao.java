package com.jlwl.lhcnyxxglxt.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.lhcnyxxglxt.entity.NongziEntity;
import com.jlwl.lhcnyxxglxt.entity.view.NongziView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 农资 Dao 接口
 *
 * @author 
 */
@Mapper
public interface NongziDao extends BaseMapper<NongziEntity> {

   List<NongziView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
