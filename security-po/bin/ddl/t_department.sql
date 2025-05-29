DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
 `id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `pinyin` varchar(64)  DEFAULT '' COMMENT 'pinyin'  NOT NULL,
 `code` varchar(64)  DEFAULT '' COMMENT 'code'  NOT NULL,
 `name` varchar(64)  DEFAULT '' COMMENT 'name'  NOT NULL,
 `parent_id` int(11)unsigned  DEFAULT 0 COMMENT 'parent id'  NOT NULL,
 `manager` varchar(16)  DEFAULT '' COMMENT '负责人'  NOT NULL,
 `telephone` varchar(16)  DEFAULT '' COMMENT '负责人电话'  NOT NULL,
 `type` varchar(16)  DEFAULT '' COMMENT '部门类型'  NOT NULL,
 `sort` varchar(16)  DEFAULT '' COMMENT '部门排序号'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'  NOT NULL,
 `create_user_id` int(11) UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `gmt_create` bigint(11)  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `modified_user_id` int(11) unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `gmt_modified` bigint(11)  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_department';
