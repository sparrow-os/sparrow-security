package com.sparrow.security.infrastructure.persistence.admin.data.mapper;

import com.sparrow.protocol.LoginToken;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.po.Group;
import com.sparrow.security.protocol.admin.bo.GroupBO;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.utility.BeanUtility;
import javax.inject.Named;

@Named
public class GroupDataMapper {
    public Group toPo(GroupParam groupParam){
        Group group=new Group();
        BeanUtility.copyProperties(groupParam,group);
        LoginToken loginToken= ThreadContext.getLoginToken();
        group.setCreateUserId(loginToken.getUserId());
        group.setUpdateUserId(loginToken.getUserId());
        group.setCreateTime(System.currentTimeMillis());
        group.setUpdateTime(group.getCreateTime());
        group.setStatus(StatusRecord.ENABLE);
        group.setGroupLevel(0);
        return group;
    }

    public GroupBO toBo(Group group){
        //todo data mapper assemble
        GroupBO groupBo=null;
        return groupBo;
    }
}
