package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.GroupDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.GroupConverter;
import com.sparrow.security.po.Group;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.protocol.param.GroupParam;
import com.sparrow.security.admin.repository.GroupRepository;
import com.sparrow.security.admin.protocol.query.GroupQuery;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GroupRepositoryImpl implements GroupRepository {
    @Inject
    private GroupConverter groupConverter;

    @Inject
    private GroupDAO groupDao;

    @Override public Long save(GroupParam groupParam) {
        Group group = this.groupConverter.param2po(groupParam);
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
        return this.groupConverter.po2bo(group);
    }

    @Override public List<GroupBO> queryGroups(GroupQuery groupQuery) {
        List<Group> groupList = this.groupDao.queryGroups(this.groupConverter.toDbPagerQuery(groupQuery));
        return this.groupConverter.poList2BoList(groupList);
    }

    @Override public Long getGroupCount(GroupQuery groupQuery) {
        return this.groupDao.countGroup(this.groupConverter.toDbCountQuery(groupQuery));
    }
}