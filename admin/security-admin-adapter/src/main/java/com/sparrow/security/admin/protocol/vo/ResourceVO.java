package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;
import lombok.Data;

@Data
public class ResourceVO implements VO {
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
