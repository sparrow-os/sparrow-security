package com.sparrow.security.admin.repository;

import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.protocol.admin.param.GroupParam;

public interface GroupRepository {
    Long save(GroupParam groupParam);

    Integer delete(Long groupId);

    GroupBO getGroup(Long groupId);
}
