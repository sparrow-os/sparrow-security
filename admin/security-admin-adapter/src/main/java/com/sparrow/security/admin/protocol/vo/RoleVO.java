package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;
import lombok.Data;

@Data
public class RoleVO implements VO {
    private Long id;
    private Long appId;
    private String code;
    private String name;
    private Integer sort;
    private String remark;
    private String status;
    private Integer maxRemarkLength;
    private String appName;
}
