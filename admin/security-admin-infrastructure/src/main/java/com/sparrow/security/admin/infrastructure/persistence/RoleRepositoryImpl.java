package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.RoleBO;
import com.sparrow.security.admin.dao.PrivilegeDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.PrivilegeConverter;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.RoleConverter;
import com.sparrow.security.admin.protocol.param.PrivilegeParam;
import com.sparrow.security.admin.repository.RoleRepository;
import com.sparrow.security.admin.dao.RoleDAO;
import com.sparrow.security.po.Privilege;
import com.sparrow.security.po.Role;
import com.sparrow.security.admin.protocol.param.RoleParam;
import com.sparrow.security.admin.protocol.query.RoleQuery;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RoleRepositoryImpl implements RoleRepository {
    @Inject
    private RoleConverter roleConverter;

    @Inject
    private RoleDAO roleDao;

    @Inject
    private PrivilegeDAO privilegeDao;
    @Inject
    private PrivilegeConverter privilegeConverter;

    @Override public Long save(RoleParam roleParam) {
        Role role = this.roleConverter.param2po(roleParam);
        if (role.getId() != null) {
            this.roleDao.update(role);
            return role.getId();
        }
        return this.roleDao.insert(role);
    }

    @Override public int delete(String roleIds) {
        return this.roleDao.batchDelete(roleIds);
    }

    @Override public int disable(String roleIds) {
        StatusCriteria statusCriteria = new StatusCriteria(roleIds, StatusRecord.DISABLE);
        return this.roleDao.changeStatus(statusCriteria);
    }

    @Override public int enable(String roleIds) {
        StatusCriteria statusCriteria = new StatusCriteria(roleIds, StatusRecord.ENABLE);
        return this.roleDao.changeStatus(statusCriteria);
    }

    @Override public RoleBO getRole(Long roleId) {
        Role role = this.roleDao.getEntity(roleId);
        return this.roleConverter.po2bo(role);
    }

    @Override public List<RoleBO> queryRoles(RoleQuery roleQuery) {
        List<Role> roleList = this.roleDao.queryRoles(this.roleConverter.toDbPagerQuery(roleQuery));
        return this.roleConverter.poList2BoList(roleList);
    }

    @Override public Long getRoleCount(RoleQuery roleQuery) {
        return this.roleDao.countRole(this.roleConverter.toDbCountQuery(roleQuery));
    }

    @Override public List<Long> queryAllAccessibleResources(Long roleId) {
        List<Privilege> privileges = this.privilegeDao.queryAllAccessibleResources(roleId);
        return this.roleConverter.privilegeList2ResourceIds(privileges);
    }

    @Override public void resetPrivilege(PrivilegeParam privilegeParam) {
        this.privilegeDao.deleteByRole(privilegeParam.getRoleId());

        List<Privilege> privileges = this.privilegeConverter.param2Privileges(privilegeParam);
        for (Privilege privilege : privileges) {
            this.privilegeDao.insert(privilege);
        }
    }
}