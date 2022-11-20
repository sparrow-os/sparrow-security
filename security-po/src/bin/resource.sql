DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
`id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
`name` varchar(64)  DEFAULT '' COMMENT 'name'  NOT NULL,
`app_id` bigint(20)  DEFAULT 0 COMMENT 'app id'  NOT NULL,
`code` varchar(64)  DEFAULT '' COMMENT 'code'  NOT NULL,
`parent_id` int(11)unsigned  DEFAULT 0 COMMENT 'parent id'  NOT NULL,
`resource_type` tinyint(2)  DEFAULT 0 COMMENT 'resource type'  NOT NULL,
`open_type` varchar(16)  DEFAULT '' COMMENT 'open type'  NOT NULL,
`sort` int(11)  DEFAULT 0 COMMENT 'sort'  NOT NULL,
`ico_url` varchar(256)  DEFAULT '' COMMENT 'ico url'  NOT NULL,
`url` varchar(256)  DEFAULT '' COMMENT 'url '  NOT NULL,
`method` varchar(4)  DEFAULT '' COMMENT 'url method'  NOT NULL,
`status` tinyint(1) DEFAULT 0 COMMENT 'STATUS'  NOT NULL,
`create_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'create user id'  NOT NULL,
`create_time` bigint(11)  DEFAULT 0 COMMENT 'create time'  NOT NULL,
`update_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'update user id'  NOT NULL,
`update_time` bigint(11)  DEFAULT 0 COMMENT 'update time'  NOT NULL,
`remark` varchar(512)  DEFAULT '' COMMENT 'remark'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='resource';
