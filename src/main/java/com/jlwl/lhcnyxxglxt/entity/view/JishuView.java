package com.jlwl.lhcnyxxglxt.entity.view;

import com.jlwl.lhcnyxxglxt.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jlwl.lhcnyxxglxt.entity.JishuEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
* 农业技术
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@Data
@TableName("jishu")
public class JishuView extends JishuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 农作物类型的值
	*/
	@ColumnInfo(comment="农作物类型的字典表值",type="varchar(200)")
	private String jishuValue;

	/**
	 * 是否已报名学习
	 */
	private Boolean study;



	public JishuView() {

	}




	//当前表的
	/**
	* 获取： 农作物类型的值
	*/
	public String getJishuValue() {
		return jishuValue;
	}
	/**
	* 设置： 农作物类型的值
	*/
	public void setJishuValue(String jishuValue) {
		this.jishuValue = jishuValue;
	}




	@Override
	public String toString() {
		return "JishuView{" +
			", jishuValue=" + jishuValue +
			"} " + super.toString();
	}
}
