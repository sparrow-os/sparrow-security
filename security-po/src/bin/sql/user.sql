DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`user_id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
`department_id`  bigint(11) DEFAULT 0 COMMENT '部门ID'  ,
`user_name`  varchar(64) DEFAULT '' COMMENT '用户名'  ,
`nick_name` varchar(64)  DEFAULT '' COMMENT '昵称'  ,
`email` varchar(256) DEFAULT '' comment 'E-MAIL'  ,
`gender` tinyint(2) DEFAULT 0 COMMENT '性别'  ,
`avatar` varchar(256) DEFAULT '' COMMENT '头象'  ,
`birthday` date COMMENT '生日'  ,
`mobile` varchar(11) DEFAULT '0' COMMENT '手机号码'  ,
`status` tinyint(1) DEFAULT 0 COMMENT 'STATUS'  NOT NULL,
`create_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'create user id'  NOT NULL,
`create_time` bigint(11)  DEFAULT 0 COMMENT 'create time'  NOT NULL,
`update_user_id` int(11) unsigned  DEFAULT 0 COMMENT 'update user id'  NOT NULL,
`update_time` bigint(11)  DEFAULT 0 COMMENT 'update time'  NOT NULL,
`remark` varchar(512)  DEFAULT '' COMMENT 'remark'  NOT NULL,
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user';
