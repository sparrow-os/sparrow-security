package com.sparrow.security.admin.protocol.param;

import com.sparrow.protocol.Param;
import lombok.Data;

@Data
public class GroupParam implements Param {
    private Long groupId;
    private String groupName;
    private Long maxAllowCount;
    private String groupType;
    private String groupIco;
    private String remark;
}
