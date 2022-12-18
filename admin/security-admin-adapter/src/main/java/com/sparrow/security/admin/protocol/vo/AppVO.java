package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;

public class AppVO implements VO {
    private Long id;
    private String code;
    private String name;
    private String logo;
    private Integer sort;
    private String status;
    private String remark;

    private Integer maxRemarkLength;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
