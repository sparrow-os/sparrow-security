package com.sparrow.security.repository;

import com.sparrow.security.protocol.param.GroupParam;

public interface GroupRepository {
    Long save(GroupParam groupParam);
}
