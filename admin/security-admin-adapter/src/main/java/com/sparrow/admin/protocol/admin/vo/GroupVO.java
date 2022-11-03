package com.sparrow.admin.protocol.admin.vo;

import com.sparrow.protocol.VO;

public class GroupVO implements VO {
    private Long groupId;
    private Long parentGroupId;
    private String groupName;
    private Long maxAllowCount;
    private String groupType;
    private Integer groupLevel;
    private String groupIco;
}
