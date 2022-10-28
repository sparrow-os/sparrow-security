package com.sparrow.security.po;

import com.sparrow.protocol.POJO;
import java.util.Date;

public class AuthGroupVisiblePO implements POJO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long appId;

  private Long uid;

  private Long groupId;

  private Long visibleGroupId;

  private Long createdBy;

  private Date createdAt;

  private Integer deleted;
}
