
package com.jlwl.xnr.controller;

import com.alibaba.fastjson.JSONObject;
import com.jlwl.xnr.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
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
 * 农产品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chanpin")
public class ChanpinController {
    private static final Logger logger = LoggerFactory.getLogger(ChanpinController.class);

    private static final String TABLE_NAME = "chanpin";

    @Autowired
    private ChanpinService chanpinService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private ChanpinCollectionService chanpinCollectionService;//农产品收藏
    @Autowired
    private ChanpinCommentbackService chanpinCommentbackService;//农产品评价
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
        params.put("chanpinDeleteStart",1);params.put("chanpinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = chanpinService.queryPage(params);

        //字典表数据转换
        List<ChanpinView> list =(List<ChanpinView>)page.getList();
        for(ChanpinView c:list){
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
        ChanpinEntity chanpin = chanpinService.selectById(id);
        if(chanpin !=null){
            //entity转view
            ChanpinView view = new ChanpinView();
            BeanUtils.copyProperties( chanpin , view );//把实体数据重构到view中
            //级联表 种植户
            //级联表
            ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(chanpin.getZhongzhihuId());
            if(zhongzhihu != null){
            BeanUtils.copyProperties( zhongzhihu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhongzhihuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhongzhihuId(zhongzhihu.getId());
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
    public R save(@RequestBody ChanpinEntity chanpin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chanpin:{}",this.getClass().getName(),chanpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("种植户".equals(role))
            chanpin.setZhongzhihuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChanpinEntity> queryWrapper = new EntityWrapper<ChanpinEntity>()
            .eq("zhongzhihu_id", chanpin.getZhongzhihuId())
            .eq("chanpin_name", chanpin.getChanpinName())
            .eq("chanpin_types", chanpin.getChanpinTypes())
            .eq("chanpin_kucun_number", chanpin.getChanpinKucunNumber())
            .eq("chanpin_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinEntity chanpinEntity = chanpinService.selectOne(queryWrapper);
        if(chanpinEntity==null){
            chanpin.setChanpinClicknum(1);
            chanpin.setChanpinDelete(1);
            chanpin.setInsertTime(new Date());
            chanpin.setCreateTime(new Date());
            chanpinService.insert(chanpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChanpinEntity chanpin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chanpin:{}",this.getClass().getName(),chanpin.toString());
        ChanpinEntity oldChanpinEntity = chanpinService.selectById(chanpin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("种植户".equals(role))
//            chanpin.setZhongzhihuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(chanpin.getChanpinPhoto()) || "null".equals(chanpin.getChanpinPhoto())){
                chanpin.setChanpinPhoto(null);
        }

            chanpinService.updateById(chanpin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChanpinEntity> oldChanpinList =chanpinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ChanpinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChanpinEntity chanpinEntity = new ChanpinEntity();
            chanpinEntity.setId(id);
            chanpinEntity.setChanpinDelete(2);
            list.add(chanpinEntity);
        }
        if(list != null && list.size() >0){
            chanpinService.updateBatchById(list);
        }

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
            List<ChanpinEntity> chanpinList = new ArrayList<>();//上传的东西
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
                            ChanpinEntity chanpinEntity = new ChanpinEntity();
//                            chanpinEntity.setZhongzhihuId(Integer.valueOf(data.get(0)));   //种植户 要改的
//                            chanpinEntity.setChanpinName(data.get(0));                    //农产品名称 要改的
//                            chanpinEntity.setChanpinUuidNumber(data.get(0));                    //农产品编号 要改的
//                            chanpinEntity.setChanpinPhoto("");//详情和图片
//                            chanpinEntity.setChanpinTypes(Integer.valueOf(data.get(0)));   //农产品类型 要改的
//                            chanpinEntity.setChanpinKucunNumber(Integer.valueOf(data.get(0)));   //农产品库存 要改的
//                            chanpinEntity.setChanpinNewMoney(data.get(0));                    //金额 要改的
//                            chanpinEntity.setChanpinClicknum(Integer.valueOf(data.get(0)));   //农产品热度 要改的
//                            chanpinEntity.setChanpinContent("");//详情和图片
//                            chanpinEntity.setChanpinDelete(1);//逻辑删除字段
//                            chanpinEntity.setInsertTime(date);//时间
//                            chanpinEntity.setCreateTime(date);//时间
                            chanpinList.add(chanpinEntity);


                            //把要查询是否重复的字段放入map中
                                //农产品编号
                                if(seachFields.containsKey("chanpinUuidNumber")){
                                    List<String> chanpinUuidNumber = seachFields.get("chanpinUuidNumber");
                                    chanpinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chanpinUuidNumber = new ArrayList<>();
                                    chanpinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chanpinUuidNumber",chanpinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //农产品编号
                        List<ChanpinEntity> chanpinEntities_chanpinUuidNumber = chanpinService.selectList(new EntityWrapper<ChanpinEntity>().in("chanpin_uuid_number", seachFields.get("chanpinUuidNumber")).eq("chanpin_delete", 1));
                        if(chanpinEntities_chanpinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChanpinEntity s:chanpinEntities_chanpinUuidNumber){
                                repeatFields.add(s.getChanpinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [农产品编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chanpinService.insertBatch(chanpinList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ChanpinView> returnChanpinViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = chanpinOrderService.queryPage(params1);
        List<ChanpinOrderView> orderViewsList =(List<ChanpinOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ChanpinOrderView orderView:orderViewsList){
            Integer chanpinTypes = orderView.getChanpinTypes();
            if(typeMap.containsKey(chanpinTypes)){
                typeMap.put(chanpinTypes,typeMap.get(chanpinTypes)+1);
            }else{
                typeMap.put(chanpinTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("chanpinTypes",type);
            PageUtils pageUtils1 = chanpinService.queryPage(params2);
            List<ChanpinView> chanpinViewList =(List<ChanpinView>)pageUtils1.getList();
            returnChanpinViewList.addAll(chanpinViewList);
            if(returnChanpinViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = chanpinService.queryPage(params);
        if(returnChanpinViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnChanpinViewList.size();//要添加的数量
            List<ChanpinView> chanpinViewList =(List<ChanpinView>)page.getList();
            for(ChanpinView chanpinView:chanpinViewList){
                Boolean addFlag = true;
                for(ChanpinView returnChanpinView:returnChanpinViewList){
                    if(returnChanpinView.getId().intValue() ==chanpinView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnChanpinViewList.add(chanpinView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnChanpinViewList = returnChanpinViewList.subList(0, limit);
        }

        for(ChanpinView c:returnChanpinViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnChanpinViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chanpinService.queryPage(params);

        //字典表数据转换
        List<ChanpinView> list =(List<ChanpinView>)page.getList();
        for(ChanpinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChanpinEntity chanpin = chanpinService.selectById(id);
            if(chanpin !=null){

                //点击数量加1
                chanpin.setChanpinClicknum(chanpin.getChanpinClicknum()+1);
                chanpinService.updateById(chanpin);

                //entity转view
                ChanpinView view = new ChanpinView();
                BeanUtils.copyProperties( chanpin , view );//把实体数据重构到view中

                //级联表
                    ZhongzhihuEntity zhongzhihu = zhongzhihuService.selectById(chanpin.getZhongzhihuId());
                if(zhongzhihu != null){
                    BeanUtils.copyProperties( zhongzhihu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhongzhihuId(zhongzhihu.getId());
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
    public R add(@RequestBody ChanpinEntity chanpin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chanpin:{}",this.getClass().getName(),chanpin.toString());
        Wrapper<ChanpinEntity> queryWrapper = new EntityWrapper<ChanpinEntity>()
            .eq("zhongzhihu_id", chanpin.getZhongzhihuId())
            .eq("chanpin_name", chanpin.getChanpinName())
            .eq("chanpin_uuid_number", chanpin.getChanpinUuidNumber())
            .eq("chanpin_types", chanpin.getChanpinTypes())
            .eq("chanpin_kucun_number", chanpin.getChanpinKucunNumber())
            .eq("chanpin_clicknum", chanpin.getChanpinClicknum())
            .eq("chanpin_delete", chanpin.getChanpinDelete())
//            .notIn("chanpin_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinEntity chanpinEntity = chanpinService.selectOne(queryWrapper);
        if(chanpinEntity==null){
            chanpin.setChanpinClicknum(1);
            chanpin.setChanpinDelete(1);
            chanpin.setInsertTime(new Date());
            chanpin.setCreateTime(new Date());
        chanpinService.insert(chanpin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
