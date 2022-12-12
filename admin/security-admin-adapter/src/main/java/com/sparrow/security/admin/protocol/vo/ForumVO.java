package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;

public class ForumVO implements VO {

    /**
     * 资源 ID
     */
    private Long resourceId;
    /**
     * 版本前台列表对应的url
     */
    private String listUrl;
    /**
     * 版本后台管理新建对应的url
     */
    private String newUrl;
    /**
     * 版本前台展示详情页对应url
     */
    private String detailUrl;
    /**
     * cms-{100}.do 访问的url placeholder
     * <p>
     * cms-manage.do?forumCode=100
     */
    private String placeholderUrl;
    /**
     * 上传的key 由文件上传服务提供
     */
    private String uploadKey;
    /**
     * 版块的封面图
     */
    private String cover;
    /**
     * 版本的管理员
     */
    private String manager;
    /**
     * 版块最大的记录数
     */
    private Integer maxRecordCount;
    private String status;
    private String remark;
    private Integer maxRemarkLength;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getMaxRemarkLength() {
        return maxRemarkLength;
    }

    public void setMaxRemarkLength(Integer maxRemarkLength) {
        this.maxRemarkLength = maxRemarkLength;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getListUrl() {
        return listUrl;
    }

    public void setListUrl(String listUrl) {
        this.listUrl = listUrl;
    }

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getPlaceholderUrl() {
        return placeholderUrl;
    }

    public void setPlaceholderUrl(String placeholderUrl) {
        this.placeholderUrl = placeholderUrl;
    }

    public String getUploadKey() {
        return uploadKey;
    }

    public void setUploadKey(String uploadKey) {
        this.uploadKey = uploadKey;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getMaxRecordCount() {
        return maxRecordCount;
    }

    public void setMaxRecordCount(Integer maxRecordCount) {
        this.maxRecordCount = maxRecordCount;
    }
}