package com.sparrow.security.admin.bo;

import com.sparrow.protocol.BO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

@Data
public class GroupBO implements BO {
    private Long groupId;
    private String groupName;
    private Long maxAllowCount;
    private String groupType;
    private String groupIco;
    private String remark;
    private StatusRecord status;
}
