package com.sparrow.security.admin.protocol.query;

public class GroupBatchOperationQuery extends GroupQuery{
    private String groupIds;

    public String getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }
}
