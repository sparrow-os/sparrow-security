DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization` (
 `id` int UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `level` int(11) UNSIGNED DEFAULT 0 COMMENT '部门级别，顶级为0'  NOT NULL,
 `parent_id` int UNSIGNED DEFAULT 0 COMMENT '父部门ID'  NOT NULL,
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
 `deleted` tinyint(1)  DEFAULT 0 COMMENT '是否删除'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_organization';
