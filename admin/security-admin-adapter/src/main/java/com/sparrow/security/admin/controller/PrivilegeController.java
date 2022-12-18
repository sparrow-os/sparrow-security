package com.sparrow.security.admin.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.security.admin.assemble.PrivilegeAssemble;
import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.admin.protocol.param.PrivilegeParam;
import com.sparrow.security.admin.protocol.vo.PrivilegeWrapVO;
import com.sparrow.security.admin.service.ResourceService;
import com.sparrow.security.admin.service.RoleService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivilegeController {
    @Inject
    private ResourceService resourceService;
    @Inject
    private RoleService roleService;

    @Inject
    private PrivilegeAssemble privilegeAssemble;

    @PostMapping("/role/privilege")
    public PrivilegeWrapVO loadPrivilege(Long roleId) throws BusinessException {
        List<ResourceBO> resources = this.resourceService.queryAllEnableResources();
        List<Long> allAccessibleResources = this.roleService.queryAllAccessibleResources(roleId);
        return this.privilegeAssemble.wrap(resources, allAccessibleResources);
    }

    @PostMapping("/privilege/set")
    public Boolean set(PrivilegeParam privilegeParam) throws BusinessException {
        this.roleService.resetPrivilege(privilegeParam);
        return true;
    }
}
