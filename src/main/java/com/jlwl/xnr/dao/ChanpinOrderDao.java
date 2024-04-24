package com.jlwl.xnr.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.xnr.entity.ChanpinOrderEntity;
import com.jlwl.xnr.entity.view.ChanpinOrderView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 农产品订单 Dao 接口
 *
 * @author 
 */
@Mapper
public interface ChanpinOrderDao extends BaseMapper<ChanpinOrderEntity> {

   List<ChanpinOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
