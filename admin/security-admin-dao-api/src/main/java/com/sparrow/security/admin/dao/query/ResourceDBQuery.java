package com.sparrow.security.admin.dao.query;

import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;

public class ResourceDBQuery implements POJO {
    private Long appId;
    private StatusRecord status;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public StatusRecord getStatus() {
        return status;
    }

    public void setStatus(StatusRecord status) {
        this.status = status;
    }
}
