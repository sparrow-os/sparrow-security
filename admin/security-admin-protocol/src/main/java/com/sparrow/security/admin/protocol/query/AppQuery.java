package com.sparrow.security.admin.protocol.query;

import com.sparrow.protocol.pager.SimplePager;
import lombok.Data;

import java.util.Date;

@Data
public class AppQuery extends SimplePager {
    private String name;
    private String status;
    private Date beginDate;
    private Date endDate;
}
