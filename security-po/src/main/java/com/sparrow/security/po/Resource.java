package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.dao.PO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "resource")
public class Resource extends PO {
    public Resource() {
    }

    private Long id;
    private Long appId;
    private Long microServiceId;
    private String permission;
    private String name;
    private Long parentId;
    /**
     * 目录、菜单、按钮（事件）
     */
    private Integer resourceType;
    /**
     * _blank _self _manage
     */
    private String openType;
    /**
     * 权限url 对应用户访问的直接URL
     * <p>
     * cms/manage-{001}.do
     * <p>
     * cms/manage-{002}.do
     */
    private String url;
    /**
     * 请求的method GET/POST
     */
    private String method;

    /**
     * ico 图标
     */
    private String icoUrl;

    /**
     * 序号
     */
    private Integer sort;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @MethodOrder(order = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'name'", nullable = false, unique = true)
    @MethodOrder(order = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MethodOrder(order = 3)
    @Column(name = "app_id", columnDefinition = "bigint(20)  DEFAULT 0 COMMENT 'app id'", nullable = false)
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    @MethodOrder(order = 4)
    @Column(name = "permission", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'permission'", nullable = false, unique = true)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @MethodOrder(order = 5)
    @Column(name = "parent_id", columnDefinition = "int(11) unsigned  DEFAULT 0 COMMENT 'parent id'", nullable = false)
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @MethodOrder(order = 6)
    @Column(name = "resource_type", columnDefinition = "tinyint(2)  DEFAULT 0 COMMENT 'resource type'", nullable = false)
    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    @MethodOrder(order = 7)
    @Column(name = "open_type", columnDefinition = "varchar(16)  DEFAULT '' COMMENT 'open type'", nullable = false)
    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    @MethodOrder(order = 9)
    @Column(name = "sort", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'sort'", nullable = false, updatable = false)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @MethodOrder(order = 10)
    @Column(name = "ico_url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT ' ico url'", nullable = false)
    public String getIcoUrl() {
        return icoUrl;
    }

    public void setIcoUrl(String icoUrl) {
        this.icoUrl = icoUrl;
    }

    @MethodOrder(order = 11)
    @Column(name = "url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'url'", nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @MethodOrder(order = 12)
    @Column(name = "method", columnDefinition = "varchar(4)  DEFAULT '' COMMENT ' method'", nullable = false)
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getMicroServiceId() {
        return microServiceId;
    }

    @MethodOrder(order = 12)
    @Column(name = "micro_service_id", columnDefinition = "int(10) UNSIGNED  DEFAULT 0 COMMENT '微服务ID'", nullable = false)
    public void setMicroServiceId(Long microServiceId) {
        this.microServiceId = microServiceId;
    }
}
