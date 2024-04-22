package com.jlwl.lhcnyxxglxt.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.lhcnyxxglxt.entity.ChanpinCollectionEntity;
import com.jlwl.lhcnyxxglxt.entity.view.ChanpinCollectionView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 农产品收藏 Dao 接口
 *
 * @author 
 */
@Mapper
public interface ChanpinCollectionDao extends BaseMapper<ChanpinCollectionEntity> {

   List<ChanpinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
