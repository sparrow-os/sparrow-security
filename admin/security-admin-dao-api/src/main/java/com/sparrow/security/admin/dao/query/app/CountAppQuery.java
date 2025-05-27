package com.sparrow.security.admin.dao.query.app;

import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import java.util.Date;

@Data
public class CountAppQuery {
    public CountAppQuery() {
    }

    public CountAppQuery(CountAppQuery countGroupQuery) {
        this.name = countGroupQuery.name;
        this.beginDate = countGroupQuery.beginDate;
        this.endDate = countGroupQuery.endDate;
        this.status = countGroupQuery.status;
    }

    private String name;
    private StatusRecord status;
    private Date beginDate;
    private Date endDate;
}
