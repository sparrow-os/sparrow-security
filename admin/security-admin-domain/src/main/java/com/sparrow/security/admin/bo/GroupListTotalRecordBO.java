package com.sparrow.security.admin.bo;

import java.util.List;

public class GroupListTotalRecordBO {
    public GroupListTotalRecordBO(List<GroupBO> groups, Long totalRecord) {
        this.groups = groups;
        this.totalRecord = totalRecord;
    }

    private List<GroupBO> groups;
    private Long totalRecord;

    public List<GroupBO> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupBO> groups) {
        this.groups = groups;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }
}
