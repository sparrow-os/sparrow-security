package com.sparrow.security.admin.assemble;

import com.sparrow.security.admin.protocol.vo.ResourceMenuItemVO;
import com.sparrow.security.admin.protocol.vo.ResourceVO;
import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.admin.protocol.param.ResourceParam;
import com.sparrow.support.assemble.BO2VOAssemble;
import com.sparrow.support.assemble.Param2VOAssemble;
import com.sparrow.utility.BeanUtility;
import com.sparrow.utility.CollectionsUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;

@Named
public class ResourceAssemble implements BO2VOAssemble<ResourceVO, ResourceBO>,
    Param2VOAssemble<ResourceVO, ResourceParam> {

    public ResourceVO paramAssembleVO(ResourceParam param) {
        ResourceVO resource = new ResourceVO();
        BeanUtility.copyProperties(param, resource);
        return resource;
    }

    public ResourceVO boAssembleVO(ResourceBO bo) {
        ResourceVO resource = new ResourceVO();
        BeanUtility.copyProperties(bo, resource);
        return resource;
    }

    @Override public List<ResourceVO> boListAssembleVOList(List<ResourceBO> list) {
        throw new RuntimeException("not support method");
    }

    public ResourceMenuItemVO boAssembleItemVO(ResourceBO bo) {
        ResourceMenuItemVO itemVO = new ResourceMenuItemVO();
        BeanUtility.copyProperties(bo, itemVO);
        return itemVO;
    }

    public List<ResourceVO> boListAssembleItemVOList(List<ResourceBO> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<ResourceVO> resourceVos = new ArrayList<>(list.size());
        for (ResourceBO resource : list) {
            resourceVos.add(this.boAssembleVO(resource));
        }
        return resourceVos;
    }
}
