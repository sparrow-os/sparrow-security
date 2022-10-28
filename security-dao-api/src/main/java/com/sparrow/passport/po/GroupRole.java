package com.sparrow.passport.po;

import com.sparrow.protocol.POJO;
import java.util.Date;

public class GroupRole implements POJO {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long appId;

    private Long groupId;

    private Long roleId;

    private String roleCode;

    private Long inheritGroupId;

    private Integer deleted;

    private Long createdBy;

    private Date createdAt;

    private String groupName;
}
