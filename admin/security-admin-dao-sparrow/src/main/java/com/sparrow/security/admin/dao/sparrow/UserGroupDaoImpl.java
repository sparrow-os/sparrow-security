package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.UserGroupDAO;
import com.sparrow.security.po.UserGroup;
import javax.inject.Named;

@Named
public class UserGroupDaoImpl extends ORMStrategy<UserGroup, Long> implements UserGroupDAO {
}
