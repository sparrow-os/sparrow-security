package com.sparrow.security.admin.bo;

import com.sparrow.protocol.BO;
import com.sparrow.protocol.enums.StatusRecord;
import lombok.Data;

@Data
public class AppBO implements BO {
    private Long id;
    private String code;
    private String name;
    private String logo;
    private Integer sort;
    private StatusRecord status;
    private String remark;
}
