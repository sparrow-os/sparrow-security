package com.sparrow.security.dao.admin;

import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.po.Forum;
import com.sparrow.security.po.Resource;
import javax.inject.Named;

@Named
public class ForumDaoImpl extends ORMStrategy<Forum, Long> implements ForumDAO {
}
