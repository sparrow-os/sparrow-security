package com.sparrow.passport.po;

import com.sparrow.protocol.POJO;
import java.util.Date;
public class AuthUserDeptPO implements POJO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long uid;

  private Long orgId;

  private Long deptId;

  private String deptName;

  private String deptFullName;

  private Long groupId;

  private Long appId;

  private Long createdBy;

  private Date createdAt;

  private Integer deleted;

}
