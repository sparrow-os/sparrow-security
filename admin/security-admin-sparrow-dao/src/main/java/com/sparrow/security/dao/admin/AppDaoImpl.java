package com.sparrow.security.dao.admin;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.po.App;
import com.sparrow.security.po.Forum;
import javax.inject.Named;

@Named
public class AppDaoImpl extends ORMStrategy<App, Long> implements AppDAO {

}
