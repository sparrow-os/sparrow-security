package com.sparrow.security.dao.admin.query;

import com.sparrow.protocol.POJO;

public class ResourceDBQuery implements POJO {
    private Long appId;
    private String status;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
