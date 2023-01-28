package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;

public class MicroServiceVO implements VO {
    private Long id;
    private Long appId;
    private String url;
    private String name;
    private String logo;
    private Integer sort;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}