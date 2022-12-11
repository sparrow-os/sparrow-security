package com.sparrow.security.admin.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.admin.dao.query.ResourceDBQuery;
import com.sparrow.security.po.Resource;
import java.util.List;

public interface ResourceDAO extends DaoSupport<Resource, Long> {
    Integer sort(Long resourceId, int sort);

    Integer resort(Long parentResourceId, Integer currentSort);


    Integer maxSort(Long parentResourceId);

    List<Resource> queryResources(ResourceDBQuery resourceQuery);
}
