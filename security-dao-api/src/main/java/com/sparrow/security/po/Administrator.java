package com.sparrow.security.po;

import com.sparrow.protocol.POJO;
import java.util.Date;

public class Administrator implements POJO {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long appId;
    private Long userId;
    private String appName;
    private Integer deleted;
    private Long createdBy;
    private Date createdAt;
}
