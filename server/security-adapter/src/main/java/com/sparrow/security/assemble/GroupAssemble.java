package com.sparrow.security.assemble;

import com.sparrow.security.protocol.vo.GroupVO;
import com.sparrow.security.protocol.bo.GroupBO;
import javax.inject.Named;

@Named
public class GroupAssemble {
    public GroupVO bo2Vo(GroupBO groupBo){
        return new GroupVO();
    }
}
