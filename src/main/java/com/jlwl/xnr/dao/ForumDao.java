package com.jlwl.xnr.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.xnr.entity.ForumEntity;
import com.jlwl.xnr.entity.view.ForumView;
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

   Long countListView(@Param("params")Map<String,Object> params);

}
