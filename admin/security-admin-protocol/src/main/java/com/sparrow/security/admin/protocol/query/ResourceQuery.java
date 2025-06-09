package com.sparrow.security.admin.protocol.query;

import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.protocol.pager.SimplePager;
import lombok.Data;

import java.util.Date;

@Data
public class ResourceQuery implements POJO {
    private Long appId;
    private StatusRecord status;
}
