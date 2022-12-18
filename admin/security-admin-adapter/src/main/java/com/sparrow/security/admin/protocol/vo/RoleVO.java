package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;

public class RoleVO implements VO {
    private Long id;
    private Long appId;
    private String code;
    private String name;
    private Integer sort;
    private String remark;
    private String status;
    private Integer maxRemarkLength;
    private String appName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMaxRemarkLength() {
        return maxRemarkLength;
    }

    public void setMaxRemarkLength(Integer maxRemarkLength) {
        this.maxRemarkLength = maxRemarkLength;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
