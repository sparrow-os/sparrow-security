package com.sparrow.security.admin.dao.query.role;

import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import java.util.Date;

@Data
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
}
