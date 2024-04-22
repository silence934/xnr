package com.jlwl.lhcnyxxglxt.entity;

import com.jlwl.lhcnyxxglxt.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jlwl.lhcnyxxglxt.utils.DateUtil;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 论坛
 *
 * @author 
 * @email
 */
@Getter
@TableName("forum")
public class ForumEntity implements Serializable {
    private static final long serialVersionUID = 1L;


	public ForumEntity() {

	}


    /**
     * 主键
     * -- GETTER --
     *  获取：主键

     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 帖子标题
     * -- GETTER --
     *  获取：帖子标题

     */
    @ColumnInfo(comment="帖子标题",type="varchar(200)")
    @TableField(value = "forum_name")

    private String forumName;


    /**
     * 用户
     * -- GETTER --
     *  获取：用户

     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 种植户
     * -- GETTER --
     *  获取：种植户

     */
    @ColumnInfo(comment="种植户",type="int(11)")
    @TableField(value = "zhongzhihu_id")

    private Integer zhongzhihuId;


    /**
     * 管理员
     * -- GETTER --
     *  获取：管理员

     */
    @ColumnInfo(comment="管理员",type="int(11)")
    @TableField(value = "users_id")

    private Integer usersId;


    /**
     * 发布内容
     * -- GETTER --
     *  获取：发布内容

     */
    @ColumnInfo(comment="发布内容",type="longtext")
    @TableField(value = "forum_content")
    private String forumContent;


    /**
     * 父id
     * -- GETTER --
     *  获取：父id

     */
    @ColumnInfo(comment="父id",type="int(11)")
    @TableField(value = "super_ids")

    private Integer superIds;


    /**
     * 帖子状态
     * -- GETTER --
     *  获取：帖子状态

     */
    @ColumnInfo(comment="帖子状态",type="int(11)")
    @TableField(value = "forum_state_types")

    private Integer forumStateTypes;


    /**
     * 发帖时间
     * -- GETTER --
     *  获取：发帖时间

     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发帖时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 修改时间
     * -- GETTER --
     *  获取：修改时间

     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="修改时间",type="timestamp")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


    /**
     * 创建时间
     * -- GETTER --
     *  获取：创建时间

     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
	 * 设置：帖子标题
	 */

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }

    /**
	 * 设置：种植户
	 */

    public void setZhongzhihuId(Integer zhongzhihuId) {
        this.zhongzhihuId = zhongzhihuId;
    }

    /**
	 * 设置：管理员
	 */

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    /**
	 * 设置：发布内容
	 */

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }

    /**
	 * 设置：父id
	 */

    public void setSuperIds(Integer superIds) {
        this.superIds = superIds;
    }

    /**
	 * 设置：帖子状态
	 */

    public void setForumStateTypes(Integer forumStateTypes) {
        this.forumStateTypes = forumStateTypes;
    }

    /**
	 * 设置：发帖时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
	 * 设置：修改时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Forum{" +
            ", id=" + id +
            ", forumName=" + forumName +
            ", yonghuId=" + yonghuId +
            ", zhongzhihuId=" + zhongzhihuId +
            ", usersId=" + usersId +
            ", forumContent=" + forumContent +
            ", superIds=" + superIds +
            ", forumStateTypes=" + forumStateTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", updateTime=" + DateUtil.convertString(updateTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
