package com.sparrow.security.infrastructure.persistence.admin.data.mapper;

import com.sparrow.protocol.LoginToken;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.po.Group;
import com.sparrow.security.protocol.admin.bo.GroupBO;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.utility.BeanUtility;
import java.util.List;
import javax.inject.Named;

@Named
public class GroupDataMapper implements Param2POConverter<GroupParam, Group>, PO2BOConverter<GroupBO, Group> {
    public GroupBO toBo(Group group) {
        return null;
    }

    @Override public Group param2po(GroupParam param) {
        Group group = new Group();
        BeanUtility.copyProperties(param, group);
        LoginToken loginToken =new LoginToken();
        loginToken.setUserId(1L);
        // ThreadContext.getLoginToken();
        group.setCreateUserId(loginToken.getUserId());
        group.setUpdateUserId(loginToken.getUserId());
        group.setCreateTime(System.currentTimeMillis());
        group.setUpdateTime(group.getCreateTime());
        group.setStatus(StatusRecord.ENABLE);
        group.setGroupLevel(0);
        return group;
    }

    @Override public GroupBO po2bo(Group group) {
        return null;
    }

    @Override public List<GroupBO> poList2BoList(List<Group> list) {
        return null;
    }
}
