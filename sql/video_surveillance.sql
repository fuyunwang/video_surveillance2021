/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : chuoyue_cloud

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 04/10/2020 12:44:25
*/

DROP DATABASE IF EXISTS `video_surveillance`;
create database `video_surveillance` default character set utf8mb4 collate utf8mb4_general_ci;

USE `video_surveillance`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `DEPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级部门ID',
  `DEPT_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `ORDER_NUM` double(20, 0) NULL DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`DEPT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES (1, 0, '开发部', 1, '2020-01-04 12:42:26', '2020-01-05 12:08:27');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `MENU_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单/按钮名称',
  `PATH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应路由path',
  `COMPONENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应路由组件component',
  `PERMS` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `ICON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `TYPE` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型 0菜单 1按钮',
  `ORDER_NUM` double(20, 0) NULL DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, 0, '系统管理', '/system', 'Layout', NULL, 'el-icon-set-up', '0', 1, '2020-10-04 16:39:07', '2020-10-04 16:19:04');
INSERT INTO `t_menu` VALUES (2, 1, '用户管理', '/system/user', 'febs/system/user/Index', 'user:view', '', '0', 1, '2020-10-04 16:47:13', '2020-10-04 06:45:55');
INSERT INTO `t_menu` VALUES (3, 2, '新增用户', '', '', 'user:add', NULL, '1', NULL, '2020-10-04 17:02:58', '2020-10-04 12:42:26');
INSERT INTO `t_menu` VALUES (4, 2, '修改用户', '', '', 'user:update', NULL, '1', NULL, '2020-10-04 17:04:07', '2020-10-04 12:42:28');
INSERT INTO `t_menu` VALUES (5, 2, '删除用户', '', '', 'user:delete', NULL, '1', NULL, '2020-10-04 17:04:58', '2020-10-04 12:42:31');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `REMARK` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员', '管理员', '2020-10-04 16:23:11', '2020-10-04 14:38:59');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `ROLE_ID` bigint(20) NOT NULL,
  `MENU_ID` bigint(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES (1, 1);
INSERT INTO `t_role_menu` VALUES (1, 2);
INSERT INTO `t_role_menu` VALUES (1, 3);
INSERT INTO `t_role_menu` VALUES (1, 4);
INSERT INTO `t_role_menu` VALUES (1, 5);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `DEPT_ID` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `EMAIL` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `STATUS` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态 0锁定 1有效',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `LAST_LOGIN_TIME` datetime(0) NULL DEFAULT NULL COMMENT '最近访问时间',
  `SSEX` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `AVATAR` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `DESCRIPTION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'Gopher', '$2a$10$Yyst2M8VECtVCIOw8UEXRO9zZ4ooPR7kWRTAsya9H.ALJqdh6rUhy', 1, 'beautifulsoup@163.com', '19854157220', '1', '2020-10-04 20:39:22', '2020-10-04 10:18:36', '2020-10-04 15:57:00', '0', 'default.jpg', '凌波绰约无尘俗,不羡群芳自展颜');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1);

