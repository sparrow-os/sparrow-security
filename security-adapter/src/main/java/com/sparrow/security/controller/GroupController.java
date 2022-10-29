package com.sparrow.security.controller;

import com.sparrow.protocol.Result;
import com.sparrow.security.protocol.param.GroupParam;
import com.sparrow.security.service.GroupService;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.web.servlet.ModelAndView;

@Named
public class GroupController {
    
    @Inject
    private GroupService groupService;

    public Result<Long> saveGroup(GroupParam groupParam) {
        Long groupId = groupService.saveGroup(groupParam);
        return new Result<>(groupId);
    }

    public ModelAndView saveGroupView(GroupParam groupParam) {
        Long groupId = groupService.saveGroup(groupParam);
        ModelAndView mv = new ModelAndView("redirect:/group");
        return mv;
    }
}
