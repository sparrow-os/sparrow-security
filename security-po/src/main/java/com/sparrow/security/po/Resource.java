package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import javax.persistence.*;

@Table(name = "t_resource")
@Data
public class Resource extends PO {
    public Resource() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;
    @Column(name = "app_id", columnDefinition = "bigint(20)  DEFAULT 0 COMMENT 'app id'", nullable = false)
    private Long appId;

    @Column(name = "micro_service_id", columnDefinition = "int(10) UNSIGNED  DEFAULT 0 COMMENT '微服务ID'", nullable = false)
    private Long microServiceId;

    @Column(name = "permission", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'permission'", nullable = false, unique = true)
    private String permission;
    @Column(name = "name", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'name'", nullable = false, unique = true)
    private String name;

    @Column(name = "parent_id", columnDefinition = "int(11) unsigned  DEFAULT 0 COMMENT 'parent id'", nullable = false)
    private Long parentId;
    /**
     * 目录、菜单、按钮（事件）
     */
    @Column(name = "resource_type", columnDefinition = "tinyint(2)  DEFAULT 0 COMMENT 'resource type'", nullable = false)
    private Integer resourceType;
    /**
     * _blank _self _manage
     */
    @Column(name = "open_type", columnDefinition = "varchar(16)  DEFAULT '' COMMENT 'open type'", nullable = false)
    private String openType;
    /**
     * 权限url 对应用户访问的直接URL
     * <p>
     * cms/manage-{001}.do
     * <p>
     * cms/manage-{002}.do
     */
    @Column(name = "url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'url'", nullable = false)
    private String url;
    /**
     * 请求的method GET/POST
     */
    @Column(name = "method", columnDefinition = "varchar(4)  DEFAULT '' COMMENT ' method'", nullable = false)
    private String method;

    /**
     * ico 图标
     */
    @Column(name = "ico_url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT ' ico url'", nullable = false)
    private String icoUrl;

    /**
     * 序号
     */
    @Column(name = "sort", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'sort'", nullable = false, updatable = false)
    private Integer sort;

    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'",
            nullable = false)
    private StatusRecord status;
}