-- ----------------------------
-- Table structure for tb_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu_info`;
CREATE TABLE `tb_menu_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `menu_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单路径',
  `orders` int(11) NULL DEFAULT 1 COMMENT '顺序',
  `parent_id` int(11) NULL DEFAULT 0 COMMENT '父级id,为0表示为根父级',
  `auth_type` int(11) NULL DEFAULT 3 COMMENT '权限类型,0是只有超管才能看到,1是高管可以看到,2是中管可以看到,3是所有人都可以看到',
  `component` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `redirect` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu_info
-- ----------------------------
INSERT INTO `tb_menu_info` VALUES (1, '首页展示', '/system/portal', 1, 0, 1, 'system/portal/index', 'noredirect');
INSERT INTO `tb_menu_info` VALUES (2, '报警配置', '/alert', 5, 0, 1, 'Layout', 'system/alert/index');
INSERT INTO `tb_menu_info` VALUES (3, '配置配置', '/settings', 4, 0, 1, 'Layout', 'noredirect');
INSERT INTO `tb_menu_info` VALUES (4, '数据统计', '/system', 7, 0, 1, 'Layout', 'noredirect');
INSERT INTO `tb_menu_info` VALUES (10, '数据报表3', 'chart/first', 3, 4, 3, 'system/chart/first/index', 'noredirect');
INSERT INTO `tb_menu_info` VALUES (11, '数据报表1', 'chart/second', 1, 4, 3, 'system/chart/second/index', 'noredirect');
INSERT INTO `tb_menu_info` VALUES (12, '数据报表2', 'chart/third', 2, 4, 3, 'system/chart/third/index', 'noredirect');
INSERT INTO `tb_menu_info` VALUES (13, '报警管理', 'alert', 1, 2, 3, 'system/alert/index', '');
INSERT INTO `tb_menu_info` VALUES (14, '配置管理', 'settings', 1, 3, 3, 'system/settings/index', '');
INSERT INTO `tb_menu_info` VALUES (15, '用户模块', '/user', 2, 0, 3, 'Layout', '');
INSERT INTO `tb_menu_info` VALUES (16, '用户管理', 'user', 1, 15, 3, 'system/user/index', '');
INSERT INTO `tb_menu_info` VALUES (19, '部门模块', '/department', 3, 0, 3, 'Layout', '');
INSERT INTO `tb_menu_info` VALUES (20, '部门管理', 'department', 1, 19, 3, 'system/department/index', '');
INSERT INTO `tb_menu_info` VALUES (21, '数据报表4', 'chart/fourth', 4, 4, 3, 'system/chart/fourth/index', '');
INSERT INTO `tb_menu_info` VALUES (22, '直播检测', '/live', 6, 0, 3, 'Layout', '');
INSERT INTO `tb_menu_info` VALUES (23, '直播检测', 'live', 1, 22, 3, 'system/live/index', '');

-- ----------------------------
-- Table structure for tb_menu_info_meta
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu_info_meta`;
CREATE TABLE `tb_menu_info_meta`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu_info_meta
-- ----------------------------
INSERT INTO `tb_menu_info_meta` VALUES (1, '算法配置', 'edit', 14);
INSERT INTO `tb_menu_info_meta` VALUES (2, '报警管理', 'documentation', 13);
INSERT INTO `tb_menu_info_meta` VALUES (3, '数据报表1', 'table', 11);
INSERT INTO `tb_menu_info_meta` VALUES (4, '数据报表2', 'table', 12);
INSERT INTO `tb_menu_info_meta` VALUES (5, '数据报表3', 'table', 10);
INSERT INTO `tb_menu_info_meta` VALUES (6, '数据统计', 'chart', 4);
INSERT INTO `tb_menu_info_meta` VALUES (7, '用户管理', 'user', 16);
INSERT INTO `tb_menu_info_meta` VALUES (9, '部门管理', 'dashboard', 20);
INSERT INTO `tb_menu_info_meta` VALUES (10, '数据报表4', 'table', 21);
INSERT INTO `tb_menu_info_meta` VALUES (11, '直播检测', 'component', 23);

-- ----------------------------
-- Table structure for zipkin_annotations
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_annotations`;
CREATE TABLE `zipkin_annotations`  (
  `trace_id_high` bigint(20) NOT NULL DEFAULT 0 COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  `span_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.id',
  `a_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  `a_value` blob NULL COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  `a_type` int(11) NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  `a_timestamp` bigint(20) NULL DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  `endpoint_ipv4` int(11) NULL DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_ipv6` binary(16) NULL DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  `endpoint_port` smallint(6) NULL DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE INDEX `trace_id_high`(`trace_id_high`, `trace_id`, `span_id`, `a_key`, `a_timestamp`) USING BTREE COMMENT 'Ignore insert on duplicate',
  INDEX `trace_id_high_2`(`trace_id_high`, `trace_id`, `span_id`) USING BTREE COMMENT 'for joining with zipkin_spans',
  INDEX `trace_id_high_3`(`trace_id_high`, `trace_id`) USING BTREE COMMENT 'for getTraces/ByIds',
  INDEX `endpoint_service_name`(`endpoint_service_name`) USING BTREE COMMENT 'for getTraces and getServiceNames',
  INDEX `a_type`(`a_type`) USING BTREE COMMENT 'for getTraces and autocomplete values',
  INDEX `a_key`(`a_key`) USING BTREE COMMENT 'for getTraces and autocomplete values',
  INDEX `trace_id`(`trace_id`, `span_id`, `a_key`) USING BTREE COMMENT 'for dependencies job'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compressed;

-- ----------------------------
-- Records of zipkin_annotations
-- ----------------------------

-- ----------------------------
-- Table structure for zipkin_dependencies
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_dependencies`;
CREATE TABLE `zipkin_dependencies`  (
  `day` date NOT NULL,
  `parent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `child` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `call_count` bigint(20) NULL DEFAULT NULL,
  `error_count` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`day`, `parent`, `child`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compressed;

-- ----------------------------
-- Records of zipkin_dependencies
-- ----------------------------

-- ----------------------------
-- Table structure for zipkin_spans
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_spans`;
CREATE TABLE `zipkin_spans`  (
  `trace_id_high` bigint(20) NOT NULL DEFAULT 0 COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remote_service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `debug` bit(1) NULL DEFAULT NULL,
  `start_ts` bigint(20) NULL DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  `duration` bigint(20) NULL DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  PRIMARY KEY (`trace_id_high`, `trace_id`, `id`) USING BTREE,
  INDEX `trace_id_high`(`trace_id_high`, `trace_id`) USING BTREE COMMENT 'for getTracesByIds',
  INDEX `name`(`name`) USING BTREE COMMENT 'for getTraces and getSpanNames',
  INDEX `remote_service_name`(`remote_service_name`) USING BTREE COMMENT 'for getTraces and getRemoteServiceNames',
  INDEX `start_ts`(`start_ts`) USING BTREE COMMENT 'for getTraces ordering and range'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compressed;

-- ----------------------------
-- Records of zipkin_spans
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
