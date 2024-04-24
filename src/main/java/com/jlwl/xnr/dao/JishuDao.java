package com.jlwl.xnr.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.xnr.entity.JishuEntity;
import com.jlwl.xnr.entity.view.JishuView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 农业技术 Dao 接口
 *
 * @author 
 */
@Mapper
public interface JishuDao extends BaseMapper<JishuEntity> {

   List<JishuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
