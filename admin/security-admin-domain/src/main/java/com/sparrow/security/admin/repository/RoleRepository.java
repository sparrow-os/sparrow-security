package com.sparrow.security.admin.repository;

import com.sparrow.security.admin.bo.RoleBO;
import com.sparrow.security.admin.protocol.param.RoleParam;
import com.sparrow.security.admin.protocol.query.RoleQuery;
import java.util.List;

public interface RoleRepository {
    Long save(RoleParam roleParam);

    int delete(String roleIds);

    int disable(String roleIds);

    int enable(String roleIds);

    RoleBO getRole(Long roleId);

    List<RoleBO> queryRoles(RoleQuery groupQuery);

    Long getRoleCount(RoleQuery groupQuery);

}
