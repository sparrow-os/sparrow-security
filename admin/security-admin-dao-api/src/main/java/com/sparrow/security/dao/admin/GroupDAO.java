package com.sparrow.security.dao.admin;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.dao.admin.query.CountGroupQuery;
import com.sparrow.security.dao.admin.query.PagerGroupQuery;
import com.sparrow.security.po.Group;
import java.util.List;

public interface GroupDAO extends DaoSupport<Group, Long> {
    List<Group> queryGroups(PagerGroupQuery groupPagerQuery);

    Long countGroup(CountGroupQuery countGroupQuery);
}
