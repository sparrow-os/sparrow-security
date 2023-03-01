package com.sparrow.security.admin.controller;

import com.sparrow.security.admin.assemble.ResourceAssemble;
import com.sparrow.security.admin.protocol.vo.ResourceVO;
import com.sparrow.protocol.BusinessException;
import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.admin.service.ResourceService;
import com.sparrow.security.admin.protocol.param.ResourceParam;
import com.sparrow.security.admin.protocol.param.ResourceSortParam;
import com.sparrow.security.admin.protocol.query.ResourceQuery;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resource")
public class ResourceController {

    @Inject
    private ResourceService resourceService;

    @Inject
    private ResourceAssemble resourceControllerAssemble;

    @PostMapping("load-all.json")
    public List<ResourceVO> loadAllResources(ResourceQuery resourceQuery) {
        List<ResourceBO> resources = this.resourceService.queryResources(resourceQuery);
        return this.resourceControllerAssemble.boListAssembleVoList(resources);
    }

    @PostMapping("save")
    public ResourceVO saveResource(ResourceParam resourceParam) throws BusinessException {
//        int i=1/0;
        resourceService.saveResource(resourceParam);
        return this.resourceControllerAssemble.paramAssembleVO(resourceParam);
    }

    @GetMapping("get")
    public ResourceVO getResource(Long resourceId) throws BusinessException {
        ResourceBO resourceBo = resourceService.getResource(resourceId);
        return this.resourceControllerAssemble.boAssembleVO(resourceBo);
    }

    @PostMapping("delete")
    public Integer delGroup(Long resourceId) throws BusinessException {
        return resourceService.deleteResource(resourceId);
    }

    @PostMapping("enable")
    public Integer enableGroup(Long resourceId) throws BusinessException {
        return this.resourceService.enableResource(resourceId);
    }

    @PostMapping("disable")
    public Integer disableGroup(Long resourceId) throws BusinessException {
        return this.resourceService.disableGroup(resourceId);
    }

    @PostMapping("sort")
    public Integer sort(ResourceSortParam sortParam) throws BusinessException {
        return this.resourceService.sort(sortParam);
    }
}
