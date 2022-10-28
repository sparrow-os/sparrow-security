package com.sparrow.security.po;

import com.sparrow.protocol.MethodOrder;
import com.sparrow.protocol.POJO;
import com.sparrow.protocol.dao.PO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ALTER TABLE `sparrow`.`resource` ADD UNIQUE INDEX `u_ix_code` (`code` ASC);
 */
@Table(name = "resource")
public class Resource extends PO {
    /**
     * 默认的构造函数，否则无法通过
     * <p/>
     * this.clazz.getConstructor().newInstance()进行构照
     */
    public Resource() {
    }

    public Resource(String name, String accessUrl) {
        this.name = name;
        this.accessUrl = accessUrl;
    }

    public Resource(String code, String name, String accessUrl) {
        this.code = code;
        this.name = name;
        this.accessUrl = accessUrl;
    }

    private Long id;
    private Long appId;
    private String code;
    private String name;
    private Long parentId;
    private Integer resourceType;
    private String openType;
    /**
     * 后台管理url  权限会默认该url
     */
    private String manageUrl;
    /**
     * 前台角色（等级）对应的url
     */
    private String listUrl;
    /**
     * 创建按钮 与权限无关
     */
    private String newUrl;
    /**
     * 查看详情url 与权限无关
     */
    private String detailUrl;
    /**
     * 访问的url 对应$access  placeholder
     */
    private String accessUrl;
    private String uploadKey;
    private Integer maxRecordCount;
    private Integer sort;
    private String icoUrl;
    private String manager;
    private String cover;

    @Column(name = "name", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'name'", nullable = false, unique = true)
    @MethodOrder(order = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @MethodOrder(order = 3)
    @Column(name = "code", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'code'", nullable = false, unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @MethodOrder(order = 4)
    @Column(name = "parent_id", columnDefinition = "int(11)unsigned  DEFAULT 0 COMMENT 'parent id'", nullable = false)
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @MethodOrder(order = 5)
    @Column(name = "resource_type", columnDefinition = "tinyint(2)  DEFAULT 0 COMMENT 'resource type'", nullable = false)
    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    @MethodOrder(order = 6)
    @Column(name = "open_type", columnDefinition = "varchar(16)  DEFAULT '' COMMENT 'open type'", nullable = false)
    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    @MethodOrder(order = 7)
    @Column(name = "manage_url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'manager url'", nullable = false)
    public String getManageUrl() {
        return manageUrl;
    }

    public void setManageUrl(String manageUrl) {
        this.manageUrl = manageUrl;
    }

    @MethodOrder(order = 8)
    @Column(name = "list_url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'list url'", nullable = false)
    public String getListUrl() {
        return listUrl;
    }

    public void setListUrl(String listUrl) {
        this.listUrl = listUrl;
    }

    @MethodOrder(order = 9)
    @Column(name = "detail_url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'detail url'", nullable = false)
    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    @MethodOrder(order = 9.1F)
    @Column(name = "access_url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'access ico url'", nullable = false, unique = true)
    public String getAccessUrl() {
        return this.accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    @MethodOrder(order = 9.2F)
    @Column(name = "new_url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'new url'", nullable = false)
    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }

    @MethodOrder(order = 10)
    @Column(name = "max_record_count", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'max record count'", nullable = false)
    public Integer getMaxRecordCount() {
        return maxRecordCount;
    }

    public void setMaxRecordCount(Integer maxRecordCount) {
        this.maxRecordCount = maxRecordCount;
    }

    @MethodOrder(order = 11)
    @Column(name = "sort", columnDefinition = "int(11)  DEFAULT 0 COMMENT 'sort'", nullable = false, updatable = false)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @MethodOrder(order = 12)
    @Column(name = "ico_url", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'forum ico url'", nullable = false)
    public String getIcoUrl() {
        return icoUrl;
    }

    public void setIcoUrl(String icoUrl) {
        this.icoUrl = icoUrl;
    }

    @MethodOrder(order = 13)
    @Column(name = "manager", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'manager url'", nullable = false)
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @MethodOrder(order = 16)
    @Column(name = "upload_key", columnDefinition = "varchar(64)  DEFAULT '' COMMENT 'upload key'", nullable = false)
    public String getUploadKey() {
        return uploadKey;
    }

    public void setUploadKey(String uploadKey) {
        this.uploadKey = uploadKey;
    }

    @Column(name = "cover", columnDefinition = "varchar(256)  DEFAULT '' COMMENT 'cover'", nullable = false)
    @MethodOrder(order = 16.1F)
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

}
