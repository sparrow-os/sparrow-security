package com.sparrow.security.admin.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.admin.dao.query.role.CountRoleQuery;
import com.sparrow.security.admin.dao.query.role.PagerRoleQuery;
import com.sparrow.security.po.Role;
import java.util.List;

public interface RoleDAO extends DaoSupport<Role, Long> {
    List<Role> queryRoles(PagerRoleQuery pagerRoleQuery);

    Long countRole(CountRoleQuery countRoleQuery);
}
