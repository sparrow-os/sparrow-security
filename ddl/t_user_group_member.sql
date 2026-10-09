DROP TABLE IF EXISTS `t_user_group_member`;
CREATE TABLE `t_user_group_member` (
 `id` bigint UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `tenant_id` bigint UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `group_id` bigint UNSIGNED COMMENT '用户组ID'  NOT NULL,
 `member_type` tinyint COMMENT '成员类型：1用户 2部门 3岗位'  NOT NULL,
 `member_id` bigint UNSIGNED COMMENT '成员ID'  NOT NULL,
 `create_user_id` bigint(11) UNSIGNED DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `gmt_create` bigint(11) UNSIGNED DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `create_user_name` varchar(64) DEFAULT '' COMMENT '创建人'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_user_group_member';
