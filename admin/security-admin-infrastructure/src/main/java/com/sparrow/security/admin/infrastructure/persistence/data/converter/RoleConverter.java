package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.dao.DatabasePagerQuery;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.RoleBO;
import com.sparrow.security.admin.dao.query.role.CountRoleQuery;
import com.sparrow.security.admin.dao.query.role.PagerRoleQuery;
import com.sparrow.security.admin.protocol.param.RoleParam;
import com.sparrow.security.admin.protocol.query.RoleQuery;
import com.sparrow.security.po.Privilege;
import com.sparrow.security.po.Role;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.utility.BeanUtility;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class RoleConverter implements Param2POConverter<RoleParam, Role>, PO2BOConverter<RoleBO, Role> {
    public PagerRoleQuery toDbPagerQuery(RoleQuery roleQuery) {
        if (roleQuery == null) {
           return new PagerRoleQuery();
        }
        DatabasePagerQuery pagerQuery = new DatabasePagerQuery(roleQuery.getPageSize(), roleQuery.getPageNo());
        PagerRoleQuery pagerRoleQuery = new PagerRoleQuery();
        this.fullProperties(roleQuery, pagerRoleQuery);
        pagerRoleQuery.setPager(pagerQuery);
        return pagerRoleQuery;
    }

    private void fullProperties(RoleQuery roleQuery, CountRoleQuery countRoleQuery) {
        if (roleQuery == null) {
            return;
        }
        BeanUtility.copyProperties(roleQuery, countRoleQuery);
        if (roleQuery.getStatus() != null) {
            countRoleQuery.setStatus(StatusRecord.valueOf(roleQuery.getStatus()));
        }
    }

    public CountRoleQuery toDbCountQuery(RoleQuery roleQuery) {
        CountRoleQuery countRoleQuery = new CountRoleQuery();
        if (roleQuery == null) {
            return countRoleQuery;
        }
        this.fullProperties(roleQuery, countRoleQuery);
        return countRoleQuery;
    }

    @Override public Role param2po(RoleParam param) {
        Role role = new Role();
        BeanUtility.copyProperties(param, role);
        LoginUser loginToken = ThreadContext.getLoginToken();
        role.setCreateUserId(loginToken.getUserId());
        role.setModifiedUserId(loginToken.getUserId());
        role.setGmtCreate(System.currentTimeMillis());
        role.setGmtModified(role.getGmtModified());
        role.setStatus(StatusRecord.ENABLE);
        return role;
    }

    @Override public RoleBO po2bo(Role role) {
        if (role == null) {
            return null;
        }
        RoleBO roleBo = new RoleBO();
        BeanUtility.copyProperties(role, roleBo);
        return roleBo;
    }

    @Override public List<RoleBO> poList2BoList(List<Role> list) {
        List<RoleBO> roleBos = new ArrayList<>(list.size());
        for (Role role : list) {
            roleBos.add(this.po2bo(role));
        }
        return roleBos;
    }

    public List<Long> privilegeList2ResourceIds(List<Privilege> privileges) {
        List<Long> resourceIds = new ArrayList<>(privileges.size());
        for (Privilege privilege : privileges) {
            resourceIds.add(privilege.getResourceId());
        }
        return resourceIds;
    }
}
