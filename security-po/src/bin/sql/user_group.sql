DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
`id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
`user_id` int(11) unsigned default 0 comment 'user id'  NOT NULL,
`group_id` int(11) unsigned default 0 comment 'group_id'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user_group';
