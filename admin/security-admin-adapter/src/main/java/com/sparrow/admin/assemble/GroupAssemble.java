package com.sparrow.admin.assemble;

import com.sparrow.admin.protocol.admin.vo.GroupVO;
import com.sparrow.security.protocol.admin.bo.GroupBO;
import com.sparrow.support.assemble.BO2VOAssemble;
import com.sparrow.utility.BeanUtility;
import java.util.List;
import javax.inject.Named;

@Named
public class GroupAssemble implements BO2VOAssemble<GroupVO, GroupBO> {

    @Override public GroupVO boAssembleVO(GroupBO bo) {
        GroupVO group = new GroupVO();
        BeanUtility.copyProperties(bo, group);
        return group;
    }

    @Override public List<GroupVO> boListAssembleVOList(List<GroupBO> list) {
        return null;
    }
}
