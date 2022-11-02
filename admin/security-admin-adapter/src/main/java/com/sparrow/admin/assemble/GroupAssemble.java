package com.sparrow.admin.assemble;

import com.sparrow.admin.protocol.admin.vo.GroupVO;
import com.sparrow.security.protocol.admin.bo.GroupBO;
import javax.inject.Named;

@Named
public class GroupAssemble {
    public GroupVO bo2Vo(GroupBO groupBo){
        return new GroupVO();
    }
}
