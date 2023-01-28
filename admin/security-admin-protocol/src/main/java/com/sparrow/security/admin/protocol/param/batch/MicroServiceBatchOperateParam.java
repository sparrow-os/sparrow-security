package com.sparrow.security.admin.protocol.param.batch;

import com.sparrow.security.admin.protocol.query.MicroServiceQuery;

public class MicroServiceBatchOperateParam extends MicroServiceQuery {
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
