package com.sparrow.security.admin.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.security.protocol.admin.SecurityErrorCode;
import com.sparrow.security.protocol.admin.bo.GroupBO;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.security.protocol.admin.query.GroupQuery;
import com.sparrow.security.admin.repository.GroupRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GroupService {
    @Inject
    private GroupRepository groupRepository;
    public Long saveGroup(GroupParam groupParam) throws BusinessException {
        Asserts.isTrue(groupParam.getGroupName()==null, SecurityErrorCode.GROUP_NAME_IS_NUL);
        return this.groupRepository.save(groupParam);
    }

    public void deleteGroup(Long groupId) {

    }

    public List<GroupBO> queryGroup(GroupQuery groupQuery) {
        return null;
    }

    public GroupBO getGroup(Long groupId) {
        return this.groupRepository.getGroup(groupId);
    }
}
