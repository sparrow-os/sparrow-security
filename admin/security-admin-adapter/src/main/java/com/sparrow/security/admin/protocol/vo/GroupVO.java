package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;
import lombok.Data;

@Data
public class GroupVO implements VO {
    private Long groupId;
    private String groupName;
    private Long maxAllowCount;
    private String groupType;
    private String groupIco;
    private String status;
    private String remark;
    private Integer maxRemarkLength;
}
