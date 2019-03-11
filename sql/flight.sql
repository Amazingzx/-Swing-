/*
Navicat MySQL Data Transfer

Source Server         : MyConn
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : fly_tickets

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-03-11 21:07:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for flight
-- ----------------------------
DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `fid` varchar(11) COLLATE utf8_bin NOT NULL,
  `fBegin` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `fEnd` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `sTime` datetime DEFAULT NULL,
  `eTime` datetime DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of flight
-- ----------------------------
INSERT INTO `flight` VALUES ('c001', '北京', '长沙', '2019-01-08 09:57:00', '2019-01-08 11:50:00', '1001.2');
INSERT INTO `flight` VALUES ('c002', '北京', '上海', '2019-03-02 10:56:00', '2019-03-02 13:20:00', '982');
INSERT INTO `flight` VALUES ('c003', '上海', '西安', '2018-12-29 17:50:00', '2018-12-29 19:50:00', '125');
INSERT INTO `flight` VALUES ('c004', '上海', '北京', '2019-01-17 05:10:00', '2019-01-17 08:09:00', '651');
INSERT INTO `flight` VALUES ('c005', '北京', '济南', '2018-12-26 14:12:00', '2018-12-26 16:19:00', '654.2');
INSERT INTO `flight` VALUES ('c006', '云南', '武汉', '2019-04-16 08:06:00', '2019-04-16 10:54:00', '782');
INSERT INTO `flight` VALUES ('c007', '云南', '西安', '2019-01-23 10:00:00', '2019-01-23 12:00:00', '124');
INSERT INTO `flight` VALUES ('c008', '西安', '云南', '2019-01-22 03:05:00', '2019-01-22 05:35:00', '254');
INSERT INTO `flight` VALUES ('c009', '长沙', '长春', '2019-03-12 19:54:00', '2019-03-12 21:14:00', '365');
INSERT INTO `flight` VALUES ('c010', '成都', '郑州', '2019-05-16 16:26:00', '2019-05-16 18:29:00', '456.2');
INSERT INTO `flight` VALUES ('c011', '西安', '沈阳', '2019-02-13 08:09:00', '2019-02-13 10:20:00', '154.8');
INSERT INTO `flight` VALUES ('c012', '四川', '青岛', '2019-02-06 21:45:00', '2019-02-06 23:12:00', '458');
INSERT INTO `flight` VALUES ('c013', '张家界', '南昌', '2019-02-20 17:57:00', '2019-02-20 19:00:00', '1542');
INSERT INTO `flight` VALUES ('c014', '太原', '无锡', '2019-01-05 18:18:00', '2019-01-05 20:20:00', '564');
INSERT INTO `flight` VALUES ('c015', '深圳', '西安', '2019-02-15 17:00:00', '2019-02-15 19:00:00', '987');
