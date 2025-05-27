package com.sparrow.security.admin.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.repository.GroupRepository;
import com.sparrow.security.admin.support.suffix.GroupSuffix;
import com.sparrow.security.admin.protocol.enums.SecurityAdminError;
import com.sparrow.security.admin.protocol.param.GroupParam;
import com.sparrow.security.admin.protocol.query.GroupQuery;
import com.sparrow.utility.StringUtility;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GroupService {
    @Inject
    private GroupRepository groupRepository;
    private void validateSaveGroup(GroupParam groupParam) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupParam.getGroupName()), SecurityAdminError.GROUP_NAME_IS_EMPTY, GroupSuffix.GROUP_NAME);
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupParam.getGroupType()), SecurityAdminError.GROUP_TYPE_IS_EMPTY);
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupParam.getGroupIco()), SecurityAdminError.GROUP_ICON_EMPTY, GroupSuffix.GROUP_ICON);
    }

    public Long saveGroup(GroupParam groupParam) throws BusinessException {
        this.validateSaveGroup(groupParam);
        return this.groupRepository.save(groupParam);
    }

    public Integer deleteGroup(String groupIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupIds), SecurityAdminError.GROUP_ID_IS_EMPTY);
        return this.groupRepository.delete(groupIds);
    }

    public Integer enableGroup(String groupIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupIds), SecurityAdminError.GROUP_ID_IS_EMPTY);
        return this.groupRepository.enable(groupIds);
    }

    public Integer disableGroup(String groupIds) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(groupIds), SecurityAdminError.GROUP_ID_IS_EMPTY);
        return this.groupRepository.disable(groupIds);
    }

    public ListRecordTotalBO<GroupBO> queryAllGroup() {
        return queryGroup(null);
    }

    public ListRecordTotalBO<GroupBO> queryGroup(GroupQuery groupQuery) {
        Long totalRecord = this.groupRepository.getGroupCount(groupQuery);
        List<GroupBO> groupBoList = null;
        if (totalRecord > 0) {
            groupBoList = this.groupRepository.queryGroups(groupQuery);
        }
        return new ListRecordTotalBO<>(groupBoList, totalRecord);
    }

    public GroupBO getGroup(Long groupId) throws BusinessException {
        Asserts.isTrue(groupId == null, SecurityAdminError.GROUP_ID_IS_EMPTY);
        return this.groupRepository.getGroup(groupId);
    }
}
