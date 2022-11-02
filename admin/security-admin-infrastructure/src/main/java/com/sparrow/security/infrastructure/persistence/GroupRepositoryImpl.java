package com.sparrow.security.infrastructure.persistence;

import com.sparrow.security.dao.GroupDAO;
import com.sparrow.security.infrastructure.persistence.data.mapper.GroupDataMapper;
import com.sparrow.security.po.Group;
import com.sparrow.security.protocol.bo.GroupBO;
import com.sparrow.security.protocol.param.GroupParam;
import com.sparrow.security.repository.GroupRepository;
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