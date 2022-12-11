package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.AppDAO;
import com.sparrow.security.po.App;
import javax.inject.Named;

@Named
public class AppDaoImpl extends ORMStrategy<App, Long> implements AppDAO {

}
