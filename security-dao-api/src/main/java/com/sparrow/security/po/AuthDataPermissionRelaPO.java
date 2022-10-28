package com.sparrow.security.po;

import com.sparrow.protocol.POJO;
import java.util.Date;

public class AuthDataPermissionRelaPO implements POJO {
  private static final long serialVersionUID = 1L;
  private Long id;

  private Long permissionId;

  private String permissionName;

  private Long groupId;

  private Long appId;

  private String groupName;

  private Long permissionDataId;

  private String permissionDataName;

  private Date createdAt;

  private Long createdBy;

  private Integer deleted;

  private String code;

  private Long uid;

  private String name;
}
