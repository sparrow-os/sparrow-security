/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : sparrow

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 05/11/2022 22:49:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int unsigned NOT NULL AUTO_INCREMENT,
  `forum_code` varchar(32) NOT NULL DEFAULT '' COMMENT 'forum code',
  `editor` varchar(32) NOT NULL DEFAULT '' COMMENT 'editor',
  `title` varchar(256) NOT NULL DEFAULT '' COMMENT 'title',
  `brief` varchar(512) NOT NULL DEFAULT '' COMMENT 'brief',
  `content` text COMMENT 'content',
  `click_times` int unsigned NOT NULL DEFAULT '0' COMMENT 'click times',
  `create_time` bigint NOT NULL DEFAULT '0' COMMENT 'create time',
  `update_time` bigint NOT NULL DEFAULT '0' COMMENT 'update time',
  `create_user_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'create user id',
  `create_user_name` varchar(64) NOT NULL DEFAULT '' COMMENT 'create user name',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'status -> STATUS_RECORD enum',
  `url` varchar(256) NOT NULL DEFAULT '' COMMENT 'link',
  `sort` int NOT NULL DEFAULT '0' COMMENT 'sort',
  `page_size` int NOT NULL DEFAULT '0' COMMENT 'page size',
  `type` varchar(16) NOT NULL DEFAULT '' COMMENT 'type',
  `cover` varchar(256) NOT NULL DEFAULT '' COMMENT 'cover',
  `album_id` int NOT NULL DEFAULT '-1' COMMENT '-1:正常,非专辑\n0:专辑\n>0专辑子页面',
  `keywords` varchar(64) NOT NULL DEFAULT '' COMMENT 'keywords',
  `remark` text NOT NULL COMMENT 'remark',
  `only_show_in_self_forum` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'show in self forum',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='article';

-- ----------------------------
-- Table structure for attach
-- ----------------------------
DROP TABLE IF EXISTS `attach`;
CREATE TABLE `attach` (
  `id` int NOT NULL AUTO_INCREMENT,
  `file_id` varchar(64) DEFAULT NULL,
  `client_file_name` varchar(256) NOT NULL DEFAULT '',
  `download_times` int unsigned NOT NULL DEFAULT '0',
  `content_length` int unsigned NOT NULL DEFAULT '0',
  `content_type` varchar(256) NOT NULL DEFAULT '',
  `read_level` int unsigned DEFAULT '0',
  `create_time` bigint NOT NULL DEFAULT '0',
  `create_user_id` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='attach';

-- ----------------------------
-- Table structure for code
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT 'NAME',
  `parent_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'parent id',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT 'CODE',
  `value` varchar(128) NOT NULL DEFAULT '' COMMENT 'VALUE',
  `logo` varchar(256) NOT NULL DEFAULT '' COMMENT 'LOGO',
  `url` varchar(256) NOT NULL DEFAULT '' COMMENT 'URL',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'status -> StatusRecord enum',
  `remark` varchar(1024) NOT NULL DEFAULT '' COMMENT 'remark',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT 'sort',
  `create_time` bigint NOT NULL DEFAULT '0' COMMENT 'create time',
  `update_time` bigint NOT NULL DEFAULT '0' COMMENT 'update time',
  `create_user_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'create user id',
  `update_user_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'update user id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='code';

