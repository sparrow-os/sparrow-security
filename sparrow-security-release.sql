-- =============================================================
-- sparrow-security 上线初始化脚本
-- 表结构来源: ddl/ 目录
-- 数据来源: 本地 MySQL sparrow 库
-- 生成时间: 2026-10-09
-- 共 13 张表
-- =============================================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS `sparrow` DEFAULT CHARACTER SET utf8mb4;
USE `sparrow`;

-- =============================================================
-- 一、表结构 (DDL)
-- =============================================================

-- ------------------------------------------------------------------
-- 表: t_organization
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization` (
 `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `level` int UNSIGNED DEFAULT 0 COMMENT '部门级别，顶级为0'  NOT NULL,
 `parent_id` int DEFAULT 0 COMMENT '父部门ID'  NOT NULL,
 `code` varchar(16) DEFAULT '' COMMENT '部门编码'  NOT NULL,
 `name` varchar(16) DEFAULT '' COMMENT '部门名称'  NOT NULL,
 `manager` varchar(16) DEFAULT '' COMMENT '负责人'  NOT NULL,
 `telephone` varchar(16) DEFAULT '' COMMENT '部门电话'  NOT NULL,
 `sort` int DEFAULT 0 COMMENT '排序'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_organization';

-- ------------------------------------------------------------------
-- 表: t_position
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_position`;
CREATE TABLE `t_position` (
 `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` bigint UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `organization_id` bigint UNSIGNED DEFAULT 0 COMMENT '所属部门ID'  NOT NULL,
 `code` varchar(64) DEFAULT '' COMMENT '岗位编码'  NOT NULL,
 `name` varchar(64) DEFAULT '' COMMENT '岗位名称'  NOT NULL,
 `sort` int DEFAULT 0 COMMENT '排序'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_position';

-- ------------------------------------------------------------------
-- 表: t_admin_user
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_admin_user`;
CREATE TABLE `t_admin_user` (
 `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `user_id` int UNSIGNED COMMENT 'Passport用户ID'  NOT NULL,
 `organization_id` int UNSIGNED DEFAULT 0 COMMENT '所属部门ID'  NOT NULL,
 `position_id` int UNSIGNED DEFAULT 0 COMMENT '全职岗位ID'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_admin_user';

-- ------------------------------------------------------------------
-- 表: t_app
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_app`;
CREATE TABLE `t_app` (
 `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID'  NOT NULL,
 `code` varchar(32) DEFAULT '' COMMENT '应用编码'  NOT NULL,
 `name` varchar(32) DEFAULT '' COMMENT '应用名称'  NOT NULL,
 `sort` int DEFAULT 0 COMMENT '排序'  NOT NULL,
 `logo` varchar(256) DEFAULT '' COMMENT 'logo地址'  NOT NULL,
 `remark` varchar(512) DEFAULT '' COMMENT '备注'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_app';

-- ------------------------------------------------------------------
-- 表: t_micro_service
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_micro_service`;
CREATE TABLE `t_micro_service` (
 `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `name` varchar(32) DEFAULT '' COMMENT '微服务名称'  NOT NULL,
 `sort` int DEFAULT 0 COMMENT '排序'  NOT NULL,
 `logo` varchar(256) DEFAULT '' COMMENT 'logo地址'  NOT NULL,
 `app_id` int UNSIGNED DEFAULT 0 COMMENT '所属APP ID'  NOT NULL,
 `url` varchar(256) DEFAULT '' COMMENT '微服务URL/路径'  NOT NULL,
 `remark` varchar(512) DEFAULT '' COMMENT '备注'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_micro_service';

-- ------------------------------------------------------------------
-- 表: t_permission
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
 `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID'  NOT NULL,
 `permission_code` varchar(128) COMMENT '权限编码，如 order:create'  NOT NULL,
 `permission_name` varchar(64) COMMENT '权限/菜单名称'  NOT NULL,
 `permission_type` tinyint DEFAULT 1 COMMENT '1菜单 2页面 3事件'  NOT NULL,
 `app_id` int UNSIGNED DEFAULT 0 COMMENT 'APP ID'  NOT NULL,
 `micro_service_id` int UNSIGNED DEFAULT 0 COMMENT '所属微服务ID'  NOT NULL,
 `parent_id` int UNSIGNED DEFAULT 0 COMMENT '父节点ID'  NOT NULL,
 `operation` varchar(64) DEFAULT '' COMMENT '操作：view/create/update/delete/export'  NOT NULL,
 `object` varchar(64) DEFAULT '' COMMENT '对象/资源域：order/user/report'  NOT NULL,
 `url` varchar(256) DEFAULT '' COMMENT '菜单/页面跳转地址'  NOT NULL,
 `method` varchar(8) DEFAULT '' COMMENT 'HTTP方法，API用'  NOT NULL,
 `icon` varchar(256) DEFAULT '' COMMENT '菜单图标'  NOT NULL,
 `target` varchar(16) DEFAULT '' COMMENT 'Target'  NOT NULL,
 `sort` int DEFAULT 0 COMMENT '排序'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_permission';

-- ------------------------------------------------------------------
-- 表: t_role
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
 `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `code` varchar(32) DEFAULT '' COMMENT '角色编码'  NOT NULL,
 `name` varchar(32) DEFAULT '' COMMENT '角色名称'  NOT NULL,
 `priority` int DEFAULT 0 COMMENT '角色优先级，越大越优先'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_role';

-- ------------------------------------------------------------------
-- 表: t_user_group
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_user_group`;
CREATE TABLE `t_user_group` (
 `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `code` varchar(64) DEFAULT '' COMMENT '用户组编码'  NOT NULL,
 `name` varchar(64) DEFAULT '' COMMENT '用户组名称'  NOT NULL,
 `sort` int DEFAULT 0 COMMENT '排序'  NOT NULL,
 `remark` varchar(512) DEFAULT '' COMMENT '备注'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_user_group';

-- ------------------------------------------------------------------
-- 表: t_user_group_member
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_user_group_member`;
CREATE TABLE `t_user_group_member` (
 `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` bigint UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `group_id` bigint UNSIGNED COMMENT '用户组ID'  NOT NULL,
 `member_type` tinyint COMMENT '成员类型：1用户 2部门 3岗位'  NOT NULL,
 `member_id` bigint UNSIGNED COMMENT '成员ID'  NOT NULL,
 `create_user_id` bigint(11) UNSIGNED DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `gmt_create` bigint(11) UNSIGNED DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `create_user_name` varchar(64) DEFAULT '' COMMENT '创建人'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_user_group_member';

-- ------------------------------------------------------------------
-- 表: t_dict_type
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_dict_type`;
CREATE TABLE `t_dict_type` (
 `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `type_code` varchar(100) DEFAULT '' COMMENT '字典类型编码（不可变）'  NOT NULL,
 `sort` int DEFAULT 0 COMMENT '排序号'  NOT NULL,
 `remark` varchar(500) DEFAULT '' COMMENT '备注'  ,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_dict_type';

-- ------------------------------------------------------------------
-- 表: t_dict_type_i18n
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_dict_type_i18n`;
CREATE TABLE `t_dict_type_i18n` (
 `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
 `dict_type_id` bigint UNSIGNED DEFAULT 0 COMMENT '关联 t_dict_type.id（不可变）'  NOT NULL,
 `locale` varchar(10) DEFAULT '' COMMENT '语言标识（zh-CN/en-US/ja-JP等）'  NOT NULL,
 `type_name` varchar(200) DEFAULT '' COMMENT '字典类型显示名称'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_dict_type_i18n';

-- ------------------------------------------------------------------
-- 表: t_dict_item
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_dict_item`;
CREATE TABLE `t_dict_item` (
 `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `parent_id` int DEFAULT 0 COMMENT '父ID'  NOT NULL,
 `dict_type_id` bigint UNSIGNED DEFAULT 0 COMMENT '关联 t_dict_type.id'  NOT NULL,
 `item_code` varchar(100) DEFAULT '' COMMENT '字典项编码（不可变）'  NOT NULL,
 `item_value` varchar(500) DEFAULT '' COMMENT '字典项值（存储实际业务值）'  ,
 `sort` int DEFAULT 0 COMMENT '排序号'  NOT NULL,
 `remark` varchar(500) DEFAULT '' COMMENT '备注'  ,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_dict_item';

-- ------------------------------------------------------------------
-- 表: t_dict_item_i18n
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS `t_dict_item_i18n`;
CREATE TABLE `t_dict_item_i18n` (
 `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
 `dict_item_id` bigint UNSIGNED DEFAULT 0 COMMENT '关联 t_dict_item.id（不可变）'  NOT NULL,
 `locale` varchar(10) DEFAULT '' COMMENT '语言标识（zh-CN/en-US/ja-JP等）'  NOT NULL,
 `item_label` varchar(200) DEFAULT '' COMMENT '字典项显示标签'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_dict_item_i18n';

-- =============================================================
-- 二、初始化数据 (INSERT)
-- =============================================================

/*!40000 ALTER TABLE `t_organization` DISABLE KEYS */;
INSERT INTO `t_organization` (`id`, `tenant_id`, `level`, `parent_id`, `code`, `name`, `manager`, `telephone`, `sort`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (1,0,0,0,'001','集团总部','张立志','13518572928',0,'mock-user',1,1,'mock-user',1791101200101,1791101200101,1),(2,0,0,1,'001001','集团技术部','张立志','13581579282',2,'mock-user',1,1,'mock-user',1791101237876,1791101237876,1),(3,0,0,2,'001001001','产品部','张立志','13581579282',5,'mock-user',1,1,'mock-user',1791101460657,1791101486370,1),(4,0,0,3,'269974','11','11','13581579282',0,'mock-user',1,1,'mock-user',1791250711188,1791250711188,1),(5,11,11,0,'01','11','11','13581579282',11,'mock-user',1,1,'mock-user',1791458067475,1791458067475,1),(6,3,2,5,'0011','11','3','13581579282',3,'mock-user',1,1,'mock-user',1791458090309,1791458090309,1),(7,8,67,6,'rtyui','yui','2','13581579282',2,'mock-user',1,1,'mock-user',1791522038160,1791534810894,1);
/*!40000 ALTER TABLE `t_organization` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_position` DISABLE KEYS */;
INSERT INTO `t_position` (`id`, `tenant_id`, `organization_id`, `code`, `name`, `sort`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (1,0,3,'001','初级工程师',0,'mock-user',1,1,'mock-user',1791101746574,1791101746574,1),(2,0,1,'001','技术总监',0,'mock-user',1,1,'mock-user',1791101761121,1791471055809,1),(3,0,5,'www','www',0,'mock-user',1,1,'mock-user',1791253247405,1791533262778,1);
/*!40000 ALTER TABLE `t_position` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_admin_user` DISABLE KEYS */;
INSERT INTO `t_admin_user` (`id`, `tenant_id`, `user_id`, `organization_id`, `position_id`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (2,0,2,5,2,'mock-user',1,1,'mock-user',1791182860958,1791471021880,1),(3,0,10,1,1,'mock-user',1,1,'mock-user',1791182874592,1791471014206,1);
/*!40000 ALTER TABLE `t_admin_user` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_app` DISABLE KEYS */;
INSERT INTO `t_app` (`id`, `tenant_id`, `code`, `name`, `sort`, `logo`, `remark`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (2,0,'01','sparrow-coder',0,'http://u.r.sparrowzoo.net/logo/app/1000g0081vma8ug4f80005o9ji3jnvjdlumukqgg.webp','直接显示了呗','mock-user',1,1,'mock-user',1791087516200,1791534794947,1);
/*!40000 ALTER TABLE `t_app` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_micro_service` DISABLE KEYS */;
INSERT INTO `t_micro_service` (`id`, `tenant_id`, `name`, `sort`, `logo`, `app_id`, `url`, `remark`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (1,0,'商品服务',0,'http://u.r.sparrowzoo.net/logo/micro_service/downloaded-image.jpeg',2,'http://goods.sparrowzoo.com','无','mock-user',1,1,'mock-user',1791093644520,1791093665052,1),(3,0,'sparrow-coder',0,'http://u.r.sparrowzoo.net/logo/micro_service/downloaded-image.jpeg',2,'coder','SPARROW CODER','mock-user',1,1,'mock-user',1791258147772,1791258147772,1);
/*!40000 ALTER TABLE `t_micro_service` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` (`id`, `tenant_id`, `permission_code`, `permission_name`, `permission_type`, `app_id`, `micro_service_id`, `parent_id`, `operation`, `object`, `url`, `method`, `icon`, `target`, `sort`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (1,0,'settings','系统设置',1,2,1,0,'','','','0','','0',0,'mock-user',1,1,'mock-user',1791200960284,1791466723896,1),(2,0,'DICT','字典管理',2,2,1,1,'','dict','dict-type','1','Dict','1',0,'mock-user',1,1,'mock-user',1791201173138,1791201173138,1),(3,0,'dict-add','新增字典',3,2,1,2,'add','dict','dict/add','2','Dict','1',0,'mock-user',1,1,'mock-user',1791201496665,1791201496665,1);
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`id`, `tenant_id`, `code`, `name`, `priority`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (1,0,'role','56',0,'mock-user',1,1,'mock-user',1791257991215,1791257991215,1),(2,0,'01','角色名称',0,'mock-user',1,1,'mock-user',1791258202524,1791258202524,1);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_user_group` DISABLE KEYS */;
INSERT INTO `t_user_group` (`id`, `tenant_id`, `code`, `name`, `sort`, `remark`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (1,0,'22','222',2,'22','mock-user',1,1,'mock-user',1791465506840,1791465506840,1);
/*!40000 ALTER TABLE `t_user_group` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_user_group_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_group_member` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_dict_type` DISABLE KEYS */;
INSERT INTO `t_dict_type` (`id`, `tenant_id`, `type_code`, `sort`, `remark`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (1,0,'NATION',2,'民族','mock-user',1,1,'mock-user',1791171918628,1791256238038,1),(3,0,'系统设置',0,'','mock-user',1,1,'mock-user',1791256060579,1791256060579,1),(4,0,'000',0,'','mock-user',1,1,'mock-user',1791256374228,1791256374228,1);
/*!40000 ALTER TABLE `t_dict_type` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_dict_type_i18n` DISABLE KEYS */;
INSERT INTO `t_dict_type_i18n` (`id`, `dict_type_id`, `locale`, `type_name`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (1,2,'2052','泰语','mock-user',1,1,'mock-user',1791211263347,1791211263347,1),(2,1,'1033','Nationality','mock-user',1,1,'mock-user',1791211385063,1791211385063,1),(3,3,'2058','456','mock-user',1,1,'mock-user',1791469299879,1791469299879,1);
/*!40000 ALTER TABLE `t_dict_type_i18n` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_dict_item` DISABLE KEYS */;
INSERT INTO `t_dict_item` (`id`, `tenant_id`, `parent_id`, `dict_type_id`, `item_code`, `item_value`, `sort`, `remark`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (5,0,0,1,'01','汉族',0,'','mock-user',1,1,'mock-user',1791183313401,1791192667773,1),(6,0,0,1,'01','满族',0,'','mock-user',1,1,'mock-user',1791183355614,1791192664358,1),(7,0,0,1,'03','回族',0,'','mock-user',1,1,'mock-user',1791189400876,1791192658038,1),(8,0,0,1,'04',' 藏族',0,'','mock-user',1,1,'mock-user',1791189429740,1791192636199,1),(10,0,0,1,'222','值有问题吗',0,'备注不能改','mock-user',1,1,'mock-user',1791192540470,1791211980400,1),(11,0,0,3,'01','测试树根',0,'','mock-user',1,1,'mock-user',1791439616401,1791439616401,1),(12,0,11,3,'s0','二根',0,'','mock-user',1,1,'mock-user',1791439639366,1791439639366,1),(13,0,0,0,'0001','测试0000',0,'1','mock-user',1,1,'mock-user',1791469042483,1791469042483,1),(14,0,0,4,'111','1',0,'1','mock-user',1,1,'mock-user',1791469061108,1791469061108,1),(15,0,14,4,'12222','111',0,'11','mock-user',1,1,'mock-user',1791469089148,1791469089148,1);
/*!40000 ALTER TABLE `t_dict_item` ENABLE KEYS */;
/*!40000 ALTER TABLE `t_dict_item_i18n` DISABLE KEYS */;
INSERT INTO `t_dict_item_i18n` (`id`, `dict_item_id`, `locale`, `item_label`, `create_user_name`, `create_user_id`, `modified_user_id`, `modified_user_name`, `gmt_create`, `gmt_modified`, `status`) VALUES (1,10,'2052','have problem?','mock-user',1,1,'mock-user',1791255860542,1791255860542,1),(2,7,'1033','HUI','mock-user',1,1,'mock-user',1791255888288,1791255888288,1);
/*!40000 ALTER TABLE `t_dict_item_i18n` ENABLE KEYS */;

SET FOREIGN_KEY_CHECKS = 1;
