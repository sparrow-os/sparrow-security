package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_organization")
public class Organization extends PO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "level", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '部门级别，顶级为0'", nullable = false)
    private Integer level;

    @Column(name = "parent_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '父部门ID'", nullable = false)
    private Long parentId;

    @Column(name = "code", columnDefinition = "varchar(16) DEFAULT '' COMMENT '部门编码'", nullable = false)
    private String code;

    @Column(name = "name", columnDefinition = "varchar(16) DEFAULT '' COMMENT '部门名称'", nullable = false)
    private String name;

    @Column(name = "manager", columnDefinition = "varchar(16) DEFAULT '' COMMENT '负责人'", nullable = false)
    private String manager;

    @Column(name = "telephone", columnDefinition = "varchar(16) DEFAULT '' COMMENT '部门电话'", nullable = false)
    private String telephone;

    @Column(name = "sort", columnDefinition = "int(11) DEFAULT 0 COMMENT '排序'", nullable = false)
    private Integer sort;
}
