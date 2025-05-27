package com.sparrow.security.admin.dao.query;

import com.sparrow.protocol.POJO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

@Data
public class ResourceDBQuery implements POJO {
    private Long appId;
    private Long microServiceId;
    private StatusRecord status;
}
