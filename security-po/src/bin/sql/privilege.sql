DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
 `id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `role_id` int(11) unsigned default 0 comment 'role id'  NOT NULL,
 `resource_id` varchar(128)  DEFAULT '' COMMENT 'resource id'  NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='privilege';
