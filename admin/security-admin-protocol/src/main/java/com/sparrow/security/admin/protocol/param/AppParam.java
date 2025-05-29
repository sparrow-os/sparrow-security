package com.sparrow.security.admin.protocol.param;

import com.sparrow.protocol.Param;
import lombok.Data;

@Data
public class AppParam implements Param {
    private Long id;
    private String code;
    private String name;
    private String logo;
    private Integer sort;
    private String remark;
}
