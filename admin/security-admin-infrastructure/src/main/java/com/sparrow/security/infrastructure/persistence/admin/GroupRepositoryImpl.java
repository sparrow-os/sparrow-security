package com.sparrow.security.infrastructure.persistence.admin;

import com.sparrow.security.dao.admin.GroupDAO;
import com.sparrow.security.infrastructure.persistence.admin.data.mapper.GroupDataMapper;
import com.sparrow.security.po.Group;
import com.sparrow.security.admin.bo.GroupBO;
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
        Group group = this.groupDataMapper.param2po(groupParam);
        if (group.getGroupId() != null) {
            this.groupDao.update(group);
            return group.getGroupId();
        }
        return this.groupDao.insert(group);
    }

    @Override public Integer delete(Long groupId) {
        return this.groupDao.delete(groupId);
    }

    @Override public GroupBO getGroup(Long groupId) {
        Group group = this.groupDao.getEntity(groupId);
        return this.groupDataMapper.toBo(group);
    }
}