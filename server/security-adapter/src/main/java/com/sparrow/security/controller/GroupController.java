package com.sparrow.security.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import com.sparrow.security.assemble.GroupAssemble;
import com.sparrow.security.protocol.vo.GroupVO;
import com.sparrow.security.protocol.bo.GroupBO;
import com.sparrow.security.protocol.param.GroupParam;
import com.sparrow.security.service.GroupService;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.web.servlet.ModelAndView;

@Named
public class GroupController {

    @Inject
    private GroupService groupService;

    @Inject
    private GroupAssemble groupControllerAssemble;

    public Result<Long> saveGroup(GroupParam groupParam) throws BusinessException {
        Long groupId = groupService.saveGroup(groupParam);
        return new Result<>(groupId);
    }

    public GroupVO getGroup(Long groupId) {
        GroupBO groupBo = groupService.getGroup(groupId);
        return this.groupControllerAssemble.bo2Vo(groupBo);
    }

    public ModelAndView saveGroupView(GroupParam groupParam) throws BusinessException {
        Long groupId = groupService.saveGroup(groupParam);
        ModelAndView mv = new ModelAndView("redirect:/group");
        return mv;
    }
}
