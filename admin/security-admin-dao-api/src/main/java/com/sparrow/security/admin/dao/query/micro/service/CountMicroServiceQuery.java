package com.sparrow.security.admin.dao.query.micro.service;

import com.sparrow.protocol.enums.StatusRecord;
import java.util.Date;

public class CountMicroServiceQuery {
    private String name;
    private StatusRecord status;
    private Date beginDate;
    private Date endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusRecord getStatus() {
        return status;
    }

    public void setStatus(StatusRecord status) {
        this.status = status;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
