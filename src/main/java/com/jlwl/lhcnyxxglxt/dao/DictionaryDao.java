package com.jlwl.lhcnyxxglxt.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.lhcnyxxglxt.entity.DictionaryEntity;
import com.jlwl.lhcnyxxglxt.entity.view.DictionaryView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 字典 Dao 接口
 *
 * @author 
 */
@Mapper
public interface DictionaryDao extends BaseMapper<DictionaryEntity> {

   List<DictionaryView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
