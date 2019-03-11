/*
Navicat MySQL Data Transfer

Source Server         : MyConn
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : fly_tickets

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-03-11 21:08:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(11) COLLATE utf8_bin NOT NULL,
  `uname` varchar(31) COLLATE utf8_bin NOT NULL,
  `psd` varchar(31) COLLATE utf8_bin NOT NULL,
  `sex` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `adress` varchar(31) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('a001', '小明', '123', '男', '20', '湖南长沙');
INSERT INTO `user` VALUES ('a002', '小白', '456', '女', '19', '陕西西安');
INSERT INTO `user` VALUES ('a003', '小王', '123', '男', '45', '北京');
INSERT INTO `user` VALUES ('a004', '张三', 'aaa', '男', '45', '江苏南京');
INSERT INTO `user` VALUES ('a005', 'aaa', 'aaa', '男', '12', '南京');
INSERT INTO `user` VALUES ('a006', '李强', '123', '男', '20', '西安');
INSERT INTO `user` VALUES ('a007', '王五', '123', '男', '25', '西安');
