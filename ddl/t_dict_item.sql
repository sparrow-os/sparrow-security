DROP TABLE IF EXISTS `t_dict_item`;
CREATE TABLE `t_dict_item` (
 `id` bigint UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `tenant_id` int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'  NOT NULL,
 `parent_id` int DEFAULT 0 COMMENT '父ID'  NOT NULL,
 `dict_type_id` bigint UNSIGNED DEFAULT 0 COMMENT '关联 t_dict_type.id'  NOT NULL,
 `item_code` varchar(100) DEFAULT '' COMMENT '字典项编码（不可变）'  NOT NULL,
 `item_value` varchar(500) DEFAULT '' COMMENT '字典项值（存储实际业务值）'  ,
 `sort` int DEFAULT 0 COMMENT '排序号'  NOT NULL,
 `remark` varchar(500) DEFAULT '' COMMENT '备注'  ,
 `create_user_name` varchar(64)  DEFAULT '' COMMENT '创建人'  NOT NULL,
 `create_user_id` int UNSIGNED  DEFAULT 0 COMMENT '创建人ID'  NOT NULL,
 `modified_user_id` int unsigned  DEFAULT 0 COMMENT '更新人ID'  NOT NULL,
 `modified_user_name` varchar(64)  DEFAULT '' COMMENT '更新人'  NOT NULL,
 `gmt_create` bigint  DEFAULT 0 COMMENT '创建时间'  NOT NULL,
 `gmt_modified` bigint  DEFAULT 0 COMMENT '更新时间'  NOT NULL,
 `status` tinyint(3) UNSIGNED DEFAULT 0 COMMENT '状态'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_dict_item';
