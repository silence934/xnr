package com.jlwl.xnr.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.jlwl.xnr.annotation.ColumnInfo;
import lombok.Data;

@Data
@TableName("jishu_study")
public class JishuStudyEntity {

    @TableId(type = IdType.AUTO)
    private  Long id;

    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    @ColumnInfo(comment="农业技术id",type="int(11)")
    @TableField(value = "jishu_id")
    private Long jishuId;
}
