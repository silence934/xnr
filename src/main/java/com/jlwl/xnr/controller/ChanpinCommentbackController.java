
package com.jlwl.xnr.controller;

import com.alibaba.fastjson.JSONObject;
import com.jlwl.xnr.annotation.IgnoreAuth;
import com.jlwl.xnr.entity.*;
import com.jlwl.xnr.entity.view.*;
import com.jlwl.xnr.service.*;
import com.jlwl.xnr.service.DictionaryService;
import com.jlwl.xnr.service.TokenService;
import com.jlwl.xnr.utils.*;
import com.jlwl.xnr.utils.PageUtils;
import com.jlwl.xnr.utils.R;
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
 * 农产品评价
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chanpinCommentback")
public class ChanpinCommentbackController {
    private static final Logger logger = LoggerFactory.getLogger(ChanpinCommentbackController.class);

    private static final String TABLE_NAME = "chanpinCommentback";

    @Autowired
    private ChanpinCommentbackService chanpinCommentbackService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private ChanpinService chanpinService;//农产品
    @Autowired
    private ChanpinCollectionService chanpinCollectionService;//农产品收藏
    @Autowired
    private ChanpinOrderService chanpinOrderService;//农产品订单
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JishuService jishuService;//农业技术
    @Autowired
    private NongziService nongziService;//农资
    @Autowired
    private NongziOrderService nongziOrderService;//农资订单
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhongzhihuService zhongzhihuService;//种植户
    @Autowired
    private UsersService usersService;//管理员


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
        PageUtils page = chanpinCommentbackService.queryPage(params);

        //字典表数据转换
        List<ChanpinCommentbackView> list =(List<ChanpinCommentbackView>)page.getList();
        for(ChanpinCommentbackView c:list){
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
        ChanpinCommentbackEntity chanpinCommentback = chanpinCommentbackService.selectById(id);
        if(chanpinCommentback !=null){
            //entity转view
            ChanpinCommentbackView view = new ChanpinCommentbackView();
            BeanUtils.copyProperties( chanpinCommentback , view );//把实体数据重构到view中
            //级联表 农产品
            //级联表
            ChanpinEntity chanpin = chanpinService.selectById(chanpinCommentback.getChanpinId());
            if(chanpin != null){
            BeanUtils.copyProperties( chanpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChanpinId(chanpin.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(chanpinCommentback.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody ChanpinCommentbackEntity chanpinCommentback, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chanpinCommentback:{}",this.getClass().getName(),chanpinCommentback.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chanpinCommentback.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        chanpinCommentback.setCreateTime(new Date());
        chanpinCommentback.setInsertTime(new Date());
        chanpinCommentbackService.insert(chanpinCommentback);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChanpinCommentbackEntity chanpinCommentback, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chanpinCommentback:{}",this.getClass().getName(),chanpinCommentback.toString());
        ChanpinCommentbackEntity oldChanpinCommentbackEntity = chanpinCommentbackService.selectById(chanpinCommentback.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chanpinCommentback.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        chanpinCommentback.setUpdateTime(new Date());

            chanpinCommentbackService.updateById(chanpinCommentback);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChanpinCommentbackEntity> oldChanpinCommentbackList =chanpinCommentbackService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chanpinCommentbackService.deleteBatchIds(Arrays.asList(ids));

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
            List<ChanpinCommentbackEntity> chanpinCommentbackList = new ArrayList<>();//上传的东西
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
                            ChanpinCommentbackEntity chanpinCommentbackEntity = new ChanpinCommentbackEntity();
//                            chanpinCommentbackEntity.setChanpinId(Integer.valueOf(data.get(0)));   //农产品 要改的
//                            chanpinCommentbackEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chanpinCommentbackEntity.setChanpinCommentbackText(data.get(0));                    //评价内容 要改的
//                            chanpinCommentbackEntity.setInsertTime(date);//时间
//                            chanpinCommentbackEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            chanpinCommentbackEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            chanpinCommentbackEntity.setCreateTime(date);//时间
                            chanpinCommentbackList.add(chanpinCommentbackEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chanpinCommentbackService.insertBatch(chanpinCommentbackList);
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
        PageUtils page = chanpinCommentbackService.queryPage(params);

        //字典表数据转换
        List<ChanpinCommentbackView> list =(List<ChanpinCommentbackView>)page.getList();
        for(ChanpinCommentbackView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChanpinCommentbackEntity chanpinCommentback = chanpinCommentbackService.selectById(id);
            if(chanpinCommentback !=null){


                //entity转view
                ChanpinCommentbackView view = new ChanpinCommentbackView();
                BeanUtils.copyProperties( chanpinCommentback , view );//把实体数据重构到view中

                //级联表
                    ChanpinEntity chanpin = chanpinService.selectById(chanpinCommentback.getChanpinId());
                if(chanpin != null){
                    BeanUtils.copyProperties( chanpin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChanpinId(chanpin.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chanpinCommentback.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody ChanpinCommentbackEntity chanpinCommentback, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chanpinCommentback:{}",this.getClass().getName(),chanpinCommentback.toString());
        chanpinCommentback.setCreateTime(new Date());
        chanpinCommentback.setInsertTime(new Date());
        chanpinCommentbackService.insert(chanpinCommentback);

            return R.ok();
        }

}
