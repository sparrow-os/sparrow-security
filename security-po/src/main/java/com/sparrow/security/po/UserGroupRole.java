package com.sparrow.security.po;

import com.sparrow.protocol.POJO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_user_group_role")
public class UserGroupRole implements POJO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "group_id", columnDefinition = "bigint UNSIGNED COMMENT '用户组ID'", nullable = false)
    private Long groupId;

    @Column(name = "role_id", columnDefinition = "bigint UNSIGNED COMMENT '角色ID'", nullable = false)
    private Long roleId;

    @Column(name = "create_user_id", columnDefinition = "bigint(11) UNSIGNED DEFAULT 0 COMMENT '创建人ID'", nullable = false, updatable = false)
    private Long createUserId;

    @Column(name = "gmt_create", columnDefinition = "bigint(11) UNSIGNED DEFAULT 0 COMMENT '创建时间'", nullable = false, updatable = false)
    private Long gmtCreate;

    @Column(name = "create_user_name", columnDefinition = "varchar(64) DEFAULT '' COMMENT '创建人'", nullable = false, updatable = false)
    private String createUserName;

    @Column(name = "modified_user_id", columnDefinition = "bigint(11) UNSIGNED DEFAULT 0 COMMENT '更新人ID'", nullable = false)
    private Long modifiedUserId;

    @Column(name = "gmt_modified", columnDefinition = "bigint(11) UNSIGNED DEFAULT 0 COMMENT '更新时间'", nullable = false)
    private Long gmtModified;

    @Column(name = "modified_user_name", columnDefinition = "varchar(64) DEFAULT '' COMMENT '更新人'", nullable = false)
    private String modifiedUserName;
}
