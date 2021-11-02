/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 02/11/2021 17:58:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `version` bigint(20) NULL DEFAULT NULL COMMENT '版本',
  `deleted` int(20) NULL DEFAULT NULL COMMENT '是否已删除 1已删除 0正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone111', 28, 'test@test.com', 'F', 0, 1);
INSERT INTO `user` VALUES (2, 'JackTest', 12, 'test22@test.com', 'F', 1, 0);
INSERT INTO `user` VALUES (3, 'Tom', 28, 'test3@baomidou.com', 'F', 0, 0);
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', 'F', 0, 0);
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', 'F', 0, 0);
INSERT INTO `user` VALUES (1453922085209399298, 'Test', 24, 'test@test.com', 'F', 0, 0);
INSERT INTO `user` VALUES (1453922857414414337, 'TestList01', 21, 'list01@test.com', 'F', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
