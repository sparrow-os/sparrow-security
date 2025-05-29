package com.sparrow.security.admin.protocol.param;

import lombok.Data;

import java.util.List;

@Data
public class PrivilegeParam {
    private Long roleId;
    private List<Long> resourceIds;
}
