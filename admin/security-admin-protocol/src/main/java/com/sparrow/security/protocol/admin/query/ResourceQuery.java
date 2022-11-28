package com.sparrow.security.protocol.admin.query;

import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.protocol.pager.SimplePager;
import java.util.Date;

public class ResourceQuery implements POJO {
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
