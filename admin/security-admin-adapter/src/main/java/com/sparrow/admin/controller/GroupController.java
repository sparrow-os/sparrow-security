package com.sparrow.admin.controller;

import com.sparrow.admin.assemble.GroupAssemble;
import com.sparrow.admin.protocol.admin.vo.GroupVO;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.service.GroupService;
import com.sparrow.security.protocol.admin.param.GroupParam;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("group")
@Named
public class GroupController {

    @Inject
    private GroupService groupService;

    @Inject
    private GroupAssemble groupControllerAssemble;

    @PostMapping("save-group")
    public Result<Long> saveGroup(@RequestBody GroupParam groupParam) throws BusinessException {
        Long groupId = groupService.saveGroup(groupParam);
        return new Result<>(groupId);
    }

    @GetMapping("get-group")
    public GroupVO getGroup(Long groupId) throws BusinessException {
        GroupBO groupBo = groupService.getGroup(groupId);
        return this.groupControllerAssemble.boAssembleVO(groupBo);
    }

    @PostMapping("del-group")
    public Result<Boolean> delGroup(Long groupId) throws BusinessException {
        groupService.deleteGroup(groupId);
        return Result.success();
    }

    public ModelAndView saveGroupView(GroupParam groupParam) throws BusinessException {
        Long groupId = groupService.saveGroup(groupParam);
        return new ModelAndView("redirect:/group");
    }
}
