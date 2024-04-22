package com.jlwl.lhcnyxxglxt.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jlwl.lhcnyxxglxt.annotation.ColumnInfo;
import com.jlwl.lhcnyxxglxt.utils.DateUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 公告评论
 */
@Data
@TableName("gonggao_pinglun")
public class GonggaoPinglunEntity implements Serializable {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")
    private Integer id;


    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    @ColumnInfo(comment="公告id",type="int(11)")
    @TableField(value = "gonggao_id")
    private Long gonggaoId;

    @ColumnInfo(comment="评论内容",type="longtext")
    @TableField(value = "content")
    private String content;

}
