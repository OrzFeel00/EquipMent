/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : park

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2020-10-09 16:42:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'adm', '123', '2018-03-24', '123', '12323@11');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `user_id` int(32) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `admin_id` int(32) DEFAULT NULL,
  `admin_name` varchar(32) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `answerDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('5', '231312', '1', 'gaoc', '2018-03-27', '1', 'admin', '23131231', '2018-03-27');
INSERT INTO `message` VALUES ('7', 'mmp', '1', 'gaoc', '2018-03-27', '1', 'admin', 'mmp', '2018-03-27');
INSERT INTO `message` VALUES ('10', '爱编程', '1', 'gaoc', '2018-03-27', '1', 'admin', '牛逼', '2018-03-27');
INSERT INTO `message` VALUES ('11', '能不能便宜点', '8', 'hasak', '2018-04-05', null, null, null, null);
INSERT INTO `message` VALUES ('12', '天气真好', '9', '张三', '2018-04-05', '1', 'admin', '好', '2018-04-05');
INSERT INTO `message` VALUES ('13', '大师傅大师傅士大夫', '10', '李四', '2018-04-05', '1', 'admin', '3333', '2018-04-05');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `admin_id` int(32) DEFAULT NULL,
  `admin_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '停用通知公告', '555555', '2018-03-24', '1', 'admin');
INSERT INTO `notice` VALUES ('7', '北京直通车', '2313123萨达萨达是 爱的阿斯顿阿斯顿阿斯顿撒大苏打收到的', '2018-03-29', '1', 'admin');
INSERT INTO `notice` VALUES ('8', '高速封路', '啊实打实安德森是大神大神大大撒的啊收到阿三是', '2018-03-13', '1', 'admin');
INSERT INTO `notice` VALUES ('9', '车位暂停使用666', '通知u撒谎都系啊好的今属安徽觉得是吧记得把数据库的把就是看', '2018-04-05', '1', 'admin');
INSERT INTO `notice` VALUES ('10', '555', '4444', '2018-04-05', '1', 'admin');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_id` int(32) DEFAULT NULL,
  `park_id` int(32) DEFAULT NULL,
  `plate_num` varchar(32) DEFAULT NULL,
  `orderCreateDate` timestamp NULL DEFAULT NULL,
  `unloadCreateDate` timestamp NULL DEFAULT NULL,
  `unloadDisDate` timestamp NULL DEFAULT NULL,
  `total` double(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '1', '1', '2020-10-03 14:30:52', '2020-10-03 14:30:54', '2020-10-03 14:30:58', '3');
INSERT INTO `orders` VALUES ('2', '2', '2', '2', '2020-10-03 14:31:17', '2020-10-03 14:31:18', '2020-10-03 14:31:20', '2');
INSERT INTO `orders` VALUES ('3', '13', '4', '123', '2020-10-07 01:58:07', '2020-10-24 01:58:10', '2020-10-22 01:58:14', '5');
INSERT INTO `orders` VALUES ('4', '16', '18', '粤12345678', '2020-10-13 10:43:28', '2020-10-20 10:43:31', '2020-10-27 10:43:35', '1');
INSERT INTO `orders` VALUES ('5', '17', '10', '1234', '2020-09-30 10:51:08', '2020-10-22 10:51:11', '2020-10-07 10:51:14', '2');

-- ----------------------------
-- Table structure for park
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `price` double(8,2) DEFAULT NULL,
  `status` int(16) DEFAULT '0',
  `size` varchar(33) DEFAULT NULL,
  `isLong` int(32) DEFAULT NULL,
  `garage` varchar(255) DEFAULT NULL,
  `num_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of park
-- ----------------------------
INSERT INTO `park` VALUES ('4', '213.00', '1', '2', null, '2', '4');
INSERT INTO `park` VALUES ('8', '112.00', '1', '3', null, '2', '8');
INSERT INTO `park` VALUES ('9', '88.00', '1', '2', null, '2', '9');
INSERT INTO `park` VALUES ('10', '998.00', '0', '1', null, '1', '10');
INSERT INTO `park` VALUES ('11', '100.00', '1', '3', null, '3', '11');
INSERT INTO `park` VALUES ('12', '100.00', '0', '2', null, '4', '12');
INSERT INTO `park` VALUES ('13', '90.00', '0', '2', null, '1', '13');
INSERT INTO `park` VALUES ('14', '77.00', '0', '1', null, '4', '14');
INSERT INTO `park` VALUES ('15', '100.00', '0', '1', null, '88', '199');
INSERT INTO `park` VALUES ('16', '12.00', '0', '1', null, '2', '16');
INSERT INTO `park` VALUES ('17', '12.00', '0', '1', null, '2', '17');
INSERT INTO `park` VALUES ('18', '12.00', '0', '1', null, '2', '18');
INSERT INTO `park` VALUES ('19', '12.00', '0', '3', null, '2', '19');
INSERT INTO `park` VALUES ('20', '12.00', '0', '2', null, '2', '20');
INSERT INTO `park` VALUES ('45', '79.50', '0', '2', null, '6', '15');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `plate_num` varchar(32) DEFAULT NULL,
  `stauts` int(2) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `money` double(32,0) DEFAULT NULL,
  `head` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8', 'hasak', '12345', '13199889098', '蒙K98981', '1', '2018-04-05', '420', null, null);
INSERT INTO `user` VALUES ('9', '张三', '11111', '13111111111', '蒙A11020', '0', '2018-04-05', '10', null, null);
INSERT INTO `user` VALUES ('10', '李四', '12345', '13111112222', '蒙A90922', '0', '2018-04-05', '10', null, null);
INSERT INTO `user` VALUES ('12', '123123', '123', 'asd', 'niqwe', '1', '2020-09-27', '123', '123', '632360579@qq.com');
INSERT INTO `user` VALUES ('13', '123', '123', '123467', '123', '1', '2020-09-27', '123', '123', '232423423@qq.com');
INSERT INTO `user` VALUES ('14', 'lkll', '1234567', '111', 'niqwe', '1', '2020-09-30', '123', '123', '232423s@qq');
INSERT INTO `user` VALUES ('15', '亏', '123', '15095897048', 'niqwe', '1', '2020-10-03', '123', '123', '123123@qq.com');
INSERT INTO `user` VALUES ('16', '郭婷', '1', '123467', '粤12345678', '1', '2020-10-07', '144389', '123', '232423423@qq.com');
INSERT INTO `user` VALUES ('17', '1234', '1234', '123467', '1234', '1', '2020-10-07', '123', '123', '1234567@qq.com');
INSERT INTO `user` VALUES ('18', '12345', '123', '123467', 'niqwe', '1', '2020-10-07', '123', '123', '1234567@qq.com');
INSERT INTO `user` VALUES ('19', '1234567', '123', '123467', 'niqwe', '1', '2020-10-07', '123', '123', '1234567@qq.com');
INSERT INTO `user` VALUES ('20', '12345678', '123', '123467', 'niqwe', '1', '2020-10-07', '123', '123', '1234567@qq.com');
INSERT INTO `user` VALUES ('21', '15', '15', '1515415', 'niqwe', '1', '2020-10-08', '123', '123', '141414@ccosas');
INSERT INTO `user` VALUES ('22', '杜杜', '123', '123467', 'niqwe', '1', '2020-10-08', '123', '123', '123@qq.com');
