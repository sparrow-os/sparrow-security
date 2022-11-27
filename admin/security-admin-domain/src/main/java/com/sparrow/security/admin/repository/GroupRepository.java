package com.sparrow.security.admin.repository;

import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.security.protocol.admin.query.GroupQuery;
import java.util.List;

public interface GroupRepository {
    Long save(GroupParam groupParam);

    int delete(String groupIds);

    int disable(String groupIds);

    int enable(String groupIds);

    GroupBO getGroup(Long groupId);

    List<GroupBO> queryGroups(GroupQuery groupQuery);

    Long getGroupCount(GroupQuery groupQuery);

}
