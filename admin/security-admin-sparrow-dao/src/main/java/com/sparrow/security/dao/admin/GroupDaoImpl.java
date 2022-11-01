package com.sparrow.security.dao.admin;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.po.Group;
import javax.inject.Named;

@Named
public class GroupDaoImpl extends ORMStrategy<Group, Long> implements GroupDAO {
}
