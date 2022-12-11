package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.DepartmentDAO;
import com.sparrow.security.po.Department;
import javax.inject.Named;

@Named
public class DepartmentDaoImpl extends ORMStrategy<Department, Long> implements DepartmentDAO {
}
