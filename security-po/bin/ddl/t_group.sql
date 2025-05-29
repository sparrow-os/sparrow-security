DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
 `group_id` int UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `group_name` varchar(64) DEFAULT '' COMMENT '组名'  NOT NULL,
 `max_allow_count` int(11)DEFAULT 0 COMMENT '最大允许用户数'  NOT NULL,
 `group_type` varchar(8) default '' comment '组类别'  NOT NULL,
 `group_ico` varchar(128) default '' comment ' 组图标'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `gmt_create` bigint(11)  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `modified_user_id` int(11) unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `gmt_modified` bigint(11)  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_group';
