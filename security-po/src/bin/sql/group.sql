DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
`group_id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
`group_type` varchar(8) default '' comment '组类别'  NOT NULL,
`group_name` varchar(64) DEFAULT '' COMMENT '组名'  NOT NULL,
`max_allow_count` int(11)DEFAULT 0 COMMENT '最大允许用户数'  NOT NULL,
`group_ico` varchar(128) default '' comment ' 组图标'  NOT NULL,
`status` tinyint(1) DEFAULT 0 COMMENT 'STATUS'  NOT NULL,
`create_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'create user id'  NOT NULL,
`create_time` bigint(11)  DEFAULT 0 COMMENT 'create time'  NOT NULL,
`update_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'update user id'  NOT NULL,
`update_time` bigint(11)  DEFAULT 0 COMMENT 'update time'  NOT NULL,
`remark` varchar(512)  DEFAULT '' COMMENT 'remark'  NOT NULL,
PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='group';
