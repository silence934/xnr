package com.jlwl.lhcnyxxglxt.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.jlwl.lhcnyxxglxt.annotation.ColumnInfo;
import lombok.Data;

@Data
@TableName("forum_dian_zan")
public class ForumDianzanEntity {

    @TableId(type = IdType.AUTO)
    private  Long id;

    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    @ColumnInfo(comment="帖子id",type="int(11)")
    @TableField(value = "forum_id")
    private Long forumId;
}
