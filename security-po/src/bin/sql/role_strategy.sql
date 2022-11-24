DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
`id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
`role_id` int(11) unsigned default 0 comment 'role id'  NOT NULL,
`strategy` varchar(16)  DEFAULT '' COMMENT 'strategy'  NOT NULL,
`value` varchar(16)  DEFAULT '' COMMENT 'config value'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='strategy';
