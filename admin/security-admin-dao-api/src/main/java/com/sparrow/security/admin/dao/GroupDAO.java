package com.sparrow.security.admin.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.admin.dao.query.group.CountGroupQuery;
import com.sparrow.security.admin.dao.query.group.PagerGroupQuery;
import com.sparrow.security.po.Group;
import java.util.List;

public interface GroupDAO extends DaoSupport<Group, Long> {
    List<Group> queryGroups(PagerGroupQuery groupPagerQuery);

    Long countGroup(CountGroupQuery countGroupQuery);
}
