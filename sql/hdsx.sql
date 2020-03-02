/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : hdsx

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 02/27/2020 19:53:30 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_image`
-- ----------------------------
DROP TABLE IF EXISTS `tb_image`;
CREATE TABLE `tb_image` (
  `id` varchar(64) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `mapperid` varchar(64) DEFAULT NULL,
  `imagename` varchar(1024) DEFAULT NULL,
  `imageurl` varchar(1024) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` varchar(64) NOT NULL,
  `productid` varchar(64) DEFAULT NULL COMMENT '商品表的ID',
  `orderstate` int(11) DEFAULT NULL COMMENT '订单状态0未付款、1已付款、2取消订单、3删除订单、4发货、5订单完成（简单场景不考虑其他复杂的状态）',
  `userid` varchar(64) DEFAULT NULL COMMENT '购买者ID',
  `ordernum` int(11) DEFAULT NULL COMMENT '购买商品的数量',
  `orderprice` decimal(10,0) DEFAULT NULL COMMENT '购买商品的总价',
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_order`
-- ----------------------------
BEGIN;
INSERT INTO `tb_order` VALUES ('12121414124', '228630831972863', '0', '1', '12', '10', '2020-02-26 21:59:18', '2020-02-26 21:59:18');
COMMIT;

-- ----------------------------
--  Table structure for `tb_product`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `id` bigint(20) NOT NULL COMMENT '商品id，同时也是商品编号',
  `title` varchar(100) NOT NULL COMMENT '商品标题',
  `price` decimal(20,0) NOT NULL COMMENT '商品价格，单位为：分',
  `num` int(10) NOT NULL COMMENT '库存数量',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '商品状态，1-正常，2-下架，3-删除',
  `created` datetime NOT NULL COMMENT '创建时间',
  `updated` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `status` (`status`),
  KEY `updated` (`updated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
--  Records of `tb_product`
-- ----------------------------
BEGIN;
INSERT INTO `tb_product` VALUES ('148630639229938', 'Apple iPhone 7 (A1660) 32G 黑色 移动联通电信4G手机', '519900', '1000', '1', '2017-02-05 22:53:12', '2017-02-05 22:53:12'), ('148630831972863', 'Apple MacBook Pro 15.4英寸笔记本电脑 深空灰色（Multi-Touch Bar/Core i7/16GB/512GB MLH42CH/A）', '2148800', '980', '1', '2017-02-05 23:25:20', '2020-02-25 19:56:54'), ('228630831972863', '火花15.4英寸笔记本电脑 深空灰色（Multi-Touch Bar/Core i7/16GB/512GB MLH42CH/A）', '2800', '988', '1', '2020-02-25 19:59:07', '2020-02-26 21:59:18');
COMMIT;

-- ----------------------------
--  Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(64) NOT NULL,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `state` int(11) DEFAULT '0' COMMENT '用户的状态0是正常，1是禁用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Records of `tb_user`
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES ('10', 'zhangsan2', '195d91be1e3ba6f1c857d46f24c5a454', '13333333334', null, '2015-04-07 10:33:37', '2015-04-07 10:33:37', '0'), ('11', 'zhangsan3', '195d91be1e3ba6f1c857d46f24c5a454', '13333333335', null, '2015-04-07 10:35:57', '2015-04-07 10:35:57', '0'), ('12', 'zhangsan5', '195d91be1e3ba6f1c857d46f24c5a454', '13333333336', null, '2015-04-07 10:46:19', '2015-04-07 10:46:19', '0'), ('7', 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '13488888888', 'aa@a', '2015-04-06 17:03:55', '2015-04-06 17:03:55', '0'), ('7ysauyiuwyeiwe82173972913', 'lcc', 'e10adc3949ba59abbe56e057f20f883e', '13433888888', 'aa@a', '2020-02-23 19:54:31', '2020-02-23 19:54:31', '0'), ('9', 'zhangsan1', 'e10adc3949ba59abbe56e057f20f883e', '13333333333', null, '2015-04-07 10:32:08', '2015-04-07 10:32:08', '0');
COMMIT;

-- ----------------------------
--  Table structure for `undo_log`
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
