package com.sparrow.security.admin.repository;

import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.protocol.admin.param.GroupParam;

public interface GroupRepository {
    Long save(GroupParam groupParam);

    int delete(String groupIds);

    int disable(String groupIds);

    int enable(String groupIds);

    GroupBO getGroup(Long groupId);
}
