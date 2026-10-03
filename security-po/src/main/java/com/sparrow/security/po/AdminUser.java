package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_admin_user")
public class AdminUser extends PO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "user_id", columnDefinition = "bigint UNSIGNED COMMENT 'Passport用户ID'", nullable = false)
    private Long userId;

    @Column(name = "organization_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '所属部门ID'", nullable = false)
    private Long organizationId;

    @Column(name = "position_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '全职岗位ID'", nullable = false)
    private Long positionId;
}
