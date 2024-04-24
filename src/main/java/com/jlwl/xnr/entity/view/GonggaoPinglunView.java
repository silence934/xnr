package com.jlwl.xnr.entity.view;

import com.jlwl.xnr.entity.GonggaoPinglunEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GonggaoPinglunView extends GonggaoPinglunEntity {
    private String yonghuName;
    private  String yonghuPhoto;
}

