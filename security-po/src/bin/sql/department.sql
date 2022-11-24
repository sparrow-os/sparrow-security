DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
`id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
`code` varchar(64)  DEFAULT '' COMMENT 'code'  NOT NULL,
`name` varchar(64)  DEFAULT '' COMMENT 'name'  NOT NULL,
`pinyin` varchar(64)  DEFAULT '' COMMENT 'pinyin'  NOT NULL,
`parent_id` int(11)unsigned  DEFAULT 0 COMMENT 'parent id'  NOT NULL,
`manager` varchar(16)  DEFAULT '' COMMENT '负责人'  NOT NULL,
`telephone` varchar(16)  DEFAULT '' COMMENT '负责人电话'  NOT NULL,
`type` varchar(16)  DEFAULT '' COMMENT '部门类型'  NOT NULL,
`sort` varchar(16)  DEFAULT '' COMMENT '部门排序号'  NOT NULL,
`status` tinyint(1) DEFAULT 0 COMMENT 'STATUS'  NOT NULL,
`create_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'create user id'  NOT NULL,
`create_time` bigint(11)  DEFAULT 0 COMMENT 'create time'  NOT NULL,
`update_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'update user id'  NOT NULL,
`update_time` bigint(11)  DEFAULT 0 COMMENT 'update time'  NOT NULL,
`remark` varchar(512)  DEFAULT '' COMMENT 'remark'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='department';
