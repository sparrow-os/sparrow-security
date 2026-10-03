package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_role")
public class Role extends PO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "app_id", columnDefinition = "bigint(11) DEFAULT 0 COMMENT '所属APP ID'", nullable = false)
    private Long appId;

    @Column(name = "code", columnDefinition = "varchar(32) DEFAULT '' COMMENT '角色编码'", nullable = false)
    private String code;

    @Column(name = "name", columnDefinition = "varchar(32) DEFAULT '' COMMENT '角色名称'", nullable = false)
    private String name;

    @Column(name = "priority", columnDefinition = "int DEFAULT 0 COMMENT '角色优先级，越大越优先'", nullable = false)
    private Integer priority;
}
