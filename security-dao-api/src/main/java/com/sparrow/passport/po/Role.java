package com.sparrow.passport.po;

import com.sparrow.protocol.POJO;
import java.io.Serializable;
import java.util.Date;

public class Role implements POJO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long appId;

  private String appCode;

  private String code;

  private String name;

  private Integer sort;

  private String remark;

  private Long createdBy;

  private Date createdAt;

  private Date modifiedAt;

  private Integer deleted;

  private String appName;
}
