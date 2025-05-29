package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;
import lombok.Data;

@Data
public class ResourceMenuItemVO implements VO {
    private Long id;
    private Long parentId;
    private String permission;
    private String name;
    private Integer resourceType;
    private String url;
}
