package com.sparrow.passport.po;

import com.sparrow.protocol.POJO;
import java.util.Date;

public class UserGroup implements POJO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long uid;

  private Long groupId;

  private Integer groupType;

  private Long appId;

  private Long createdBy;

  private Date createdAt;

  private Integer isLeader;

  private Integer deleted;
}
