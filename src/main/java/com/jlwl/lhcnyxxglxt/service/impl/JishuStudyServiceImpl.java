package com.jlwl.lhcnyxxglxt.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jlwl.lhcnyxxglxt.dao.JishuDao;
import com.jlwl.lhcnyxxglxt.dao.JishuStudyDao;
import com.jlwl.lhcnyxxglxt.entity.JishuEntity;
import com.jlwl.lhcnyxxglxt.entity.JishuStudyEntity;
import com.jlwl.lhcnyxxglxt.entity.view.JishuView;
import com.jlwl.lhcnyxxglxt.service.JishuService;
import com.jlwl.lhcnyxxglxt.service.JishuStudyService;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 农业技术 服务实现类
 */
@Service
public class JishuStudyServiceImpl extends ServiceImpl<JishuStudyDao, JishuStudyEntity> implements JishuStudyService {

}
