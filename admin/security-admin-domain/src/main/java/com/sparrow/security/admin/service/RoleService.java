package com.sparrow.security.admin.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.security.admin.bo.RoleBO;
import com.sparrow.security.admin.protocol.param.PrivilegeParam;
import com.sparrow.security.admin.repository.RoleRepository;
import com.sparrow.security.admin.protocol.enums.SecurityAdminError;
import com.sparrow.security.admin.protocol.param.RoleParam;
import com.sparrow.security.admin.protocol.query.RoleQuery;
import com.sparrow.utility.CollectionsUtility;
import com.sparrow.utility.StringUtility;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RoleService {
    @Inject
    private RoleRepository roleRepository;

    private void validateGroup(RoleParam roleParam) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(roleParam.getName()), SecurityAdminError.ROLE_NAME_IS_EMPTY);
        Asserts.isTrue(StringUtility.isNullOrEmpty(roleParam.getCode()), SecurityAdminError.ROLE_CODE_IS_EMPTY);
    }

    public Long saveRole(RoleParam roleParam) throws BusinessException {
        this.validateGroup(roleParam);
        return this.roleRepository.save(roleParam);
    }

    public Integer deleteRole(String roleIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(roleIds), SecurityAdminError.ROLE_ID_IS_EMPTY);
        return this.roleRepository.delete(roleIds);
    }

    public Integer enableRole(String roleIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(roleIds), SecurityAdminError.ROLE_ID_IS_EMPTY);
        return this.roleRepository.enable(roleIds);
    }

    public Integer disableRole(String roleIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(roleIds), SecurityAdminError.ROLE_ID_IS_EMPTY);
        return this.roleRepository.disable(roleIds);
    }

    public ListRecordTotalBO<RoleBO> queryAllRole() {
        return queryRole(null);
    }

    public ListRecordTotalBO<RoleBO> queryRole(RoleQuery roleQuery) {
        Long totalRecord = this.roleRepository.getRoleCount(roleQuery);
        List<RoleBO> roleBoList = null;
        if (totalRecord > 0) {
            roleBoList = this.roleRepository.queryRoles(roleQuery);
        }
        return new ListRecordTotalBO<>(roleBoList, totalRecord);
    }

    public RoleBO getRole(Long roleId) throws BusinessException {
        Asserts.isTrue(roleId == null, SecurityAdminError.ROLE_ID_IS_EMPTY);
        return this.roleRepository.getRole(roleId);
    }

    public List<Long> queryAllAccessibleResources(Long roleId) throws BusinessException {
        Asserts.isTrue(roleId == null, SecurityAdminError.ROLE_ID_IS_EMPTY);
        return this.roleRepository.queryAllAccessibleResources(roleId);
    }

    public void resetPrivilege(PrivilegeParam privilegeParam) throws BusinessException {
        Asserts.isTrue(privilegeParam.getRoleId() == null, SecurityAdminError.ROLE_ID_IS_EMPTY);
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(privilegeParam.getResourceIds()), SecurityAdminError.PRIVILEGE_IS_EMPTY);
        this.roleRepository.resetPrivilege(privilegeParam);
    }
}
