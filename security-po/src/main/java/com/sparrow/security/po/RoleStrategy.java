package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_role_strategy")
public class RoleStrategy extends PO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "role_id", columnDefinition = "bigint UNSIGNED COMMENT '角色ID'", nullable = false)
    private Long roleId;

    @Column(name = "strategy", columnDefinition = "json COMMENT '策略配置JSON'", nullable = false)
    private String strategy;
}
