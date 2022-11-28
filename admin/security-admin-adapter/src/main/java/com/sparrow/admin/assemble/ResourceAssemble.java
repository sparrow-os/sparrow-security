package com.sparrow.admin.assemble;

import com.sparrow.admin.protocol.admin.vo.ResourceMenuItemVO;
import com.sparrow.admin.protocol.admin.vo.ResourceVO;
import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.utility.BeanUtility;
import com.sparrow.utility.CollectionsUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;

@Named
public class ResourceAssemble {

    public ResourceVO boAssembleVO(ResourceBO bo) {
        ResourceVO itemVO = new ResourceVO();
        BeanUtility.copyProperties(bo, itemVO);
        return itemVO;
    }

    public ResourceMenuItemVO boAssembleItemVO(ResourceBO bo) {
        ResourceMenuItemVO itemVO = new ResourceMenuItemVO();
        BeanUtility.copyProperties(bo, itemVO);
        return itemVO;
    }

    public List<ResourceMenuItemVO> boListAssembleItemVOList(List<ResourceBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<ResourceMenuItemVO> menuItems = new ArrayList<>(list.size());
        for (ResourceBO resource : list) {
            menuItems.add(this.boAssembleItemVO(resource));
        }
        return menuItems;
    }
}
