package com.sparrow.security.dao.admin;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.po.Department;
import com.sparrow.security.po.User;
import com.sparrow.security.po.UserGroup;
import javax.inject.Named;

@Named
public class UserGroupDaoImpl extends ORMStrategy<UserGroup, Long> implements UserGroupDAO {
}
