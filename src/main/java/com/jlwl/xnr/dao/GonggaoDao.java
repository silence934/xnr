package com.jlwl.xnr.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.xnr.entity.GonggaoEntity;
import com.jlwl.xnr.entity.view.GonggaoView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 公告 Dao 接口
 *
 * @author 
 */
@Mapper
public interface GonggaoDao extends BaseMapper<GonggaoEntity> {

   List<GonggaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
