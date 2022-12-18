package com.sparrow.security.admin.protocol.vo;

import com.sparrow.protocol.VO;
import java.util.List;

public class PrivilegeWrapVO implements VO {
    private List<ResourceMenuItemVO> allResources;
    private List<Long> selectedResourceIds;

    public List<ResourceMenuItemVO> getAllResources() {
        return allResources;
    }

    public void setAllResources(List<ResourceMenuItemVO> allResources) {
        this.allResources = allResources;
    }

    public List<Long> getSelectedResourceIds() {
        return selectedResourceIds;
    }

    public void setSelectedResourceIds(List<Long> selectedResourceIds) {
        this.selectedResourceIds = selectedResourceIds;
    }
}
