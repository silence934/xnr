package com.jlwl.lhcnyxxglxt.entity.view;

import com.jlwl.lhcnyxxglxt.entity.GonggaoPinglunEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GonggaoPinglunView extends GonggaoPinglunEntity {
    private String yonghuName;
    private  String yonghuPhoto;
}

