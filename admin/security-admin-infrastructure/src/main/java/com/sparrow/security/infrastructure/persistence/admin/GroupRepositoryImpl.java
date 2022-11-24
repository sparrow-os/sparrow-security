package com.sparrow.security.infrastructure.persistence.admin;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.dao.admin.GroupDAO;
import com.sparrow.security.infrastructure.persistence.admin.data.converter.GroupConverter;
import com.sparrow.security.po.Group;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.security.admin.repository.GroupRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GroupRepositoryImpl implements GroupRepository {
    @Inject
    private GroupConverter groupDataMapper;

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

    @Override public int delete(String groupIds) {
        StatusCriteria statusCriteria = new StatusCriteria(groupIds, StatusRecord.DESTROYED);
        return this.groupDao.changeStatus(statusCriteria);
    }

    @Override public int disable(String groupIds) {
        StatusCriteria statusCriteria = new StatusCriteria(groupIds, StatusRecord.DISABLE);
        return this.groupDao.changeStatus(statusCriteria);
    }

    @Override public int enable(String groupIds) {
        StatusCriteria statusCriteria = new StatusCriteria(groupIds, StatusRecord.ENABLE);
        return this.groupDao.changeStatus(statusCriteria);
    }

    @Override public GroupBO getGroup(Long groupId) {
        Group group = this.groupDao.getEntity(groupId);
        return this.groupDataMapper.toBo(group);
    }
}