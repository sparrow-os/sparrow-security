package com.sparrow.security.admin.repository;

import com.sparrow.security.protocol.admin.bo.GroupBO;
import com.sparrow.security.protocol.admin.param.GroupParam;

public interface GroupRepository {
    Long save(GroupParam groupParam);

    GroupBO getGroup(Long groupId);
}
