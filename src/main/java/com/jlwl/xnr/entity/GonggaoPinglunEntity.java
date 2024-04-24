package com.jlwl.xnr.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.jlwl.xnr.annotation.ColumnInfo;
import lombok.Data;

import java.io.Serializable;


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
