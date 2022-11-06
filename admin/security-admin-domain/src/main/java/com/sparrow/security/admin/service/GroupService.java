package com.sparrow.security.admin.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.repository.GroupRepository;
import com.sparrow.security.protocol.admin.enums.SecurityAdminError;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.security.protocol.admin.query.GroupQuery;
import com.sparrow.utility.StringUtility;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GroupService {
    @Inject
    private GroupRepository groupRepository;

    public Long saveGroup(GroupParam groupParam) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupParam.getGroupName()), SecurityAdminError.GROUP_NAME_IS_EMPTY);
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupParam.getGroupType()), SecurityAdminError.GROUP_TYPE_IS_EMPTY);
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupParam.getParentGroupId()), SecurityAdminError.GROUP_PARENT_ID_IS_EMPTY);
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupParam.getGroupIco()), SecurityAdminError.GROUP_NAME_ICON_EMPTY);
        return this.groupRepository.save(groupParam);
    }

    public void deleteGroup(Long groupId) throws BusinessException {
        Asserts.isTrue(groupId == null, SecurityAdminError.GROUP_ID_IS_EMPTY);
        this.groupRepository.delete(groupId);
    }

    public List<GroupBO> queryGroup(GroupQuery groupQuery) {
        return null;
    }

    public GroupBO getGroup(Long groupId) throws BusinessException {
        Asserts.isTrue(groupId == null, SecurityAdminError.GROUP_ID_IS_EMPTY);
        return this.groupRepository.getGroup(groupId);
    }
}
