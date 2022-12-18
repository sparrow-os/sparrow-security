package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.security.admin.protocol.param.PrivilegeParam;
import com.sparrow.security.po.Privilege;
import com.sparrow.utility.CollectionsUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;

@Named
public class PrivilegeConverter {
    public List<Privilege> param2Privileges(PrivilegeParam privilegeParam) {
        if (CollectionsUtility.isNullOrEmpty(privilegeParam.getResourceIds())) {
            return Collections.emptyList();
        }
        Long roleId = privilegeParam.getRoleId();
        List<Long> resourceIds = privilegeParam.getResourceIds();
        List<Privilege> privileges = new ArrayList<>(privilegeParam.getResourceIds().size());

        for (Long resourceId : resourceIds) {
            Privilege privilege = new Privilege();
            privilege.setRoleId(roleId);
            privilege.setResourceId(resourceId);
            privileges.add(privilege);
        }
        return privileges;
    }
}
