package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.RoleStrategyDAO;
import com.sparrow.security.po.RoleStrategy;
import javax.inject.Named;

@Named
public class GroupStrategyDaoImpl extends ORMStrategy<RoleStrategy, Long> implements RoleStrategyDAO {
}
