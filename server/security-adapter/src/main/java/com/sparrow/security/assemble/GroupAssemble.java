package com.sparrow.security.assemble;

import com.sparrow.security.protocol.admin.vo.GroupVO;
import com.sparrow.security.protocol.bo.GroupBO;
import javax.inject.Named;

@Named
public class GroupAssemble {
    public GroupVO bo2Vo(GroupBO groupBo){
        return new GroupVO();
    }
}
