package com.sparrow.security.infrastructure.persistence.admin;

import com.sparrow.security.dao.admin.GroupDAO;
import com.sparrow.security.infrastructure.persistence.admin.data.mapper.GroupDataMapper;
import com.sparrow.security.po.Group;
import com.sparrow.security.protocol.admin.bo.GroupBO;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.security.admin.repository.GroupRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GroupRepositoryImpl implements GroupRepository {
    @Inject
    private GroupDataMapper groupDataMapper;

    @Inject
    private GroupDAO groupDao;

    @Override public Long save(GroupParam groupParam) {
        Group group = this.groupDataMapper.toPo(groupParam);
        return this.groupDao.insert(group);
    }

    @Override public GroupBO getGroup(Long groupId) {
        Group group = this.groupDao.getEntity(groupId);
        return this.groupDataMapper.toBo(group);
    }
}