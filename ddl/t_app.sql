DROP TABLE IF EXISTS `t_app`;
CREATE TABLE `t_app` (
 `id` int UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
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
