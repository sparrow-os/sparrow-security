package com.sparrow.security.admin.protocol.param;

import java.util.List;

public class PrivilegeParam {
    private Long roleId;
    private List<Long> resourceIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<Long> resourceIds) {
        this.resourceIds = resourceIds;
    }
}
