package com.sparrow.security.controller.assemble;

import com.sparrow.security.controller.protocol.vo.GroupVO;
import com.sparrow.security.protocol.bo.GroupBO;
import javax.inject.Named;

@Named
public class GroupControllerAssemble {
    public GroupVO bo2Vo(GroupBO groupBo){
        return new GroupVO();
    }
}
