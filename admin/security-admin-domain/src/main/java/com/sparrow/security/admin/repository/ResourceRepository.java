package com.sparrow.security.admin.repository;

import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.admin.protocol.param.ResourceParam;
import com.sparrow.security.admin.protocol.param.ResourceSortParam;
import com.sparrow.security.admin.protocol.query.ResourceQuery;
import java.util.List;

public interface ResourceRepository {
     Long save(ResourceParam resourceParam);

     int delete(Long resourceId);

     int disable(Long resourceId);

     int sort(ResourceSortParam sortParam);

     int enable(Long groupIds);

     ResourceBO getResource(Long groupId);

     List<ResourceBO> queryResources(ResourceQuery resourceQuery);

     List<ResourceBO> queryAllEnableResources();

     Integer resort(Long parentResourceId, Integer currentSort);

     Integer maxSort(Long parentResourceId);
}
