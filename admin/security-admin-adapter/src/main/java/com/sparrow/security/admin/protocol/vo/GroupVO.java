package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;

public class GroupVO implements VO {
    private Long groupId;
    private String groupName;
    private Long maxAllowCount;
    private String groupType;
    private String groupIco;
    private String status;
    private String remark;
    private Integer maxRemarkLength;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getMaxAllowCount() {
        return maxAllowCount;
    }

    public void setMaxAllowCount(Long maxAllowCount) {
        this.maxAllowCount = maxAllowCount;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupIco() {
        return groupIco;
    }

    public void setGroupIco(String groupIco) {
        this.groupIco = groupIco;
    }

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
}
