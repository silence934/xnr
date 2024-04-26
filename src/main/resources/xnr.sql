/*
 Navicat MySQL Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : xnr

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 27/04/2024 00:17:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yonghu_id` int NOT NULL COMMENT '创建用户',
  `address_name` varchar(200) NOT NULL COMMENT '收货人 ',
  `address_phone` varchar(200) NOT NULL COMMENT '电话 ',
  `address_dizhi` varchar(200) NOT NULL COMMENT '地址 ',
  `isdefault_types` int NOT NULL COMMENT '是否默认地址 ',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 show3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='收货地址';

-- ----------------------------
-- Records of address
-- ----------------------------
BEGIN;
INSERT INTO `address` VALUES (1, 1, '收货人1', '17703786901', '地址1', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (2, 2, '收货人2', '17703786902', '地址2', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (3, 1, '收货人3', '17703786903', '地址3', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (4, 1, '收货人4', '17703786904', '地址4', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (5, 1, '收货人5', '17703786905', '地址5', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (6, 1, '收货人6', '17703786906', '地址6', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (7, 1, '收货人7', '17703786907', '地址7', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (8, 1, '收货人8', '17703786908', '地址8', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (9, 2, '收货人9', '17703786909', '地址9', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (10, 3, '收货人10', '17703786910', '地址10', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (11, 2, '收货人11', '17703786911', '地址11', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (13, 3, '收货人13', '17703786913', '地址13', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (14, 3, '收货人14', '17703786914', '地址14', 1, '2023-04-12 09:15:56', '2023-04-12 09:15:56', '2024-04-23 21:26:02');
INSERT INTO `address` VALUES (15, 1, '11', '13456723589', '111', 2, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
COMMIT;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `yonghu_id` int DEFAULT NULL COMMENT '所属用户',
  `chanpin_id` int DEFAULT NULL COMMENT '农产品',
  `buy_number` int DEFAULT NULL COMMENT '购买数量',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='购物车';

-- ----------------------------
-- Records of cart
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for chanpin
-- ----------------------------
DROP TABLE IF EXISTS `chanpin`;
CREATE TABLE `chanpin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `zhongzhihu_id` int DEFAULT NULL COMMENT '种植户',
  `chanpin_name` varchar(200) DEFAULT NULL COMMENT '农产品名称  Search111 ',
  `chanpin_uuid_number` varchar(200) DEFAULT NULL COMMENT '农产品编号',
  `chanpin_photo` varchar(200) DEFAULT NULL COMMENT '农产品照片',
  `chanpin_types` int DEFAULT NULL COMMENT '农产品类型 Search111',
  `chanpin_kucun_number` int DEFAULT NULL COMMENT '农产品库存',
  `chanpin_new_money` decimal(10,2) DEFAULT NULL COMMENT '金额 ',
  `chanpin_clicknum` int DEFAULT NULL COMMENT '农产品热度',
  `chanpin_content` longtext COMMENT '农产品介绍 ',
  `chanpin_delete` int DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='农产品';

-- ----------------------------
-- Records of chanpin
-- ----------------------------
BEGIN;
INSERT INTO `chanpin` VALUES (1, 2, '农产品名称1', '1681262156395', 'upload/chanpin1.jpg', 2, 101, 95.48, 323, '农产品介绍1', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (2, 3, '农产品名称2', '1681262156362', 'upload/chanpin2.jpg', 2, 100, 109.27, 316, '农产品介绍2', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (3, 2, '农产品名称3', '1681262156393', 'upload/chanpin3.jpg', 2, 103, 473.89, 82, '农产品介绍3', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (4, 2, '农产品名称4', '1681262156416', 'upload/chanpin4.jpg', 4, 104, 166.09, 33, '农产品介绍4', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (5, 3, '农产品名称5', '1681262156420', 'upload/chanpin5.jpg', 3, 105, 156.67, 149, '农产品介绍5', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (6, 1, '农产品名称6', '1681262156368', 'upload/chanpin6.jpg', 3, 102, 111.54, 430, '农产品介绍6', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (7, 2, '农产品名称7', '1681262156342', 'upload/chanpin7.jpg', 1, 107, 362.48, 251, '农产品介绍7', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (8, 3, '农产品名称8', '1681262156374', 'upload/chanpin8.jpg', 1, 108, 302.45, 388, '农产品介绍8', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (9, 3, '农产品名称9', '1681262156391', 'upload/chanpin9.jpg', 4, 109, 194.14, 434, '农产品介绍9', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (10, 2, '农产品名称10', '1681262156363', 'upload/chanpin10.jpg', 1, 1010, 450.39, 129, '农产品介绍10', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (11, 2, '农产品名称11', '1681262156351', 'upload/chanpin11.jpg', 1, 1011, 37.41, 160, '农产品介绍11', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (12, 3, '农产品名称12', '1681262156330', 'upload/chanpin12.jpg', 4, 1012, 126.94, 482, '农产品介绍12', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (13, 3, '农产品名称13', '1681262156422', 'upload/chanpin13.jpg', 2, 1010, 77.70, 164, '农产品介绍13', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (14, 2, '农产品名称14', '1681262156365', 'upload/chanpin14.jpg', 3, 1014, 41.72, 6, '农产品介绍14', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (15, 2, '钱', '1713878152799', 'upload/1713878164133.jpeg', 3, 1, 3.00, 2, '<p>111</p>', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin` VALUES (16, 1, 'qqqq', '1713878849490', 'upload/1713878859979.jpeg', 4, 11, 1.00, 2, '<p>xxxx<img src=\"upload/1713878867777.jpeg\"></p>', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
COMMIT;

-- ----------------------------
-- Table structure for chanpin_collection
-- ----------------------------
DROP TABLE IF EXISTS `chanpin_collection`;
CREATE TABLE `chanpin_collection` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chanpin_id` int DEFAULT NULL COMMENT '农产品',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `chanpin_collection_types` int DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COMMENT='农产品收藏';

-- ----------------------------
-- Records of chanpin_collection
-- ----------------------------
BEGIN;
INSERT INTO `chanpin_collection` VALUES (1, 1, 3, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (2, 2, 2, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (3, 3, 1, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (4, 4, 3, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (5, 5, 3, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (6, 6, 2, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (7, 7, 3, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (8, 8, 2, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (9, 9, 3, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (10, 10, 2, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (11, 11, 3, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (12, 12, 3, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (13, 13, 3, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (14, 14, 2, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (16, 6, 1, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (17, 13, 1, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_collection` VALUES (18, 2, 1, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
COMMIT;

-- ----------------------------
-- Table structure for chanpin_commentback
-- ----------------------------
DROP TABLE IF EXISTS `chanpin_commentback`;
CREATE TABLE `chanpin_commentback` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chanpin_id` int DEFAULT NULL COMMENT '农产品',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `chanpin_commentback_text` longtext COMMENT '评价内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '评价时间',
  `reply_text` longtext COMMENT '回复内容',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='农产品评价';

-- ----------------------------
-- Records of chanpin_commentback
-- ----------------------------
BEGIN;
INSERT INTO `chanpin_commentback` VALUES (1, 1, 1, '评价内容1', '2023-04-12 09:15:56', '回复信息1', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (2, 2, 1, '评价内容2', '2023-04-12 09:15:56', '回复信息2', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (3, 3, 2, '评价内容3', '2023-04-12 09:15:56', '回复信息3', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (4, 4, 2, '评价内容4', '2023-04-12 09:15:56', '回复信息4', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (5, 5, 1, '评价内容5', '2023-04-12 09:15:56', '回复信息5', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (6, 6, 1, '评价内容6', '2023-04-12 09:15:56', '回复信息6', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (7, 7, 3, '评价内容7', '2023-04-12 09:15:56', '回复信息7', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (8, 8, 3, '评价内容8', '2023-04-12 09:15:56', '回复信息8', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (9, 9, 1, '评价内容9', '2023-04-12 09:15:56', '回复信息9', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (10, 10, 2, '评价内容10', '2023-04-12 09:15:56', '回复信息10', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (11, 11, 1, '评价内容11', '2023-04-12 09:15:56', '回复信息11', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (12, 12, 1, '评价内容12', '2023-04-12 09:15:56', '回复信息12', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (13, 13, 3, '评价内容13', '2023-04-12 09:15:56', '回复信息13', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (14, 14, 3, '评价内容14', '2023-04-12 09:15:56', '回复信息14', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `chanpin_commentback` VALUES (15, 6, 1, '不错呢', '2023-04-12 11:02:02', '谢谢', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
COMMIT;

-- ----------------------------
-- Table structure for chanpin_order
-- ----------------------------
DROP TABLE IF EXISTS `chanpin_order`;
CREATE TABLE `chanpin_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `address_id` int DEFAULT NULL COMMENT '收货地址 ',
  `chanpin_order_uuid_number` varchar(200) DEFAULT NULL COMMENT '订单编号 Search111 ',
  `chanpin_id` int DEFAULT NULL COMMENT '农产品',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `buy_number` int DEFAULT NULL COMMENT '购买数量',
  `chanpin_order_true_price` decimal(10,2) DEFAULT NULL COMMENT '实付价格',
  `chanpin_order_courier_name` varchar(200) DEFAULT NULL COMMENT '快递公司',
  `chanpin_order_courier_number` varchar(200) DEFAULT NULL COMMENT '快递单号',
  `chanpin_order_types` int DEFAULT NULL COMMENT '订单类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='农产品订单';

-- ----------------------------
-- Records of chanpin_order
-- ----------------------------
BEGIN;
INSERT INTO `chanpin_order` VALUES (4, 12, '1713709092313', 6, 1, 2, 223.08, '1', '2', 104, '2024-04-21 22:18:12', '2024-04-21 22:18:12');
INSERT INTO `chanpin_order` VALUES (5, 7, '1713878195285', 15, 1, 1, 3.00, 'x', '2', 104, '2024-04-23 21:16:35', '2024-04-23 21:16:35');
INSERT INTO `chanpin_order` VALUES (6, 6, '1713878680571', 13, 1, 3, 233.10, '1', '1', 104, '2024-04-23 21:24:41', '2024-04-23 21:24:41');
INSERT INTO `chanpin_order` VALUES (7, 1, '1714051722449', 2, 1, 2, 218.54, NULL, NULL, 101, '2024-04-25 21:28:42', '2024-04-25 21:28:42');
COMMIT;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='配置文件';

-- ----------------------------
-- Records of config
-- ----------------------------
BEGIN;
INSERT INTO `config` VALUES (1, '轮播图1', 'upload/config1.jpg');
INSERT INTO `config` VALUES (3, '轮播图3', 'upload/config3.jpg');
COMMIT;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字段名',
  `code_index` int DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 COMMENT='字典';

-- ----------------------------
-- Records of dictionary
-- ----------------------------
BEGIN;
INSERT INTO `dictionary` VALUES (1, 'sex_types', '性别类型', 1, '男', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (2, 'sex_types', '性别类型', 2, '女', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (3, 'gonggao_types1', '公告类型', 1, '公告类型1', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (4, 'gonggao_types1', '公告类型', 2, '公告类型2', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (5, 'forum_state_types', '帖子状态', 1, '发帖', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (6, 'forum_state_types', '帖子状态', 2, '回帖', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (9, 'jishu_types', '农业技术类型', 3, '讲座', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (10, 'jishu_types', '农业技术类型', 4, '展会', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (11, 'chanpin_types', '农产品类型', 1, '农产品类型1', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (12, 'chanpin_types', '农产品类型', 2, '农产品类型2', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (13, 'chanpin_types', '农产品类型', 3, '农产品类型3', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (14, 'chanpin_types', '农产品类型', 4, 'xxxx', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (15, 'chanpin_collection_types', '收藏表类型', 1, '收藏', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (16, 'chanpin_order_types', '订单类型', 101, '已支付', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (17, 'chanpin_order_types', '订单类型', 102, '已退款', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (18, 'chanpin_order_types', '订单类型', 103, '已发货', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (19, 'chanpin_order_types', '订单类型', 104, '已收货', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (20, 'chanpin_order_types', '订单类型', 105, '已评价', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (21, 'isdefault_types', '是否默认地址', 1, '否', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (22, 'isdefault_types', '是否默认地址', 2, '是', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (23, 'gonggao_types', '农资类型', 1, '农资类型1', NULL, NULL, '2024-04-23 21:26:02', 'upload/jishu1.jpg');
INSERT INTO `dictionary` VALUES (24, 'gonggao_types', '农资类型', 2, '农资类型2', NULL, NULL, '2024-04-23 21:26:02', 'upload/jishu1.jpg');
INSERT INTO `dictionary` VALUES (25, 'gonggao_types', '农资类型', 3, '农资类型3', NULL, NULL, '2024-04-23 21:26:02', 'upload/jishu1.jpg');
INSERT INTO `dictionary` VALUES (26, 'gonggao_types', '农资类型', 4, '农资类型4', NULL, NULL, '2024-04-23 21:26:02', 'upload/jishu1.jpg');
INSERT INTO `dictionary` VALUES (27, 'nongzi_order_types', '订单类型', 101, '已支付', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (28, 'nongzi_order_types', '订单类型', 102, '已退款', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (29, 'nongzi_order_types', '订单类型', 103, '已发货', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (30, 'nongzi_order_types', '订单类型', 104, '已收货', NULL, NULL, '2024-04-23 21:26:02', NULL);
INSERT INTO `dictionary` VALUES (31, 'gonggao_types', '农资类型', 5, 'xxxx', NULL, '', '2024-04-23 21:26:02', 'upload/1713983854838.jpeg');
INSERT INTO `dictionary` VALUES (32, 'gonggao_types', '农资类型', 6, 'xxxx45', NULL, '', '2024-04-23 21:26:02', 'upload/1714051801052.jpeg');
COMMIT;

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `forum_name` varchar(200) DEFAULT NULL COMMENT '帖子标题  Search111 ',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `zhongzhihu_id` int DEFAULT NULL COMMENT '种植户',
  `users_id` int DEFAULT NULL COMMENT '管理员',
  `forum_content` longtext COMMENT '发布内容',
  `super_ids` int DEFAULT NULL COMMENT '父id',
  `forum_state_types` int DEFAULT NULL COMMENT '帖子状态',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '发帖时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COMMENT='论坛';

-- ----------------------------
-- Records of forum
-- ----------------------------
BEGIN;
INSERT INTO `forum` VALUES (1, '帖子标题1', 2, NULL, NULL, '发布内容1', 229, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (2, '帖子标题2', 2, NULL, NULL, '发布内容2', 455, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (3, '帖子标题3', 2, NULL, NULL, '发布内容3', 80, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (4, '帖子标题4', 3, NULL, NULL, '发布内容4', 487, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (5, '帖子标题5', 3, NULL, NULL, '发布内容5', 237, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (6, '帖子标题6', 1, NULL, NULL, '发布内容6', 151, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (7, '帖子标题7', 1, NULL, NULL, '发布内容7', 12, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (8, '帖子标题8', 2, NULL, NULL, '发布内容8', 496, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (9, '帖子标题9', 3, NULL, NULL, '发布内容9', 282, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (10, '帖子标题10', 1, NULL, NULL, '发布内容10', 208, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (11, '帖子标题11', 2, NULL, NULL, '发布内容11', 309, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (12, '帖子标题12', 1, NULL, NULL, '发布内容12', 229, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (13, '帖子标题13', 2, NULL, NULL, '发布内容13', 380, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (14, '帖子标题14', 1, NULL, NULL, '发布内容14', 178, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 09:15:56');
INSERT INTO `forum` VALUES (15, '帖子14', 1, NULL, NULL, '<p>帖子111</p>', NULL, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 10:59:46');
INSERT INTO `forum` VALUES (17, NULL, NULL, 1, NULL, '45645641', 15, 2, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 11:01:43');
INSERT INTO `forum` VALUES (18, NULL, NULL, NULL, 1, '546', 15, 2, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2023-04-12 11:05:19');
INSERT INTO `forum` VALUES (19, '1112', 1, NULL, NULL, '<p>21367</p>', NULL, 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2024-04-21 22:12:24');
INSERT INTO `forum` VALUES (20, NULL, 1, NULL, NULL, '22', 19, 2, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2024-04-21 22:12:31');
INSERT INTO `forum` VALUES (21, NULL, 1, NULL, NULL, '1', 9, 2, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2024-04-22 20:44:12');
INSERT INTO `forum` VALUES (22, NULL, 1, NULL, NULL, '22234', 19, 2, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2024-04-23 00:48:38');
INSERT INTO `forum` VALUES (24, NULL, 1, NULL, NULL, 'ddsdc', 19, 2, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2024-04-23 21:24:50');
INSERT INTO `forum` VALUES (25, NULL, 1, NULL, NULL, '1123', 15, 2, '2024-04-23 21:26:02', '2024-04-23 21:26:02', '2024-04-25 21:27:36');
COMMIT;

-- ----------------------------
-- Table structure for forum_dian_zan
-- ----------------------------
DROP TABLE IF EXISTS `forum_dian_zan`;
CREATE TABLE `forum_dian_zan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `forum_id` int DEFAULT NULL,
  `yonghu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of forum_dian_zan
-- ----------------------------
BEGIN;
INSERT INTO `forum_dian_zan` VALUES (3, 19, 1);
COMMIT;

-- ----------------------------
-- Table structure for gonggao
-- ----------------------------
DROP TABLE IF EXISTS `gonggao`;
CREATE TABLE `gonggao` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `gonggao_name` varchar(200) DEFAULT NULL COMMENT '公告名称 Search111  ',
  `gonggao_photo` varchar(200) DEFAULT NULL COMMENT '公告图片 ',
  `gonggao_types` int NOT NULL COMMENT '公告类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '公告发布时间 ',
  `gonggao_content` text COMMENT '公告详情 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show1 show2 nameShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='公告';

-- ----------------------------
-- Records of gonggao
-- ----------------------------
BEGIN;
INSERT INTO `gonggao` VALUES (1, '农资名称1', 'upload/gonggao1.jpg', 2, '2024-04-23 21:26:02', '农资详情1', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (2, '农资名称2', 'upload/gonggao2.jpg', 1, '2024-04-23 21:26:02', '农资详情2', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (3, '农资名称3', 'upload/gonggao3.jpg', 1, '2024-04-23 21:26:02', '农资详情3', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (4, '农资名称4', 'upload/gonggao4.jpg', 2, '2024-04-23 21:26:02', '农资详情4', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (5, '农资名称5', 'upload/gonggao5.jpg', 2, '2024-04-23 21:26:02', '农资详情5', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (6, '农资名称6', 'upload/gonggao6.jpg', 1, '2024-04-23 21:26:02', '农资详情6', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (7, '农资名称7', 'upload/gonggao7.jpg', 2, '2024-04-23 21:26:02', '农资详情7', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (8, '农资名称8', 'upload/gonggao8.jpg', 2, '2024-04-23 21:26:02', '农资详情8', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (9, '农资名称9', 'upload/gonggao9.jpg', 1, '2024-04-23 21:26:02', '农资详情9', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (10, '农资名称10', 'upload/gonggao10.jpg', 2, '2024-04-23 21:26:02', '农资详情10', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (11, '农资名称11', 'upload/gonggao11.jpg', 2, '2024-04-23 21:26:02', '农资详情11', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (12, '农资名称12', 'upload/gonggao12.jpg', 1, '2024-04-23 21:26:02', '农资详情12', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (13, '农资名称13', 'upload/gonggao13.jpg', 2, '2024-04-23 21:26:02', '农资详情13', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (14, '农资名称14', 'upload/gonggao14.jpg', 1, '2024-04-23 21:26:02', '农资详情14', '2024-04-23 21:26:02');
INSERT INTO `gonggao` VALUES (15, '农资名称15', 'upload/1713878284020.jpeg', 2, '2024-04-23 21:26:02', '农资详情15', '2024-04-23 21:26:02');
COMMIT;

-- ----------------------------
-- Table structure for gonggao_pinglun
-- ----------------------------
DROP TABLE IF EXISTS `gonggao_pinglun`;
CREATE TABLE `gonggao_pinglun` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gonggao_id` int DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `yonghu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of gonggao_pinglun
-- ----------------------------
BEGIN;
INSERT INTO `gonggao_pinglun` VALUES (1, NULL, '123', 1);
INSERT INTO `gonggao_pinglun` VALUES (2, NULL, '112', 1);
INSERT INTO `gonggao_pinglun` VALUES (3, 14, '222', 1);
INSERT INTO `gonggao_pinglun` VALUES (4, 14, '444', 1);
INSERT INTO `gonggao_pinglun` VALUES (5, 14, '567', 1);
INSERT INTO `gonggao_pinglun` VALUES (6, 14, '呜呜呜', 1);
INSERT INTO `gonggao_pinglun` VALUES (7, 14, '1', 1);
INSERT INTO `gonggao_pinglun` VALUES (8, 14, '2', 1);
INSERT INTO `gonggao_pinglun` VALUES (9, 14, '233', 1);
INSERT INTO `gonggao_pinglun` VALUES (10, 14, '233', 1);
INSERT INTO `gonggao_pinglun` VALUES (11, 14, '1', 1);
INSERT INTO `gonggao_pinglun` VALUES (12, 14, '1', 1);
INSERT INTO `gonggao_pinglun` VALUES (13, 14, '1', 1);
INSERT INTO `gonggao_pinglun` VALUES (14, 14, '1', 1);
INSERT INTO `gonggao_pinglun` VALUES (15, 14, '3', 1);
INSERT INTO `gonggao_pinglun` VALUES (16, 14, '5', 1);
INSERT INTO `gonggao_pinglun` VALUES (17, 14, '9', 1);
INSERT INTO `gonggao_pinglun` VALUES (18, 14, '22', 1);
INSERT INTO `gonggao_pinglun` VALUES (19, 14, '2', 1);
INSERT INTO `gonggao_pinglun` VALUES (20, 14, '444', 1);
INSERT INTO `gonggao_pinglun` VALUES (21, 14, '22', 1);
INSERT INTO `gonggao_pinglun` VALUES (22, 14, 'wojhh', 1);
INSERT INTO `gonggao_pinglun` VALUES (23, 14, '22', 1);
INSERT INTO `gonggao_pinglun` VALUES (24, 14, '33', 1);
INSERT INTO `gonggao_pinglun` VALUES (25, 15, '1', 1);
INSERT INTO `gonggao_pinglun` VALUES (26, 15, 'xxx', 1);
COMMIT;

-- ----------------------------
-- Table structure for jishu
-- ----------------------------
DROP TABLE IF EXISTS `jishu`;
CREATE TABLE `jishu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `jishu_name` varchar(200) DEFAULT NULL COMMENT '农作物名称  Search111 ',
  `jishu_uuid_number` varchar(200) DEFAULT NULL COMMENT '农作物编号',
  `jishu_photo` varchar(200) DEFAULT NULL COMMENT '农作物照片',
  `jishu_types` int DEFAULT NULL COMMENT '农作物类型 Search111',
  `jishu_video` varchar(200) DEFAULT NULL COMMENT '农作物视频',
  `jishu_zuoyong` varchar(200) DEFAULT NULL COMMENT '作用',
  `jishu_candi` varchar(200) DEFAULT NULL COMMENT '产地',
  `jishu_wendu` varchar(200) DEFAULT NULL COMMENT '适宜温度 ',
  `jishu_shidu` varchar(200) DEFAULT NULL COMMENT '适宜湿度 ',
  `jishu_rizhao` varchar(200) DEFAULT NULL COMMENT '日照时长 ',
  `jishu_jiazhi` varchar(200) DEFAULT NULL COMMENT '营养价值 ',
  `jishu_content` longtext COMMENT '农作物介绍 ',
  `jishu_delete` int DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COMMENT='农业技术';

-- ----------------------------
-- Records of jishu
-- ----------------------------
BEGIN;
INSERT INTO `jishu` VALUES (1, '讲座和展会类型名称1', '1681262156393', 'upload/jishu1.jpg', 3, 'upload/video.mp4', '作用1', '产地1', '适宜温度1', '适宜湿度1', '日照时长1', '营养价值1', '农作物介绍1', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (2, '讲座和展会类型名称2', '1681262156422', 'upload/jishu2.jpg', 4, 'upload/video.mp4', '作用2', '产地2', '适宜温度2', '适宜湿度2', '日照时长2', '营养价值2', '农作物介绍2', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (3, '讲座和展会类型名称3', '1681262156402', 'upload/jishu3.jpg', 2, 'upload/video.mp4', '作用3', '产地3', '适宜温度3', '适宜湿度3', '日照时长3', '营养价值3', '农作物介绍3', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (4, '讲座和展会类型名称4', '1681262156422', 'upload/jishu4.jpg', 2, 'upload/video.mp4', '作用4', '产地4', '适宜温度4', '适宜湿度4', '日照时长4', '营养价值4', '农作物介绍4', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (5, '讲座和展会类型名称5', '1681262156386', 'upload/jishu5.jpg', 4, 'upload/video.mp4', '作用5', '产地5', '适宜温度5', '适宜湿度5', '日照时长5', '营养价值5', '农作物介绍5', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (6, '讲座和展会类型名称6', '1681262156426', 'upload/jishu6.jpg', 3, 'upload/video.mp4', '作用6', '产地6', '适宜温度6', '适宜湿度6', '日照时长6', '营养价值6', '农作物介绍6', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (7, '讲座和展会类型名称7', '1681262156338', 'upload/jishu7.jpg', 2, 'upload/video.mp4', '作用7', '产地7', '适宜温度7', '适宜湿度7', '日照时长7', '营养价值7', '农作物介绍7', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (8, '讲座和展会类型名称8', '1681262156350', 'upload/jishu8.jpg', 2, 'upload/video.mp4', '作用8', '产地8', '适宜温度8', '适宜湿度8', '日照时长8', '营养价值8', '农作物介绍8', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (9, '讲座和展会类型名称9', '1681262156368', 'upload/jishu9.jpg', 4, 'upload/video.mp4', '作用9', '产地9', '适宜温度9', '适宜湿度9', '日照时长9', '营养价值9', '农作物介绍9', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (10, '讲座和展会类型名称10', '1681262156386', 'upload/jishu10.jpg', 2, 'upload/video.mp4', '作用10', '产地10', '适宜温度10', '适宜湿度10', '日照时长10', '营养价值10', '农作物介绍10', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (11, '讲座和展会类型名称11', '1681262156339', 'upload/jishu11.jpg', 2, 'upload/video.mp4', '作用11', '产地11', '适宜温度11', '适宜湿度11', '日照时长11', '营养价值11', '农作物介绍11', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (12, '讲座和展会类型名称12', '1681262156368', 'upload/jishu12.jpg', 2, 'upload/video.mp4', '作用12', '产地12', '适宜温度12', '适宜湿度12', '日照时长12', '营养价值12', '农作物介绍12', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (13, '讲座和展会类型名称13', '1681262156378', 'upload/jishu13.jpg', 2, 'upload/video.mp4', '作用13', '产地13', '适宜温度13', '适宜湿度13', '日照时长13', '营养价值13', '农作物介绍13', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `jishu` VALUES (14, '讲座和展会类型名称14', '1681262156345', 'upload/jishu14.jpg', 3, 'upload/video.mp4', '作用14', '产地14', '适宜温度14', '适宜湿度14', '日照时长14', '营养价值14', '农作物介绍14', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
COMMIT;

-- ----------------------------
-- Table structure for jishu_study
-- ----------------------------
DROP TABLE IF EXISTS `jishu_study`;
CREATE TABLE `jishu_study` (
  `id` int NOT NULL AUTO_INCREMENT,
  `jishu_id` int DEFAULT NULL,
  `yonghu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of jishu_study
-- ----------------------------
BEGIN;
INSERT INTO `jishu_study` VALUES (1, 12, 1);
INSERT INTO `jishu_study` VALUES (2, 13, 1);
INSERT INTO `jishu_study` VALUES (3, 14, 1);
INSERT INTO `jishu_study` VALUES (4, 10, 1);
INSERT INTO `jishu_study` VALUES (5, 9, 1);
INSERT INTO `jishu_study` VALUES (6, 5, 1);
COMMIT;

-- ----------------------------
-- Table structure for nongzi
-- ----------------------------
DROP TABLE IF EXISTS `nongzi`;
CREATE TABLE `nongzi` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `nongzi_name` varchar(200) DEFAULT NULL COMMENT '农资名称  Search111 ',
  `nongzi_uuid_number` varchar(200) DEFAULT NULL COMMENT '农资编号',
  `nongzi_photo` varchar(200) DEFAULT NULL COMMENT '农资照片',
  `nongzi_types` int DEFAULT NULL COMMENT '农资类型 Search111',
  `nongzi_kucun_number` int DEFAULT NULL COMMENT '农资库存',
  `nongzi_new_money` decimal(10,2) DEFAULT NULL COMMENT '金额 ',
  `nongzi_clicknum` int DEFAULT NULL COMMENT '农资热度',
  `nongzi_content` longtext COMMENT '农资介绍 ',
  `nongzi_delete` int DEFAULT NULL COMMENT '逻辑删除',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='农资';

-- ----------------------------
-- Records of nongzi
-- ----------------------------
BEGIN;
INSERT INTO `nongzi` VALUES (1, '农资名称1', '1681262156364', 'upload/nongzi1.jpg', 3, 101, 78.82, 479, '农资介绍1', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (2, '农资名称2', '1681262156349', 'upload/nongzi2.jpg', 4, 102, 96.24, 358, '农资介绍2', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (3, '农资名称3', '1681262156373', 'upload/nongzi3.jpg', 1, 103, 342.03, 269, '农资介绍3', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (4, '农资名称4', '1681262156429', 'upload/nongzi4.jpg', 4, 104, 230.80, 280, '农资介绍4', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (5, '农资名称5', '1681262156347', 'upload/nongzi5.jpg', 4, 105, 264.16, 5, '农资介绍5', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (6, '农资名称6', '1681262156361', 'upload/nongzi6.jpg', 2, 106, 34.01, 497, '农资介绍6', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (7, '农资名称7', '1681262156375', 'upload/nongzi7.jpg', 3, 107, 112.41, 281, '农资介绍7', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (8, '农资名称8', '1681262156378', 'upload/nongzi8.jpg', 1, 108, 174.65, 450, '农资介绍8', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (9, '农资名称9', '1681262156417', 'upload/nongzi9.jpg', 4, 109, 211.83, 15, '农资介绍9', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (10, '农资名称10', '1681262156345', 'upload/nongzi10.jpg', 2, 1010, 74.04, 169, '农资介绍10', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (11, '农资名称11', '1681262156362', 'upload/nongzi11.jpg', 3, 1011, 29.35, 59, '农资介绍11', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (12, '农资名称12', '1681262156354', 'upload/nongzi12.jpg', 2, 1012, 32.02, 423, '农资介绍12', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (13, '农资名称13', '1681262156377', 'upload/nongzi13.jpg', 2, 1003, 414.40, 484, '农资介绍13', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (14, '农资名称14', '1681262156348', 'upload/nongzi14.jpg', 4, 1009, 272.31, 454, '农资介绍14', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi` VALUES (15, '钱', '1713876128158', 'upload/1713876135623.jpeg', 4, 100, 12.00, 1, '<p>休息休息<img src=\"upload/1713876156282.jpeg\"></p>', 1, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
COMMIT;

-- ----------------------------
-- Table structure for nongzi_order
-- ----------------------------
DROP TABLE IF EXISTS `nongzi_order`;
CREATE TABLE `nongzi_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nongzi_order_uuid_number` varchar(200) DEFAULT NULL COMMENT '订单编号 Search111 ',
  `nongzi_id` int DEFAULT NULL COMMENT '农资',
  `zhongzhihu_id` int DEFAULT NULL COMMENT '种植户',
  `buy_number` int DEFAULT NULL COMMENT '购买数量',
  `nongzi_order_dizhi` varchar(200) DEFAULT NULL COMMENT '地址',
  `nongzi_order_true_price` decimal(10,2) DEFAULT NULL COMMENT '实付价格',
  `nongzi_order_courier_name` varchar(200) DEFAULT NULL COMMENT '快递公司',
  `nongzi_order_courier_number` varchar(200) DEFAULT NULL COMMENT '快递单号',
  `nongzi_order_types` int DEFAULT NULL COMMENT '订单类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='农资订单';

-- ----------------------------
-- Records of nongzi_order
-- ----------------------------
BEGIN;
INSERT INTO `nongzi_order` VALUES (5, '1681268270225', 14, 1, 10, '加', 2723.10, '', '', 101, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `nongzi_order` VALUES (6, '1681268549619', 13, 1, 10, '填写住址', 4144.00, '1231', '1231', 104, '2024-04-23 21:26:02', '2024-04-23 21:26:02');
COMMIT;

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '儿童id',
  `username` varchar(100) NOT NULL COMMENT '儿童名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='token表';

-- ----------------------------
-- Records of token
-- ----------------------------
BEGIN;
INSERT INTO `token` VALUES (1, 1, 'a1', 'yonghu', '用户', 'fgs9hc1xdwyb34zyjgqtl4zc6jho8j68', '2024-04-23 21:26:02', '2024-04-26 22:26:17');
INSERT INTO `token` VALUES (2, 1, 'admin', 'users', '管理员', 'dco7ljp1xtusx4u2yfxjbc1y818fapa2', '2024-04-23 21:26:02', '2024-04-26 22:29:41');
INSERT INTO `token` VALUES (3, 1, 'a1', 'zhongzhihu', '种植户', 'but1go2dkm38u1uizpo7jo56sphhryny', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `token` VALUES (4, 2, 'a2', 'zhongzhihu', '种植户', '9t4l6jkzptdeyhtd7b6jfso6z6ryllfr', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
INSERT INTO `token` VALUES (5, 3, 'a3', 'zhongzhihu', '种植户', 'w583csmt940iskpq8pi1irjvxrfltmmx', '2024-04-23 21:26:02', '2024-04-23 21:26:02');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '儿童名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='管理员';

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'admin', 'admin', '管理员', '2023-04-24 09:15:29');
COMMIT;

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `yonghu_name` varchar(200) DEFAULT NULL COMMENT '用户姓名 Search111 ',
  `yonghu_photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `yonghu_phone` varchar(200) DEFAULT NULL COMMENT '用户手机号',
  `yonghu_id_number` varchar(200) DEFAULT NULL COMMENT '用户身份证号 ',
  `yonghu_email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `new_money` decimal(10,2) DEFAULT NULL COMMENT '余额 ',
  `sex_types` int DEFAULT NULL COMMENT '性别 Search111 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='用户';

-- ----------------------------
-- Records of yonghu
-- ----------------------------
BEGIN;
INSERT INTO `yonghu` VALUES (1, 'a1', '123456', '我是a1啊', 'upload/yonghu1.jpg', '17703786901', '410224199010102001', '1@qq.com', 140.45, 1, '2023-04-23 09:15:56');
INSERT INTO `yonghu` VALUES (2, 'a2', '123456', '用户姓名2', 'upload/yonghu2.jpg', '17703786902', '410224199010102002', '2@qq.com', 868.82, 2, '2023-04-22 09:15:56');
INSERT INTO `yonghu` VALUES (3, 'a3', '123456', '用户姓名3', 'upload/yonghu3.jpg', '17703786903', '410224199010102003', '3@qq.com', 908.30, 2, '2023-04-25 09:15:56');
COMMIT;

-- ----------------------------
-- Table structure for zhongzhihu
-- ----------------------------
DROP TABLE IF EXISTS `zhongzhihu`;
CREATE TABLE `zhongzhihu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `zhongzhihu_name` varchar(200) DEFAULT NULL COMMENT '种植户姓名 Search111 ',
  `zhongzhihu_photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `zhongzhihu_phone` varchar(200) DEFAULT NULL COMMENT '种植户手机号',
  `zhongzhihu_id_number` varchar(200) DEFAULT NULL COMMENT '种植户身份证号 ',
  `zhongzhihu_email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `new_money` decimal(10,2) DEFAULT NULL COMMENT '余额 ',
  `sex_types` int DEFAULT NULL COMMENT '性别 Search111 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='种植户';

-- ----------------------------
-- Records of zhongzhihu
-- ----------------------------
BEGIN;
INSERT INTO `zhongzhihu` VALUES (1, 'a1', '123456', '种植户姓名1', 'upload/zhongzhihu1.jpg', '17703786901', '410224199010102001', '1@qq.com', 344.67, 1, '2024-04-23 21:26:02');
INSERT INTO `zhongzhihu` VALUES (2, 'a2', '123456', '种植户姓名2', 'upload/zhongzhihu2.jpg', '17703786902', '410224199010102002', '2@qq.com', 722.88, 2, '2024-04-23 21:26:02');
INSERT INTO `zhongzhihu` VALUES (3, 'a3', '123456', '种植户姓名3', 'upload/zhongzhihu3.jpg', '17703786903', '410224199010102003', '3@qq.com', 418.39, 2, '2024-04-23 21:26:02');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
