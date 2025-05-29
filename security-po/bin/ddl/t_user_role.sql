DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
 `id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `user_id` int(11)  DEFAULT 0 COMMENT 'user id'  NOT NULL,
 `role_id` int(11)  DEFAULT 0 COMMENT 'role id'  NOT NULL,
 `gmt_create` bigint(11)  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_user_role';
