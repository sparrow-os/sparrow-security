package com.sparrow.security.admin.protocol.param;

import com.sparrow.protocol.Param;
import lombok.Data;

@Data
public class RoleParam implements Param {
    private Long id;
    private Long appId;
    private String code;
    private String name;
    private Integer sort;
    private String remark;
}
