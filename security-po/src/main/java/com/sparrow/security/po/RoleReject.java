package com.sparrow.security.po;

import com.sparrow.protocol.POJO;
import jakarta.persistence.*;
import lombok.Data;

/**
 * 角色互斥表（备忘，本次迭代不实现）
 */
@Data
@Table(name = "t_role_reject")
public class RoleReject implements POJO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "role_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '角色ID'", nullable = false)
    private Long roleId;

    @Column(name = "reject_role_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '互斥角色ID'", nullable = false)
    private Long rejectRoleId;

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
