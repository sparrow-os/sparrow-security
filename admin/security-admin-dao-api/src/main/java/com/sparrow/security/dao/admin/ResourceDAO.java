package com.sparrow.security.dao.admin;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.dao.admin.query.ResourceDBQuery;
import com.sparrow.security.po.Resource;
import java.util.List;

public interface ResourceDAO extends DaoSupport<Resource, Long> {
    Integer sort(Long forumId, int sort);

    List<Resource> queryResources(ResourceDBQuery resourceQuery);
}
