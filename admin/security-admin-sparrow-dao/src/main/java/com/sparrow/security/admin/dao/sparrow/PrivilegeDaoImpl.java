package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.PrivilegeDAO;
import com.sparrow.security.po.Privilege;
import javax.inject.Named;

@Named
public class PrivilegeDaoImpl extends ORMStrategy<Privilege, Long> implements PrivilegeDAO {
}
