DROP TABLE IF EXISTS `t_role_app`;
CREATE TABLE `t_role_app` (
 `id` int(11) UNSIGNED AUTO_INCREMENT NOT NULL AUTO_INCREMENT,
 `app_id` int(11)  DEFAULT 0 COMMENT 'app id'  NOT NULL,
 `role_id` int(11)  DEFAULT 0 COMMENT 'role id'  NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='t_role_app';
