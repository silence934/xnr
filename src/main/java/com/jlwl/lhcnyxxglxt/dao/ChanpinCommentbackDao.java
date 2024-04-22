package com.jlwl.lhcnyxxglxt.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.lhcnyxxglxt.entity.ChanpinCommentbackEntity;
import com.jlwl.lhcnyxxglxt.entity.view.ChanpinCommentbackView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 农产品评价 Dao 接口
 *
 * @author 
 */
@Mapper
public interface ChanpinCommentbackDao extends BaseMapper<ChanpinCommentbackEntity> {

   List<ChanpinCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
