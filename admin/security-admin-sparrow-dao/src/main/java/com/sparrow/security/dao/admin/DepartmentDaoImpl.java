package com.sparrow.security.dao.admin;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.po.Department;
import javax.inject.Named;

@Named
public class DepartmentDaoImpl extends ORMStrategy<Department, Long> implements DepartmentDAO {
}
