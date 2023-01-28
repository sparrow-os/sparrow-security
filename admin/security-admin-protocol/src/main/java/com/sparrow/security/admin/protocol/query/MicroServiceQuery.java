package com.sparrow.security.admin.protocol.query;

import com.sparrow.protocol.pager.SimplePager;
import java.util.Date;


public class MicroServiceQuery extends SimplePager {
    private String name;
    private Date beginDate;
    private Date endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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