package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_permission")
public class Permission extends PO {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "tenant_id", columnDefinition = "int UNSIGNED DEFAULT 0 COMMENT '租户ID，0=全局，>0=租户私有'", nullable = false)
    private Long tenantId;

    @Column(name = "permission_code", columnDefinition = "varchar(128) COMMENT '权限编码，如 order:create'", nullable = false)
    private String permissionCode;

    @Column(name = "permission_name", columnDefinition = "varchar(64) COMMENT '权限/菜单名称'", nullable = false)
    private String permissionName;

    @Column(name = "permission_type", columnDefinition = "tinyint DEFAULT 1 COMMENT '1菜单 2页面 3按钮 4API 5事件'", nullable = false)
    private Integer permissionType;

    @Column(name = "micro_service_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '所属微服务ID'", nullable = false)
    private Long microServiceId;

    @Column(name = "parent_id", columnDefinition = "bigint UNSIGNED DEFAULT 0 COMMENT '父节点ID'", nullable = false)
    private Long parentId;

    @Column(name = "operation", columnDefinition = "varchar(64) DEFAULT '' COMMENT '操作：view/create/update/delete/export'", nullable = false)
    private String operation;

    @Column(name = "object", columnDefinition = "varchar(64) DEFAULT '' COMMENT '对象/资源域：order/user/report'", nullable = false)
    private String object;

    @Column(name = "url", columnDefinition = "varchar(256) DEFAULT '' COMMENT '菜单/页面跳转地址'", nullable = false)
    private String url;

    @Column(name = "method", columnDefinition = "varchar(8) DEFAULT '' COMMENT 'HTTP方法，API用'", nullable = false)
    private String method;

    @Column(name = "icon", columnDefinition = "varchar(256) DEFAULT '' COMMENT '菜单图标'", nullable = false)
    private String icon;

    @Column(name = "open_type", columnDefinition = "varchar(16) DEFAULT '' COMMENT '打开方式 _blank/_self'", nullable = false)
    private String openType;

    @Column(name = "sort", columnDefinition = "int DEFAULT 0 COMMENT '排序'", nullable = false)
    private Integer sort;
}
