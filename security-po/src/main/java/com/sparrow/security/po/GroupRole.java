package com.sparrow.security.po;

import com.sparrow.protocol.dao.PO;

public class GroupRole extends PO {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long appId;
    private Long groupId;
    private Long roleId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
