package com.sparrow.security.dao.admin;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.po.GroupRole;
import com.sparrow.security.po.RoleStrategy;
import javax.inject.Named;

@Named
public class GroupStrategyDaoImpl extends ORMStrategy<RoleStrategy, Long> implements RoleStrategyDAO {
}
