package com.sparrow.security.admin.dao.query.role;

import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;
import java.util.Date;

public class CountRoleQuery implements POJO {
    public CountRoleQuery() {
    }

    public CountRoleQuery(String roleName, StatusRecord status, Date beginDate, Date endDate) {
        this.roleName = roleName;
        this.status = status;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    private String roleName;
    private StatusRecord status;
    private Date beginDate;
    private Date endDate;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
