package com.sparrow.security.dao.admin;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.po.Forum;
import com.sparrow.security.po.Role;
import javax.inject.Named;

@Named
public class RoleDaoImpl extends ORMStrategy<Role, Long> implements RoleDAO {
}
