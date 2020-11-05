/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : message

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-11-04 18:21:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageId` varchar(255) NOT NULL,
  `data` varchar(255) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:42');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:42');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:42');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:42');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:42');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:48');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:50');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:51');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:52');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:53');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:54');
INSERT INTO `message` VALUES ('11010751788931', 'hello world !', '2020-10-27 22:16:58');
INSERT INTO `message` VALUES ('11010751788933', 'hello world !', '2020-10-27 22:18:02');
INSERT INTO `message` VALUES ('11010751789000', 'hello world !', '2020-10-27 22:18:52');
