package com.sparrow.security.po;

import com.sparrow.protocol.POJO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_admin_user_position")
public class AdminUserPosition implements POJO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '租户ID'", nullable = false)
    private Long tenantId;

    @Column(name = "user_id", columnDefinition = "bigint UNSIGNED COMMENT 'Passport用户ID'", nullable = false)
    private Long userId;

    @Column(name = "position_id", columnDefinition = "bigint UNSIGNED COMMENT '兼职岗位ID'", nullable = false)
    private Long positionId;

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
