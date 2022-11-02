package com.sparrow.security.dao.admin;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.po.Resource;
import javax.inject.Named;

@Named
public class ResourceDaoImpl extends ORMStrategy<Resource, Long> implements ResourceDAO {
}
