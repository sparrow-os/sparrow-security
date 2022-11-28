package com.sparrow.security.admin.repository;

import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.protocol.admin.param.ResourceParam;
import com.sparrow.security.protocol.admin.query.ResourceQuery;
import java.util.List;

public interface ResourceRepository {
     Long save(ResourceParam resourceParam);

     int delete(Long resourceId);

     int disable(Long resourceId);

     int enable(Long groupIds);

     ResourceBO getResource(Long groupId);

     List<ResourceBO> queryResources(ResourceQuery resourceQuery);
}
