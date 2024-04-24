
package com.jlwl.xnr.service;

import com.baomidou.mybatisplus.service.IService;
import com.jlwl.xnr.entity.ConfigEntity;
import com.jlwl.xnr.utils.PageUtils;

import java.util.Map;


/**
 * 系统用户
 * @author yangliyuan
 * @date 2019年10月10日 上午9:18:20
 */
public interface ConfigService extends IService<ConfigEntity> {
	PageUtils queryPage(Map<String, Object> params);
}
