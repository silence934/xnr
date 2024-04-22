package com.jlwl.lhcnyxxglxt.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jlwl.lhcnyxxglxt.entity.GonggaoEntity;
import com.jlwl.lhcnyxxglxt.entity.GonggaoPinglunEntity;
import com.jlwl.lhcnyxxglxt.entity.view.GonggaoView;
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
public interface GonggaoPinglunDao extends BaseMapper<GonggaoPinglunEntity> {


}
