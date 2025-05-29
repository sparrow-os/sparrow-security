DROP TABLE IF EXISTS `t_rule_strategy`;
CREATE TABLE `t_rule_strategy` (
 `id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `role_id` int(11) unsigned default 0 comment 'role id'  NOT NULL,
 `strategy` varchar(16)  DEFAULT '' COMMENT 'strategy'  NOT NULL,
 `value` varchar(16)  DEFAULT '' COMMENT 'config value'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_rule_strategy';
