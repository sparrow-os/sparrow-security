package com.sparrow.security.po;

import com.sparrow.protocol.POJO;
import java.util.Date;

public class UserRole implements POJO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long appId;

  private Long uid;

  private Long roleId;

  private Date createdAt;

  private Long createdBy;

}
