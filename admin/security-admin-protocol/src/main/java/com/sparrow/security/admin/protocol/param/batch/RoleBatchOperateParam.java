package com.sparrow.security.admin.protocol.param.batch;

import com.sparrow.security.admin.protocol.query.RoleQuery;

public class RoleBatchOperateParam extends RoleQuery {
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
