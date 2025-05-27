package com.sparrow.security.admin.dao.query.group;

import lombok.Data;

import java.util.Date;

@Data
public class CountGroupQuery {
    public CountGroupQuery() {
    }

    private String groupName;
    private Date beginDate;
    private Date endDate;
}