-- ----------------------------
-- Table structure for event_0
-- ----------------------------
DROP TABLE IF EXISTS `event_0`;
CREATE TABLE `event_0` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_1
-- ----------------------------
DROP TABLE IF EXISTS `event_1`;
CREATE TABLE `event_1` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_10
-- ----------------------------
DROP TABLE IF EXISTS `event_10`;
CREATE TABLE `event_10` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_11
-- ----------------------------
DROP TABLE IF EXISTS `event_11`;
CREATE TABLE `event_11` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_12
-- ----------------------------
DROP TABLE IF EXISTS `event_12`;
CREATE TABLE `event_12` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_13
-- ----------------------------
DROP TABLE IF EXISTS `event_13`;
CREATE TABLE `event_13` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_14
-- ----------------------------
DROP TABLE IF EXISTS `event_14`;
CREATE TABLE `event_14` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_15
-- ----------------------------
DROP TABLE IF EXISTS `event_15`;
CREATE TABLE `event_15` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_16
-- ----------------------------
DROP TABLE IF EXISTS `event_16`;
CREATE TABLE `event_16` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_17
-- ----------------------------
DROP TABLE IF EXISTS `event_17`;
CREATE TABLE `event_17` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_18
-- ----------------------------
DROP TABLE IF EXISTS `event_18`;
CREATE TABLE `event_18` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_19
-- ----------------------------
DROP TABLE IF EXISTS `event_19`;
CREATE TABLE `event_19` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_1_admin
-- ----------------------------
DROP TABLE IF EXISTS `event_1_admin`;
CREATE TABLE `event_1_admin` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_1_common
-- ----------------------------
DROP TABLE IF EXISTS `event_1_common`;
CREATE TABLE `event_1_common` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_2
-- ----------------------------
DROP TABLE IF EXISTS `event_2`;
CREATE TABLE `event_2` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_3
-- ----------------------------
DROP TABLE IF EXISTS `event_3`;
CREATE TABLE `event_3` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_4
-- ----------------------------
DROP TABLE IF EXISTS `event_4`;
CREATE TABLE `event_4` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_5
-- ----------------------------
DROP TABLE IF EXISTS `event_5`;
CREATE TABLE `event_5` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_6
-- ----------------------------
DROP TABLE IF EXISTS `event_6`;
CREATE TABLE `event_6` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_7
-- ----------------------------
DROP TABLE IF EXISTS `event_7`;
CREATE TABLE `event_7` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_8
-- ----------------------------
DROP TABLE IF EXISTS `event_8`;
CREATE TABLE `event_8` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for event_9
-- ----------------------------
DROP TABLE IF EXISTS `event_9`;
CREATE TABLE `event_9` (
  `event_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'user type',
  `user_id` int unsigned NOT NULL COMMENT 'user id',
  `business_type` varchar(64) NOT NULL DEFAULT '' COMMENT 'business typ',
  `business_id` int unsigned NOT NULL COMMENT 'business id',
  `times` int NOT NULL DEFAULT '0' COMMENT 'times',
  `channel` varchar(256) NOT NULL DEFAULT '' COMMENT 'channel',
  `ip` char(16) NOT NULL DEFAULT '' COMMENT 'ip',
  `device` varchar(32) NOT NULL DEFAULT '' COMMENT 'device',
  `device_id` varchar(64) NOT NULL DEFAULT '' COMMENT 'device unique id',
  `device_model` varchar(16) NOT NULL DEFAULT '' COMMENT 'device model 5s e.g ...',
  `event` varchar(64) NOT NULL DEFAULT '' COMMENT 'event type',
  `content` varchar(512) NOT NULL DEFAULT '' COMMENT 'content',
  `website` varchar(256) NOT NULL DEFAULT '' COMMENT 'website home url',
  `app_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'app id',
  `app_version` float(11,2) NOT NULL DEFAULT '0.00' COMMENT 'app version',
  `platform` tinyint NOT NULL DEFAULT '-1' COMMENT 'platform',
  `os` varchar(16) NOT NULL DEFAULT '' COMMENT 'operation system',
  `user_agent` varchar(512) NOT NULL DEFAULT '' COMMENT 'use agent',
  `client_version` varchar(64) NOT NULL DEFAULT '' COMMENT 'client os version',
  `longitude` double NOT NULL DEFAULT '0' COMMENT 'longitude',
  `latitude` double NOT NULL DEFAULT '0' COMMENT 'latitude',
  `network` varchar(16) NOT NULL DEFAULT '' COMMENT 'network',
  `simulate` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is simulate',
  `imei` varchar(64) NOT NULL DEFAULT '' COMMENT 'imei',
  `bssid` varchar(64) NOT NULL DEFAULT '' COMMENT 'bssi',
  `ssid` char(64) NOT NULL DEFAULT '' COMMENT 'ssid',
  `idfa` char(64) NOT NULL DEFAULT '' COMMENT 'idfa',
  `start_time` bigint NOT NULL DEFAULT '0' COMMENT 'client start time',
  `resume_time` bigint NOT NULL DEFAULT '0' COMMENT 'client resume time',
  `create_time` bigint NOT NULL DEFAULT '0',
  `update_time` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='event';

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `group_id` int unsigned NOT NULL AUTO_INCREMENT,
  `group_type` varchar(8) NOT NULL DEFAULT '' COMMENT '组类别',
  `group_level` int unsigned NOT NULL DEFAULT '0' COMMENT '组级别',
  `group_name` varchar(64) NOT NULL DEFAULT '' COMMENT '组名',
  `cent` int unsigned NOT NULL DEFAULT '0' COMMENT '积分',
  `department_id` int NOT NULL DEFAULT '0' COMMENT '部门id',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'STATUS',
  `max_allow_count` int NOT NULL DEFAULT '0' COMMENT '最大允许用户数',
  `group_ico` varchar(128) NOT NULL DEFAULT '' COMMENT ' 组图标',
  `create_time` bigint NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT '0' COMMENT '更新时间',
  `create_user_id` bigint DEFAULT '0' COMMENT '创建用户id',
  `update_user_id` bigint NOT NULL DEFAULT '0' COMMENT '更新用户id',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT 'remark',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='group';

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `group_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'Group id',
  `resource` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '资源配置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=309 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='privilege';

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT 'name',
  `code` varchar(64) NOT NULL DEFAULT '' COMMENT 'code',
  `parent_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'parent id',
  `resource_type` tinyint NOT NULL DEFAULT '0' COMMENT 'resource type',
  `open_type` varchar(16) NOT NULL DEFAULT '' COMMENT 'open type',
  `manage_url` varchar(256) NOT NULL DEFAULT '' COMMENT 'manager url',
  `list_url` varchar(256) NOT NULL DEFAULT '' COMMENT 'list url',
  `detail_url` varchar(256) NOT NULL DEFAULT '' COMMENT 'detail url',
  `access_url` varchar(256) NOT NULL DEFAULT '' COMMENT 'access ico url',
  `new_url` varchar(256) NOT NULL DEFAULT '' COMMENT 'new url',
  `max_record_count` int NOT NULL DEFAULT '0' COMMENT 'max record count',
  `sort` int NOT NULL DEFAULT '0' COMMENT 'sort',
  `ico_url` varchar(256) NOT NULL DEFAULT '' COMMENT 'forum ico url',
  `manager` varchar(64) NOT NULL DEFAULT '' COMMENT 'manager url',
  `upload_key` varchar(64) NOT NULL DEFAULT '' COMMENT 'upload key',
  `cover` varchar(256) NOT NULL DEFAULT '' COMMENT 'cover',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'STATUS',
  `create_user_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'create user id',
  `create_time` bigint NOT NULL DEFAULT '0' COMMENT 'create time',
  `update_user_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'update user id',
  `update_time` bigint NOT NULL DEFAULT '0' COMMENT 'update time',
  `remark` varchar(512) NOT NULL DEFAULT '' COMMENT 'remark',
  `appId` bigint NOT NULL DEFAULT '0' COMMENT 'app id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='resource';

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `group_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'Group id',
  `strategy` varchar(16) NOT NULL DEFAULT '' COMMENT '策略',
  `value` varchar(16) NOT NULL DEFAULT '' COMMENT '配置值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='strategy';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT '' COMMENT '用户名',
  `nick_name` varchar(64) DEFAULT '' COMMENT '昵称',
  `email` varchar(256) DEFAULT '' COMMENT 'E-MAIL',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `gender` tinyint DEFAULT '0' COMMENT '性别',
  `avatar` varchar(256) DEFAULT '' COMMENT '头象',
  `personal_signature` varchar(256) DEFAULT '' COMMENT '签名',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `mobile` varchar(11) DEFAULT '0' COMMENT '手机号码',
  `last_login_time` bigint DEFAULT '0' COMMENT '最近登录时间',
  `cent` bigint DEFAULT '0' COMMENT '积分',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  `is_online` tinyint(1) DEFAULT '0' COMMENT '是否在线',
  `activate` tinyint(1) DEFAULT '0' COMMENT '是否激活',
  `activate_time` bigint DEFAULT '0' COMMENT '激活时间',
  `zone` varchar(32) DEFAULT '' COMMENT '主页',
  `channel` varchar(128) DEFAULT '' COMMENT '渠道来源',
  `website` varchar(128) DEFAULT '' COMMENT '用户注册网站',
  `group_level` varchar(64) DEFAULT '' COMMENT '用户等级',
  `secret_mobile` varchar(64) DEFAULT '' COMMENT 'SECRET MOBILE',
  `device` varchar(16) DEFAULT '' COMMENT '设备',
  `device_id` varchar(64) DEFAULT '' COMMENT '设备id',
  `device_model` varchar(32) DEFAULT '' COMMENT '设备模型',
  `ip` bigint DEFAULT '0' COMMENT 'ip',
  `create_time` bigint NOT NULL DEFAULT '0' COMMENT '注册日期',
  `update_time` bigint DEFAULT '0' COMMENT '最近更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='user';

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'user id',
  `group_id` int unsigned NOT NULL DEFAULT '0' COMMENT 'group_id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='user_group';

SET FOREIGN_KEY_CHECKS = 1;
