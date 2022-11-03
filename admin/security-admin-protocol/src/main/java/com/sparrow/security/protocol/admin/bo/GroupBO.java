package com.sparrow.security.protocol.admin.bo;

import com.sparrow.protocol.BO;

public class GroupBO implements BO {
    private Long groupId;
    private Long parentGroupId;
    private String groupName;
    private Long maxAllowCount;
    private String groupType;
    private Integer groupLevel;
    private String groupIco;
}
