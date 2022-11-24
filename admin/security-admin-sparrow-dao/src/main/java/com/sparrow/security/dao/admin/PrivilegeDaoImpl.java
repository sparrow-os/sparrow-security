package com.sparrow.security.dao.admin;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.po.Department;
import com.sparrow.security.po.Privilege;
import javax.inject.Named;

@Named
public class PrivilegeDaoImpl extends ORMStrategy<Privilege, Long> implements PrivilegeDAO {
}
