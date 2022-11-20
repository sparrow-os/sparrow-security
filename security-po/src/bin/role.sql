CREATE TABLE `role` (
`id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
`app_id` int(11)  DEFAULT 0 COMMENT 'app id'  NOT NULL,
`code` varchar(32)  DEFAULT '' COMMENT 'code'  NOT NULL,
`name` varchar(32)  DEFAULT '' COMMENT 'name'  NOT NULL,
`sort` int(11)  DEFAULT 0 COMMENT 'sort'  NOT NULL,
`status` tinyint(1) DEFAULT 0 COMMENT 'STATUS'  NOT NULL,
`create_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'create user id'  NOT NULL,
`create_time` bigint(11)  DEFAULT 0 COMMENT 'create time'  NOT NULL,
`update_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'update user id'  NOT NULL,
`update_time` bigint(11)  DEFAULT 0 COMMENT 'update time'  NOT NULL,
`remark` varchar(512)  DEFAULT '' COMMENT 'remark'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='role';
