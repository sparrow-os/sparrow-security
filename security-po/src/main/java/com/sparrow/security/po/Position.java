package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_position")
public class Position extends PO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "organization_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '所属部门ID'", nullable = false)
    private Long organizationId;

    @Column(name = "code", columnDefinition = "varchar(64) DEFAULT '' COMMENT '岗位编码'", nullable = false)
    private String code;

    @Column(name = "name", columnDefinition = "varchar(64) DEFAULT '' COMMENT '岗位名称'", nullable = false)
    private String name;

    @Column(name = "sort", columnDefinition = "int DEFAULT 0 COMMENT '排序'", nullable = false)
    private Integer sort;
}
