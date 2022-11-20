DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
`forum_id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
`resource_id` int(11)  DEFAULT 0 COMMENT 'resource id'  NOT NULL,
`list_url` varchar(256)  DEFAULT '' COMMENT 'list url'  NOT NULL,
`detail_url` varchar(256)  DEFAULT '' COMMENT 'detail url'  NOT NULL,
`placeholder_url` varchar(16)  DEFAULT '' COMMENT 'placeholder url'  NOT NULL,
`new_url` varchar(256)  DEFAULT '' COMMENT 'new url'  NOT NULL,
`manager` varchar(64)  DEFAULT '' COMMENT 'manager url'  NOT NULL,
`upload_key` varchar(64)  DEFAULT '' COMMENT 'upload key'  NOT NULL,
`cover` varchar(256)  DEFAULT '' COMMENT 'cover'  NOT NULL,
`max_record_count` int(11)  DEFAULT 0 COMMENT 'max record count'  NOT NULL,
PRIMARY KEY (`forum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='forum';
