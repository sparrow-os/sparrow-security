package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;
import lombok.Data;

@Data
public class MicroServiceVO implements VO {
    private Long id;
    private Long appId;
    private String url;
    private String name;
    private String logo;
    private Integer sort;
    private String status;
    private String remark;
    private Integer maxRemarkLength;
}
