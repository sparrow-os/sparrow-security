package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.GroupRoleDAO;
import com.sparrow.security.po.GroupRole;
import javax.inject.Named;

@Named
public class GroupRoleDaoImpl extends ORMStrategy<GroupRole, Long> implements GroupRoleDAO {
}
