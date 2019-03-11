/*
Navicat MySQL Data Transfer

Source Server         : MyConn
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : fly_tickets

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-03-11 21:07:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `oTime` datetime DEFAULT NULL,
  `uno` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `fno` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fno` (`fno`),
  KEY `uno` (`uno`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`fno`) REFERENCES `flight` (`fid`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`uno`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2018-12-28 17:04:08', 'a005', 'c001');
INSERT INTO `orders` VALUES ('2', '2019-01-19 21:26:58', 'a007', 'c001');
