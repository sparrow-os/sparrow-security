package com.sparrow.security.admin.protocol.param;

import com.sparrow.protocol.Param;

public class GroupParam implements Param {
    private Long groupId;
    private String groupName;
    private Long maxAllowCount;
    private String groupType;
    private String groupIco;
    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
