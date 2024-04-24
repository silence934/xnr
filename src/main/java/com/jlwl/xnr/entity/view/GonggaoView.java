package com.jlwl.xnr.entity.view;

import com.jlwl.xnr.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jlwl.xnr.entity.GonggaoEntity;

import java.io.Serializable;

/**
* 公告
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("gonggao")
public class GonggaoView extends GonggaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 公告类型的值
	*/
	@ColumnInfo(comment="公告类型的字典表值",type="varchar(200)")
	private String gonggaoValue;




	public GonggaoView() {

	}



	//当前表的
	/**
	* 获取： 公告类型的值
	*/
	public String getGonggaoValue() {
		return gonggaoValue;
	}
	/**
	* 设置： 公告类型的值
	*/
	public void setGonggaoValue(String gonggaoValue) {
		this.gonggaoValue = gonggaoValue;
	}




	@Override
	public String toString() {
		return "GonggaoView{" +
			", gonggaoValue=" + gonggaoValue +
			"} " + super.toString();
	}
}
