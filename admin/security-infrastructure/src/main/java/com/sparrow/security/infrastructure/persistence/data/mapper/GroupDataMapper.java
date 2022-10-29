package com.sparrow.security.infrastructure.persistence.data.mapper;

import com.sparrow.security.po.Group;
import com.sparrow.security.protocol.bo.GroupBO;
import com.sparrow.security.protocol.param.GroupParam;
import javax.inject.Named;

@Named
public class GroupDataMapper {
    public Group toPo(GroupParam groupParam){
        //todo data mapper assemble
        Group group=null;
        return group;
    }

    public GroupBO toBo(Group group){
        //todo data mapper assemble
        GroupBO groupBo=null;
        return groupBo;
    }
}
