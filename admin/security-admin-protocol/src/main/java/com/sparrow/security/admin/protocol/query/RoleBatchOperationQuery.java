package com.sparrow.security.admin.protocol.query;

public class RoleBatchOperationQuery extends RoleQuery{
    private String roleIds;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }
}
