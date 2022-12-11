package com.sparrow.security.admin.protocol.query;

import com.sparrow.protocol.pager.SimplePager;
import java.util.Date;

public class GroupQuery extends SimplePager {
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
