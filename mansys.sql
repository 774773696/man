/*
Navicat MySQL Data Transfer

Source Server         : window-mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : mansys

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-10-03 09:45:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_brand
-- ----------------------------
DROP TABLE IF EXISTS `m_brand`;
CREATE TABLE `m_brand` (
  `bid` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_brand
-- ----------------------------

-- ----------------------------
-- Table structure for m_consignee
-- ----------------------------
DROP TABLE IF EXISTS `m_consignee`;
CREATE TABLE `m_consignee` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收获人id',
  `consignee_name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `consignee_phone` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `consignee_address` varchar(255) DEFAULT NULL COMMENT '收货人地址',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_consignee
-- ----------------------------

-- ----------------------------
-- Table structure for m_goods
-- ----------------------------
DROP TABLE IF EXISTS `m_goods`;
CREATE TABLE `m_goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `goods_store` int(11) DEFAULT NULL COMMENT '商品库存',
  `goodstype_id` int(11) DEFAULT NULL COMMENT '商品类型id',
  `img_id` int(11) DEFAULT NULL COMMENT '商品图片id',
  `create_time` datetime DEFAULT NULL COMMENT '商品上架时间',
  `size_id` int(11) DEFAULT NULL COMMENT '商品尺寸id',
  `goods_color` varchar(255) DEFAULT NULL COMMENT '商品颜色',
  `goods_out` int(11) DEFAULT NULL COMMENT '已售商品',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_goods
-- ----------------------------
INSERT INTO `m_goods` VALUES ('1', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for m_goodstype
-- ----------------------------
DROP TABLE IF EXISTS `m_goodstype`;
CREATE TABLE `m_goodstype` (
  `goodstype_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类型id',
  `goodstype_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `bid` int(11) DEFAULT NULL COMMENT '品牌id',
  PRIMARY KEY (`goodstype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_goodstype
-- ----------------------------

-- ----------------------------
-- Table structure for m_imgs
-- ----------------------------
DROP TABLE IF EXISTS `m_imgs`;
CREATE TABLE `m_imgs` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `gid` int(11) DEFAULT NULL COMMENT '商品id',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片链接地址',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_imgs
-- ----------------------------

-- ----------------------------
-- Table structure for m_merchant
-- ----------------------------
DROP TABLE IF EXISTS `m_merchant`;
CREATE TABLE `m_merchant` (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家id',
  `merchant_name` varchar(255) DEFAULT NULL COMMENT '商家名称',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_merchant
-- ----------------------------

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq',
  `wechat` varchar(255) DEFAULT NULL COMMENT '微信',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `username` varchar(255) DEFAULT NULL COMMENT '昵称',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `img_id` int(11) DEFAULT NULL COMMENT '头像id',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of m_user
-- ----------------------------
