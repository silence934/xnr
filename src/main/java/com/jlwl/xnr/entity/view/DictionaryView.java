package com.jlwl.xnr.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.jlwl.xnr.entity.DictionaryEntity;

import java.io.Serializable;

/**
* 字典
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("dictionary")
public class DictionaryView extends DictionaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表




	public DictionaryView() {

	}









	@Override
	public String toString() {
		return "DictionaryView{" +
			"} " + super.toString();
	}
}
