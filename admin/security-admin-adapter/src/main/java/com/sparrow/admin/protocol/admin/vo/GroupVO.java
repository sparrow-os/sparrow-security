package com.sparrow.admin.protocol.admin.vo;

import com.sparrow.protocol.VO;

public class GroupVO implements VO {
    private Long groupId;
    private Long parentGroupId;
    private String groupName;
    private Long maxAllowCount;
    private String groupType;
    private String groupIco;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(Long parentGroupId) {
        this.parentGroupId = parentGroupId;
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
}
