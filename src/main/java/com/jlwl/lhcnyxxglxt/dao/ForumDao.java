package com.jlwl.lhcnyxxglxt.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.lhcnyxxglxt.entity.ForumEntity;
import com.jlwl.lhcnyxxglxt.entity.view.ForumView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 论坛 Dao 接口
 *
 * @author 
 */
@Mapper
public interface ForumDao extends BaseMapper<ForumEntity> {

   List<ForumView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
