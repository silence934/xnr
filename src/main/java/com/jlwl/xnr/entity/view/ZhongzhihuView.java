package com.jlwl.xnr.entity.view;

import com.jlwl.xnr.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jlwl.xnr.entity.ZhongzhihuEntity;

import java.io.Serializable;

/**
* 种植户
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhongzhihu")
public class ZhongzhihuView extends ZhongzhihuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;




	public ZhongzhihuView() {

	}




	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}




	@Override
	public String toString() {
		return "ZhongzhihuView{" +
			", sexValue=" + sexValue +
			"} " + super.toString();
	}
}
