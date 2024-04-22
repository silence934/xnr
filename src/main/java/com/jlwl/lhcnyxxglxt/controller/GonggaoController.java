
package com.jlwl.lhcnyxxglxt.controller;

import com.alibaba.fastjson.*;
import com.alibaba.fastjson.JSONObject;
import com.jlwl.lhcnyxxglxt.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jlwl.lhcnyxxglxt.entity.*;
import com.jlwl.lhcnyxxglxt.entity.view.*;
import com.jlwl.lhcnyxxglxt.service.*;
import com.jlwl.lhcnyxxglxt.service.DictionaryService;
import com.jlwl.lhcnyxxglxt.service.TokenService;
import com.jlwl.lhcnyxxglxt.utils.*;
import com.jlwl.lhcnyxxglxt.utils.PageUtils;
import com.jlwl.lhcnyxxglxt.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 公告
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gonggao")
public class GonggaoController {
    private static final Logger logger = LoggerFactory.getLogger(GonggaoController.class);

    private static final String TABLE_NAME = "gonggao";

    @Autowired
    private GonggaoService gonggaoService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoPinglunService gonggaoPinglunService;
    @Autowired
    private YonghuService yonghuService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("种植户".equals(role))
            params.put("zhongzhihuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = gonggaoService.queryPage(params);

        //字典表数据转换
        List<GonggaoView> list =(List<GonggaoView>)page.getList();
        for(GonggaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GonggaoEntity gonggao = gonggaoService.selectById(id);
        if(gonggao !=null){
            //entity转view
            GonggaoView view = new GonggaoView();
            BeanUtils.copyProperties( gonggao , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GonggaoEntity gonggao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gonggao:{}",this.getClass().getName(),gonggao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GonggaoEntity> queryWrapper = new EntityWrapper<GonggaoEntity>()
            .eq("gonggao_name", gonggao.getGonggaoName())
            .eq("gonggao_types", gonggao.getGonggaoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GonggaoEntity gonggaoEntity = gonggaoService.selectOne(queryWrapper);
        if(gonggaoEntity==null){
            gonggao.setInsertTime(new Date());
            gonggao.setCreateTime(new Date());
            gonggaoService.insert(gonggao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GonggaoEntity gonggao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,gonggao:{}",this.getClass().getName(),gonggao.toString());
        GonggaoEntity oldGonggaoEntity = gonggaoService.selectById(gonggao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(gonggao.getGonggaoPhoto()) || "null".equals(gonggao.getGonggaoPhoto())){
                gonggao.setGonggaoPhoto(null);
        }

            gonggaoService.updateById(gonggao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GonggaoEntity> oldGonggaoList =gonggaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        gonggaoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<GonggaoEntity> gonggaoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GonggaoEntity gonggaoEntity = new GonggaoEntity();
//                            gonggaoEntity.setGonggaoName(data.get(0));                    //公告名称 要改的
//                            gonggaoEntity.setGonggaoPhoto("");//详情和图片
//                            gonggaoEntity.setGonggaoTypes(Integer.valueOf(data.get(0)));   //公告类型 要改的
//                            gonggaoEntity.setInsertTime(date);//时间
//                            gonggaoEntity.setGonggaoContent("");//详情和图片
//                            gonggaoEntity.setCreateTime(date);//时间
                            gonggaoList.add(gonggaoEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        gonggaoService.insertBatch(gonggaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = gonggaoService.queryPage(params);

        //字典表数据转换
        List<GonggaoView> list =(List<GonggaoView>)page.getList();
        for(GonggaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GonggaoEntity gonggao = gonggaoService.selectById(id);
            if(gonggao !=null){


                //entity转view
                GonggaoView view = new GonggaoView();
                BeanUtils.copyProperties( gonggao , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody GonggaoEntity gonggao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gonggao:{}",this.getClass().getName(),gonggao.toString());
        Wrapper<GonggaoEntity> queryWrapper = new EntityWrapper<GonggaoEntity>()
            .eq("gonggao_name", gonggao.getGonggaoName())
            .eq("gonggao_types", gonggao.getGonggaoTypes())
//            .notIn("gonggao_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GonggaoEntity gonggaoEntity = gonggaoService.selectOne(queryWrapper);
        if(gonggaoEntity==null){
            gonggao.setInsertTime(new Date());
            gonggao.setCreateTime(new Date());
        gonggaoService.insert(gonggao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    @RequestMapping("/pinglin/list/{id}")
    public R list(@PathVariable("id") Long id, HttpServletRequest request){
        GonggaoPinglunEntity pinglun = new GonggaoPinglunEntity();
        pinglun.setGonggaoId(id);
//        Integer userId = (Integer)request.getSession().getAttribute("userId");
//        dianzan.setYonghuId(userId);
        EntityWrapper<GonggaoPinglunEntity> wrapper=new EntityWrapper<>(pinglun);
        List<GonggaoPinglunEntity> data = gonggaoPinglunService.selectList(wrapper);

        List<GonggaoPinglunView> res=new ArrayList<>();
        for (GonggaoPinglunEntity datum : data) {
            GonggaoPinglunView view = new GonggaoPinglunView();
            BeanUtils.copyProperties( datum , view );

            YonghuEntity yonghu = yonghuService.selectById(datum.getYonghuId());

            view.setYonghuName(yonghu.getYonghuName());
            view.setYonghuPhoto(yonghu.getYonghuPhoto());

            res.add(view);
        }

        return R.ok().put("data", res);
    }


    @RequestMapping("pinglun/add")
    public R add(@RequestBody GonggaoPinglunEntity pinglun, HttpServletRequest request){

        Integer userId = (Integer)request.getSession().getAttribute("userId");
        pinglun.setYonghuId(userId);

        gonggaoPinglunService.insert(pinglun);

        return R.ok("操作成功");
    }

}

