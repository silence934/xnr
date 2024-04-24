package com.jlwl.xnr.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.xnr.entity.ZhongzhihuEntity;
import com.jlwl.xnr.entity.view.ZhongzhihuView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 种植户 Dao 接口
 *
 * @author 
 */
@Mapper
public interface ZhongzhihuDao extends BaseMapper<ZhongzhihuEntity> {

   List<ZhongzhihuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
