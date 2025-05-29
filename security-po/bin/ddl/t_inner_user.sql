DROP TABLE IF EXISTS `t_inner_user`;
CREATE TABLE `t_inner_user` (
 `user_id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `department_id`  bigint(11) DEFAULT 0 COMMENT '部门ID'  ,
 `create_user_id` int(11) UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `gmt_create` bigint(11)  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `modified_user_id` int(11) unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `gmt_modified` bigint(11)  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_inner_user';
