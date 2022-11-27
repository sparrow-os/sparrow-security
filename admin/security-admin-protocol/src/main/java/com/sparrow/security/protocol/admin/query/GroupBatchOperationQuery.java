package com.sparrow.security.protocol.admin.query;

public class GroupBatchOperationQuery extends GroupQuery{
    private String groupIds;

    public String getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }
}
