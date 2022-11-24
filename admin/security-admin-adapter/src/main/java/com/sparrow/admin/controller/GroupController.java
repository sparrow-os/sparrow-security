package com.sparrow.admin.controller;

import com.sparrow.admin.assemble.GroupAssemble;
import com.sparrow.admin.protocol.admin.vo.GroupVO;
import com.sparrow.protocol.BusinessException;
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

@RestController
@RequestMapping("group")
@Named
public class GroupController {

    @Inject
    private GroupService groupService;

    @Inject
    private GroupAssemble groupControllerAssemble;

    @PostMapping("save.json")
    public Long saveGroup(@RequestBody GroupParam groupParam) throws BusinessException {
        return groupService.saveGroup(groupParam);
    }

    @GetMapping("get")
    public GroupVO getGroup(Long groupId) throws BusinessException {
        GroupBO groupBo = groupService.getGroup(groupId);
        return this.groupControllerAssemble.boAssembleVO(groupBo);
    }

    @PostMapping("del")
    public Boolean delGroup(String groupIds) throws BusinessException {
        groupService.deleteGroup(groupIds);
        return Boolean.TRUE;
    }

    @PostMapping("enable")
    public Boolean enableGroup(String groupIds) throws BusinessException {
        groupService.enableGroup(groupIds);
        return Boolean.TRUE;
    }

    @PostMapping("disable")
    public Boolean disableGroup(String groupIds) throws BusinessException {
        groupService.disableGroup(groupIds);
        return Boolean.TRUE;
    }
}
