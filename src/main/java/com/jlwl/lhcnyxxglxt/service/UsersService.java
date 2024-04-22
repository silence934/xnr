
package com.jlwl.lhcnyxxglxt.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.jlwl.lhcnyxxglxt.entity.UsersEntity;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;

import java.util.List;
import java.util.Map;


/**
 * 系统用户
 * @author yangliyuan
 * @date 2019年10月10日 上午9:18:20
 */
public interface UsersService extends IService<UsersEntity> {
 	PageUtils queryPage(Map<String, Object> params);
    
   	List<UsersEntity> selectListView(Wrapper<UsersEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<UsersEntity> wrapper);
	   	
}
