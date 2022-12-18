package com.sparrow.security.admin.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.po.Privilege;
import java.util.List;

public interface PrivilegeDAO extends DaoSupport<Privilege, Long> {
    List<Privilege> queryAllAccessibleResources(Long roleId);

    Integer deleteByRole(Long roleId);
}
