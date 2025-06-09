package com.sparrow.security.admin.bo;

import com.sparrow.protocol.BO;
import lombok.Data;

@Data
public class ResourceBO implements BO {
    private Long id;
    private Long appId;
    private String permission;
    private String name;
    private Long parentId;
    private Integer resourceType;
    private String openType;
    private String url;
    private String method;
    private String icoUrl;
    private Integer sort;
    private String remark;
}
