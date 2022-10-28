package com.sparrow.passport.po;

import com.sparrow.protocol.POJO;
import java.util.Date;

public class DataPermission implements POJO {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long parentId;
    private Long appId;
    private String code;
    private String name;
    private Integer sort;
    private Date createdAt;
    private Long createdBy;
    private Integer deleted;
}
