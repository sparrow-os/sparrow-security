package com.sparrow.security.admin.dao.query.micro.service;

import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

import java.util.Date;

@Data
public class CountMicroServiceQuery {
    private String name;
    private StatusRecord status;
    private Date beginDate;
    private Date endDate;
}
