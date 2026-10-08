DROP TABLE IF EXISTS `t_dict_type_i18n`;
CREATE TABLE `t_dict_type_i18n` (
 `id` bigint UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `dict_type_id` bigint UNSIGNED DEFAULT 0 COMMENT '关联 t_dict_type.id（不可变）'  NOT NULL,
 `locale` varchar(10) DEFAULT '' COMMENT '语言标识（zh-CN/en-US/ja-JP等）'  NOT NULL,
 `type_name` varchar(200) DEFAULT '' COMMENT '字典类型显示名称'  NOT NULL,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `deleted` tinyint(1)  DEFAULT 0 COMMENT '是否删除'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_dict_type_i18n';
