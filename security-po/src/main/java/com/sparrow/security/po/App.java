package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_app")
public class App extends PO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "code", columnDefinition = "varchar(32) DEFAULT '' COMMENT '应用编码'", nullable = false)
    private String code;

    @Column(name = "name", columnDefinition = "varchar(32) DEFAULT '' COMMENT '应用名称'", nullable = false)
    private String name;

    @Column(name = "sort", columnDefinition = "int DEFAULT 0 COMMENT '排序'", nullable = false)
    private Integer sort;

    @Column(name = "logo", columnDefinition = "varchar(256) DEFAULT '' COMMENT 'logo地址'", nullable = false)
    private String logo;

    @Column(name = "remark", columnDefinition = "varchar(512) DEFAULT '' COMMENT '备注'", nullable = false)
    private String remark;
}
