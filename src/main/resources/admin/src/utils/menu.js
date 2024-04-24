const menu = {
    list() {
        return [
    {
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"管理员管理",
                        "menuJump":"列表",
                        "tableName":"users"
                    }
                ],
                "menu":"管理员管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"种植户管理",
                        "menuJump":"列表",
                        "tableName":"zhongzhihu"
                    }
                ],
                "menu":"种植户管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"用户管理",
                        "menuJump":"列表",
                        "tableName":"yonghu"
                    }
                ],
                "menu":"用户管理"
            }
            // ,{
            //     "child":[
            //         {
            //             "buttons":[
            //                 "查看",
            //                 "新增",
            //                 "修改",
            //                 "删除"
            //             ],
            //             "menu":"农资管理",
            //             "menuJump":"列表",
            //             "tableName":"nongzi"
            //         }
            //         ,
            //         {
            //             "buttons":[
            //                 "订单",
            //                 "查看",
            //                 "删除"
            //             ],
            //             "menu":"农资订单管理",
            //             "menuJump":"列表",
            //             "tableName":"nongziOrder"
            //         }
            //     ],
            //     "menu":"农资管理"
            // }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"农产品管理",
                        "menuJump":"列表",
                        "tableName":"chanpin"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "修改",
                            "删除"
                        ],
                        "menu":"农产品评价管理",
                        "menuJump":"列表",
                        "tableName":"chanpinCommentback"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "删除"
                        ],
                        "menu":"农产品收藏管理",
                        "menuJump":"列表",
                        "tableName":"chanpinCollection"
                    }
                    ,
                    {
                        "buttons":[
                            "订单",
                            "查看",
                            "删除"
                        ],
                        "menu":"农产品订单管理",
                        "menuJump":"列表",
                        "tableName":"chanpinOrder"
                    }
                ],
                "menu":"农产品管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"讲座和展会管理",
                        "menuJump":"列表",
                        "tableName":"jishu"
                    }
                ],
                "menu":"讲座和展会管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"论坛管理",
                        "menuJump":"列表",
                        "tableName":"forum"
                    }
                ],
                "menu":"论坛管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"农资管理",
                        "menuJump":"列表",
                        "tableName":"gonggao"
                    }
                ],
                "menu":"农资管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"农产品类型管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryChanpin"
                    }

                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"农资类型管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryGonggao"
                    }
                    ,
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "删除",
                            "修改"
                        ],
                        "menu":"农作物类型管理",
                        "menuJump":"列表",
                        "tableName":"dictionaryJishu"
                    }
                    ,
                    // {
                    //     "buttons":[
                    //         "查看",
                    //         "新增",
                    //         "删除",
                    //         "修改"
                    //     ],
                    //     "menu":"农资类型管理",
                    //     "menuJump":"列表",
                    //     "tableName":"dictionaryNongzi"
                    // }

                ],
                "menu":"基础数据管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"轮播图管理",
                        "menuJump":"列表",
                        "tableName":"config"
                    }
                ],
                "menu":"轮播图信息"
            }
            /*,{
			    "child":[
			        {
			            "buttons":[
			                "查看"
			            ],
			            "menu":"数据备份",
			            "menuJump":"列表",
			            "tableName":"beifen"
			        },
					{
					    "buttons":[
					        "查看"
					    ],
					    "menu":"数据还原",
					    "menuJump":"列表",
					    "tableName":"huanyuan"
					}
			    ],
			    "menu":"数据库管理"
			}*/
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"管理员",
        "tableName":"users"
    },
            {
                "backMenu":[
                    {
                        "child":[
                            {
                                "buttons":[
                                    "查看",
                                ],
                                "menu":"农资管理",
                                "menuJump":"列表",
                                "tableName":"nongzi"
                            }
                            ,
                            {
                                "buttons":[
                                    "订单",
                                    "查看",
                                    "删除",
                                    "新增"
                                ],
                                "menu":"农资订单管理",
                                "menuJump":"列表",
                                "tableName":"nongziOrder"
                            }
                        ],
                        "menu":"农资管理"
                    }
                    ,{
                        "child":[
                            {
                                "buttons":[
                                    "查看",
                                    "新增",
                                    "修改",
                                    "删除"
                                ],
                                "menu":"农产品管理",
                                "menuJump":"列表",
                                "tableName":"chanpin"
                            }
                            ,
                            {
                                "buttons":[
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu":"农产品评价管理",
                                "menuJump":"列表",
                                "tableName":"chanpinCommentback"
                            }
                            ,
                            {
                                "buttons":[
                                    "查看",
                                    "删除"
                                ],
                                "menu":"农产品收藏管理",
                                "menuJump":"列表",
                                "tableName":"chanpinCollection"
                            }
                            ,
                            {
                                "buttons":[
                                    "订单",
                                    "查看",
                                    "删除"
                                ],
                                "menu":"农产品订单管理",
                                "menuJump":"列表",
                                "tableName":"chanpinOrder"
                            }
                        ],
                        "menu":"农产品管理"
                    }
                    ,{
                        "child":[
                            {
                                "buttons":[
                                    "查看",
                                ],
                                "menu":"农业技术管理",
                                "menuJump":"列表",
                                "tableName":"jishu"
                            }
                        ],
                        "menu":"农业技术管理"
                    }
                    ,{
                        "child":[
                            {
                                "buttons":[
                                    "查看",
                                    "新增",
                                ],
                                "menu":"论坛管理",
                                "menuJump":"列表",
                                "tableName":"forum"
                            }
                        ],
                        "menu":"论坛管理"
                    }
                    ,{
                        "child":[
                            {
                                "buttons":[
                                    "查看",
                                ],
                                "menu":"公告管理",
                                "menuJump":"列表",
                                "tableName":"gonggao"
                            }
                        ],
                        "menu":"公告管理"
                    }
                    ,{
                        "child":[
                            {
                                "buttons":[
                                    "查看",
                                ],
                                "menu":"轮播图管理",
                                "menuJump":"列表",
                                "tableName":"config"
                            }
                        ],
                        "menu":"轮播图信息"
                    }
                    /*,{
                        "child":[
                            {
                                "buttons":[
                                    "查看"
                                ],
                                "menu":"数据备份",
                                "menuJump":"列表",
                                "tableName":"beifen"
                            },
                            {
                                "buttons":[
                                    "查看"
                                ],
                                "menu":"数据还原",
                                "menuJump":"列表",
                                "tableName":"huanyuan"
                            }
                        ],
                        "menu":"数据库管理"
                    }*/
                ],
                "frontMenu":[],
                "hasBackLogin":"是",
                "hasBackRegister":"否",
                "hasFrontLogin":"否",
                "hasFrontRegister":"否",
                "roleName":"种植户",
                "tableName":"zhongzhihu"
            }
]
    }
}
export default menu;
