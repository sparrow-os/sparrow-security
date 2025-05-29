package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;
import lombok.Data;

import java.util.List;

@Data
public class PrivilegeWrapVO implements VO {
    private List<ResourceMenuItemVO> allResources;
    private List<Long> selectedResourceIds;
}
