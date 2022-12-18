package com.sparrow.security.admin.assemble;

import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.admin.protocol.vo.PrivilegeWrapVO;
import com.sparrow.security.admin.protocol.vo.ResourceMenuItemVO;
import com.sparrow.utility.BeanUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named
public class PrivilegeAssemble {

    public ResourceMenuItemVO boAssembleItemVO(ResourceBO bo) {
        ResourceMenuItemVO itemVO = new ResourceMenuItemVO();
        BeanUtility.copyProperties(bo, itemVO);
        return itemVO;
    }

    public List<ResourceMenuItemVO> boListAssembleItemVOList(List<ResourceBO> resourceBos) {
        List<ResourceMenuItemVO> resourceMenuItems = new ArrayList<>(resourceBos.size());
        for (ResourceBO resourceBo : resourceBos) {
            resourceMenuItems.add(this.boAssembleItemVO(resourceBo));
        }
        return resourceMenuItems;
    }

    public PrivilegeWrapVO wrap(List<ResourceBO> resources, List<Long> allAccessibleResources) {
        List<ResourceMenuItemVO> allResources = this.boListAssembleItemVOList(resources);
        PrivilegeWrapVO privilegeWrap = new PrivilegeWrapVO();
        privilegeWrap.setAllResources(allResources);
        privilegeWrap.setSelectedResourceIds(allAccessibleResources);
        return privilegeWrap;
    }
}
