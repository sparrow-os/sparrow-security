-- =============================================
-- 通用字段定义（所有表必须包含以下6个字段）
-- =============================================
-- `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
-- `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
-- `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
-- `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
-- `create_user_name`   varchar(64)         NOT NULL DEFAULT '' COMMENT '创建人',
-- `modified_user_name` varchar(64)         NOT NULL DEFAULT '' COMMENT '更新人'

-- =============================================
-- 1. APP 表
-- =============================================
CREATE TABLE `t_app` (
                         `id`                 int UNSIGNED    NOT NULL AUTO_INCREMENT,
                         `tenant_id`          int UNSIGNED    NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                         `code`               varchar(32)     NOT NULL DEFAULT '' COMMENT '应用编码',
                         `name`               varchar(32)     NOT NULL DEFAULT '' COMMENT '应用名称',
                         `sort`               int             NOT NULL DEFAULT 0 COMMENT '排序',
                         `logo`               varchar(256)    NOT NULL DEFAULT '' COMMENT 'logo地址',
                         `status`             tinyint(1)      NOT NULL DEFAULT 0 COMMENT '状态',
                         `remark`             varchar(512)    NOT NULL DEFAULT '' COMMENT '备注',
                         `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                         `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                         `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                         `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                         `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                         `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='APP表';

-- =============================================
-- 2. 微服务表
-- =============================================
CREATE TABLE `t_micro_service` (
                                   `id`                 int UNSIGNED    NOT NULL AUTO_INCREMENT,
                                   `tenant_id`          int UNSIGNED    NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                   `name`               varchar(32)     NOT NULL DEFAULT '' COMMENT '微服务名称',
                                   `sort`               int             NOT NULL DEFAULT 0 COMMENT '排序',
                                   `logo`               varchar(256)    NOT NULL DEFAULT '' COMMENT 'logo地址',
                                   `app_id`             bigint          NOT NULL DEFAULT 0 COMMENT '所属APP ID',
                                   `url`                varchar(256)    NOT NULL DEFAULT '' COMMENT '微服务URL/路径',
                                   `status`             tinyint(1)      NOT NULL DEFAULT 0 COMMENT '状态',
                                   `remark`             varchar(512)    NOT NULL DEFAULT '' COMMENT '备注',
                                   `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                   `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                   `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                   `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                   `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                   `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微服务表';

-- =============================================
-- 3. 权限/菜单/资源表（已修正 datetime → bigint）
-- =============================================
CREATE TABLE `t_permission` (
                                `id`                 bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `tenant_id`          int UNSIGNED    NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                `permission_code`    varchar(128)    NOT NULL COMMENT '权限编码，如 order:create',
                                `permission_name`    varchar(64)     NOT NULL COMMENT '权限/菜单名称',
                                `permission_type`    tinyint         NOT NULL DEFAULT 1 COMMENT '1菜单 2页面 3按钮 4API 5事件',
                                `micro_service_id`   bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属微服务ID',
                                `parent_id`          bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '父节点ID',
                                `operation`          varchar(64)     NOT NULL DEFAULT '' COMMENT '操作：view/create/update/delete/export',
                                `object`             varchar(64)     NOT NULL DEFAULT '' COMMENT '对象/资源域：order/user/report',
                                `url`                varchar(256)    NOT NULL DEFAULT '' COMMENT '菜单/页面跳转地址',
                                `method`             varchar(8)      NOT NULL DEFAULT '' COMMENT 'HTTP方法，API用',
                                `icon`               varchar(256)    NOT NULL DEFAULT '' COMMENT '菜单图标',
                                `open_type`          varchar(16)     NOT NULL DEFAULT '' COMMENT '打开方式 _blank/_self',
                                `sort`               int             NOT NULL DEFAULT 0 COMMENT '排序',
                                `status`             tinyint         NOT NULL DEFAULT 1 COMMENT '1启用 0禁用',
                                `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `uk_tenant_ms_code` (`tenant_id`, `micro_service_id`, `permission_code`),
                                KEY `idx_ms_type_status` (`micro_service_id`, `permission_type`, `status`),
                                KEY `idx_parent` (`parent_id`),
                                KEY `idx_object` (`object`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限/菜单/资源表';

-- =============================================
-- 4. 角色表
-- =============================================
CREATE TABLE `t_role` (
                          `id`                 int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                          `tenant_id`          int UNSIGNED    NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                          `app_id`             bigint(11)      NOT NULL DEFAULT 0 COMMENT '所属APP ID',
                          `code`               varchar(32)     NOT NULL DEFAULT '' COMMENT '角色编码',
                          `name`               varchar(32)     NOT NULL DEFAULT '' COMMENT '角色名称',
                          `priority`           int             NOT NULL DEFAULT 0 COMMENT '角色优先级，越大越优先',
                          `status`             tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
                          `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                          `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                          `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                          `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                          `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                          `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- =============================================
-- 5. 用户-角色关联表
-- =============================================
CREATE TABLE `t_user_role` (
                               `id`                 int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                               `tenant_id`          int UNSIGNED    NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                               `user_id`            int(11)         NOT NULL DEFAULT 0 COMMENT 'Passport用户ID',
                               `role_id`            int(11)         NOT NULL DEFAULT 0 COMMENT '角色ID',
                               `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                               `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                               `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                               `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                               `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                               `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户-角色关联表';

-- =============================================
-- 6. 用户组-角色关联表（已修正 datetime → bigint）
-- =============================================
CREATE TABLE `t_user_group_role` (
                                     `id`                 bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `tenant_id`          bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                     `group_id`           bigint UNSIGNED NOT NULL COMMENT '用户组ID',
                                     `role_id`            bigint UNSIGNED NOT NULL COMMENT '角色ID',
                                     `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                     `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                     `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                     `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                     `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                     `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                     PRIMARY KEY (`id`),
                                     UNIQUE KEY `uk_tenant_group_role` (`tenant_id`, `group_id`, `role_id`),
                                     KEY `idx_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户组-角色关联表';

-- =============================================
-- 7. 角色-权限关联表（NIST PA）
-- =============================================
CREATE TABLE `t_permission_assignments` (
                                            `id`                 int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                                            `tenant_id`          int UNSIGNED    NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                            `role_id`            int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID',
                                            `permission_id`      int(11)         NOT NULL DEFAULT 0 COMMENT '权限ID',
                                            `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                            `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                            `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                            `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                            `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                            `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色-权限关联表';

-- =============================================
-- 8. 角色策略配置表（已修正 datetime → bigint）
-- =============================================
CREATE TABLE `t_role_strategy` (
                                   `id`                 bigint UNSIGNED NOT NULL AUTO_INCREMENT,
                                   `tenant_id`          bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                   `role_id`            bigint UNSIGNED NOT NULL COMMENT '角色ID',
                                   `strategy`           json            NOT NULL COMMENT '策略配置JSON',
                                   `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                   `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                   `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                   `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                   `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                   `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                   PRIMARY KEY (`id`),
                                   UNIQUE KEY `uk_role` (`role_id`, `tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色策略配置表';

-- =============================================
-- 9. 部门/组织表（补充通用字段）
-- =============================================
CREATE TABLE `t_organization` (
                                  `id`                 int UNSIGNED    NOT NULL AUTO_INCREMENT,
                                  `tenant_id`          int UNSIGNED    NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                  `level`              int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '部门级别，顶级为0',
                                  `parent_id`          int UNSIGNED    NOT NULL DEFAULT 0 COMMENT '父部门ID',
                                  `code`               varchar(16)     NOT NULL DEFAULT '' COMMENT '部门编码',
                                  `name`               varchar(16)     NOT NULL DEFAULT '' COMMENT '部门名称',
                                  `manager`            varchar(16)     NOT NULL DEFAULT '' COMMENT '负责人',
                                  `telephone`          varchar(16)     NOT NULL DEFAULT '' COMMENT '部门电话',
                                  `sort`               int(11)         NOT NULL DEFAULT 0 COMMENT '排序',
                                  `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                  `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                  `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                  `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                  `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                  `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门/组织表';

-- =============================================
-- 10. 岗位表（已修正 datetime → bigint）
-- =============================================
CREATE TABLE `t_position` (
                              `id`                 bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `tenant_id`          bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                              `organization_id`    bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属部门ID',
                              `code`               varchar(64)     NOT NULL DEFAULT '' COMMENT '岗位编码',
                              `name`               varchar(64)     NOT NULL DEFAULT '' COMMENT '岗位名称',
                              `sort`               int             NOT NULL DEFAULT 0 COMMENT '排序',
                              `status`             tinyint         NOT NULL DEFAULT 1 COMMENT '1启用 0禁用',
                              `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                              `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                              `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                              `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                              `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                              `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `uk_tenant_org_code` (`tenant_id`, `organization_id`, `code`),
                              KEY `idx_org` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位表';

-- =============================================
-- 11. 后台用户表（已修正 datetime → bigint）
-- =============================================
CREATE TABLE `t_admin_user` (
                                `id`                 bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `tenant_id`          bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                `user_id`            bigint UNSIGNED NOT NULL COMMENT 'Passport用户ID',
                                `organization_id`    bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属部门ID',
                                `position_id`        bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '全职岗位ID',
                                `status`             tinyint         NOT NULL DEFAULT 1 COMMENT '1启用 0禁用',
                                `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `uk_tenant_user` (`tenant_id`, `user_id`),
                                KEY `idx_org` (`organization_id`),
                                KEY `idx_position` (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台用户表';

-- =============================================
-- 12. 后台用户-兼职岗位关联表（已修正 datetime → bigint）
-- =============================================
CREATE TABLE `t_admin_user_position` (
                                         `id`                 bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                         `tenant_id`          bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '租户ID',
                                         `user_id`            bigint UNSIGNED NOT NULL COMMENT 'Passport用户ID',
                                         `position_id`        bigint UNSIGNED NOT NULL COMMENT '兼职岗位ID',
                                         `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                         `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                         `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                         `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                         `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                         `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `uk_tenant_user_position` (`tenant_id`, `user_id`, `position_id`),
                                         KEY `idx_position` (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台用户-兼职岗位关联表';

-- =============================================
-- 13. 用户组表（已修正 datetime → bigint）
-- =============================================
CREATE TABLE `t_user_group` (
                                `id`                 bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `tenant_id`          bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                `code`               varchar(64)     NOT NULL DEFAULT '' COMMENT '用户组编码',
                                `name`               varchar(64)     NOT NULL DEFAULT '' COMMENT '用户组名称',
                                `sort`               int             NOT NULL DEFAULT 0 COMMENT '排序',
                                `status`             tinyint         NOT NULL DEFAULT 1 COMMENT '1启用 0禁用',
                                `remark`             varchar(512)    NOT NULL DEFAULT '' COMMENT '备注',
                                `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `uk_tenant_code` (`tenant_id`, `code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户组表';

-- =============================================
-- 14. 用户组-成员关联表（已修正 datetime → bigint）
-- =============================================
CREATE TABLE `t_user_group_member` (
                                       `id`                 bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                       `tenant_id`          bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                       `group_id`           bigint UNSIGNED NOT NULL COMMENT '用户组ID',
                                       `member_type`        tinyint         NOT NULL COMMENT '成员类型：1用户 2部门 3岗位',
                                       `member_id`          bigint UNSIGNED NOT NULL COMMENT '成员ID',
                                       `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                       `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                       `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                       `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                       `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                       `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `uk_tenant_group_member` (`tenant_id`, `group_id`, `member_type`, `member_id`),
                                       KEY `idx_member` (`member_type`, `member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户组-成员关联表';

-- =============================================
-- 15. 角色互斥表（备忘，本次不实现，已补充通用字段）
-- =============================================
CREATE TABLE `t_role_reject` (
                                 `id`                 int UNSIGNED    NOT NULL AUTO_INCREMENT,
                                 `tenant_id`          bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有',
                                 `role_id`            int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID',
                                 `reject_role_id`     int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '互斥角色ID',
                                 `create_user_id`     bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
                                 `gmt_create`         bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
                                 `modified_user_id`   bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
                                 `gmt_modified`       bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
                                 `create_user_name`   varchar(64)     NOT NULL DEFAULT '' COMMENT '创建人',
                                 `modified_user_name` varchar(64)     NOT NULL DEFAULT '' COMMENT '更新人',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色互斥表（备忘）';
