package com.sparrow.security.admin.protocol.param.batch;

import com.sparrow.security.admin.protocol.query.GroupQuery;

public class GroupBatchOperateParam extends GroupQuery {
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
