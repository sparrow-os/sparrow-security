package com.sparrow.security.admin.dao.query.group;

import java.util.Date;

public class CountGroupQuery {
    public CountGroupQuery() {
    }

    private String groupName;
    private Date beginDate;
    private Date endDate;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
