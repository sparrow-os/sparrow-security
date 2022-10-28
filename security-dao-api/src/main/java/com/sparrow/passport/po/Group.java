package com.sparrow.passport.po;

import com.sparrow.protocol.POJO;
import java.util.Date;

public class Group implements POJO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long appId;

  private String appName;

  private Integer sysId;

  private String sysName;

  private String code;
  private String name;
  private String parentText;
  private Integer source;
  private Integer type;
  private Integer trusteeship;
  private Long parentId;
  private Long createdBy;
  private Date createdAt;
  private Integer deleted;
}