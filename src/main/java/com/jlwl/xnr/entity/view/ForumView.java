package com.jlwl.xnr.entity.view;

import com.jlwl.xnr.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jlwl.xnr.entity.ForumEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 论坛
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@Data
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 帖子状态的值
	*/
	@ColumnInfo(comment="帖子状态的字典表值",type="varchar(200)")
	private String forumStateValue;

	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
	//级联表 种植户
		/**
		* 种植户姓名
		*/

		@ColumnInfo(comment="种植户姓名",type="varchar(200)")
		private String zhongzhihuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String zhongzhihuPhoto;
		/**
		* 种植户手机号
		*/

		@ColumnInfo(comment="种植户手机号",type="varchar(200)")
		private String zhongzhihuPhone;
		/**
		* 种植户身份证号
		*/

		@ColumnInfo(comment="种植户身份证号",type="varchar(200)")
		private String zhongzhihuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String zhongzhihuEmail;
//		/**
//		* 余额
//		*/
//		@ColumnInfo(comment="余额",type="decimal(10,2)")
//		private Double newMoney;
	//级联表 管理员
		/**
		* 儿童名
		*/
		@ColumnInfo(comment="儿童名",type="varchar(100)")
		private String uusername;
		/**
		* 密码
		*/
		@ColumnInfo(comment="密码",type="varchar(100)")
		private String upassword;
		/**
		* 角色
		*/
		@ColumnInfo(comment="角色",type="varchar(100)")
		private String urole;
		/**
		* 新增时间
		*/
		@ColumnInfo(comment="新增时间",type="timestamp")
		private Date uaddtime;

	private int count; //点赞数量
	private boolean dianzanEd; //是否否已点赞

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public ForumView() {

	}



	//当前表的
	/**
	* 获取： 帖子状态的值
	*/
	public String getForumStateValue() {
		return forumStateValue;
	}
	/**
	* 设置： 帖子状态的值
	*/
	public void setForumStateValue(String forumStateValue) {
		this.forumStateValue = forumStateValue;
	}


	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

//		/**
//		* 获取： 余额
//		*/
//		public Double getNewMoney() {
//			return newMoney;
//		}
//		/**
//		* 设置： 余额
//		*/
//		public void setNewMoney(Double newMoney) {
//			this.newMoney = newMoney;
//		}
	//级联表的get和set 种植户

		/**
		* 获取： 种植户姓名
		*/
		public String getZhongzhihuName() {
			return zhongzhihuName;
		}
		/**
		* 设置： 种植户姓名
		*/
		public void setZhongzhihuName(String zhongzhihuName) {
			this.zhongzhihuName = zhongzhihuName;
		}

		/**
		* 获取： 头像
		*/
		public String getZhongzhihuPhoto() {
			return zhongzhihuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setZhongzhihuPhoto(String zhongzhihuPhoto) {
			this.zhongzhihuPhoto = zhongzhihuPhoto;
		}

		/**
		* 获取： 种植户手机号
		*/
		public String getZhongzhihuPhone() {
			return zhongzhihuPhone;
		}
		/**
		* 设置： 种植户手机号
		*/
		public void setZhongzhihuPhone(String zhongzhihuPhone) {
			this.zhongzhihuPhone = zhongzhihuPhone;
		}

		/**
		* 获取： 种植户身份证号
		*/
		public String getZhongzhihuIdNumber() {
			return zhongzhihuIdNumber;
		}
		/**
		* 设置： 种植户身份证号
		*/
		public void setZhongzhihuIdNumber(String zhongzhihuIdNumber) {
			this.zhongzhihuIdNumber = zhongzhihuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getZhongzhihuEmail() {
			return zhongzhihuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setZhongzhihuEmail(String zhongzhihuEmail) {
			this.zhongzhihuEmail = zhongzhihuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
	//级联表的get和set 管理员
		/**
		* 获取： 儿童名
		*/
		public String getUusername() {
			return uusername;
		}
		/**
		* 设置： 儿童名
		*/
		public void setUusername(String uusername) {
			this.uusername = uusername;
		}
		/**
		* 获取： 密码
		*/
		public String getUpassword() {
			return upassword;
		}
		/**
		* 设置： 密码
		*/
		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}
		/**
		* 获取： 角色
		*/
		public String getUrole() {
			return urole;
		}
		/**
		* 设置： 角色
		*/
		public void setUrole(String urole) {
			this.urole = urole;
		}
		/**
		* 获取： 新增时间
		*/
		public Date getUaddtime() {
			return uaddtime;
		}
		/**
		* 设置： 新增时间
		*/
		public void setUaddtime(Date uaddtime) {
			this.uaddtime = uaddtime;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}


}
