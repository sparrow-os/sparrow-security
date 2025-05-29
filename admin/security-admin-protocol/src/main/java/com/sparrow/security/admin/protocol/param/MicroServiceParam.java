package com.sparrow.security.admin.protocol.param;

import com.sparrow.protocol.Param;
import lombok.Data;

@Data
public class MicroServiceParam implements Param {
    private Long id;
    private Long appId;
    private String name;
    private String url;
    private String logo;
    private Integer sort;
    private String remark;
}
