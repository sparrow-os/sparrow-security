DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
 `id` int UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
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
 `deleted` tinyint(1)  DEFAULT 0 COMMENT '是否删除'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_role';
