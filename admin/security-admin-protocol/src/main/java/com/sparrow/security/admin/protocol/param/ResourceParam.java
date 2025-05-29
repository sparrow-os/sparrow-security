package com.sparrow.security.admin.protocol.param;

import com.sparrow.protocol.Param;
import lombok.Data;

@Data
public class ResourceParam implements Param {
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
