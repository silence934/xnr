package com.jlwl.lhcnyxxglxt.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.lhcnyxxglxt.entity.ChanpinEntity;
import com.jlwl.lhcnyxxglxt.entity.view.ChanpinView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 农产品 Dao 接口
 *
 * @author 
 */
@Mapper
public interface ChanpinDao extends BaseMapper<ChanpinEntity> {

   List<ChanpinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
