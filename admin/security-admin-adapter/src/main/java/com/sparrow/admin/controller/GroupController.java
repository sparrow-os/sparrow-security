package com.sparrow.admin.controller;

import com.sparrow.admin.assemble.GroupAssemble;
import com.sparrow.admin.protocol.admin.vo.GroupVO;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.service.GroupService;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.security.protocol.admin.query.GroupQuery;
import com.sparrow.spring.starter.ModelAndViewUtils;
import com.sparrow.support.pager.SparrowPagerResult;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("group")
public class GroupController {
    @Inject
    private GroupService groupService;
    @Inject
    private GroupAssemble groupControllerAssemble;

    @GetMapping("manage")
    public ModelAndView loadGroupList() throws BusinessException {
        List<GroupVO> groupList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            GroupVO group = new GroupVO();
            group.setGroupId((long) i);
            group.setGroupName("group name " + i);
            group.setMaxAllowCount(100L);
            group.setGroupType("");
            group.setGroupIco("http://r.sparrowzoo.net/images/logo.png");
            group.setStatus("正常");
            groupList.add(group);
        }

        ModelAndView mv = new ModelAndView("/group/manage");
        PagerResult<GroupVO, Void> pagerResult = new PagerResult<>();
        pagerResult.setList(groupList);
        pagerResult.setRecordCount(100000L);
        pagerResult.setCurrentPageIndex(1);
        pagerResult.setPageSize(10);
        SparrowPagerResult<GroupVO, Void> pager = new SparrowPagerResult<>(pagerResult);
        mv.addObject("pager", pager);
        return mv;
    }

    @PostMapping("search.do")
    public ModelAndView queryGroup(GroupQuery groupQuery) throws BusinessException {
        List<GroupVO> groupList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            GroupVO group = new GroupVO();
            group.setGroupId((long) i);
            group.setGroupName("group name " + i);
            group.setMaxAllowCount(100L);
            group.setGroupType("");
            group.setGroupIco("http://r.sparrowzoo.net/images/logo.png");
            group.setStatus("正常");
            groupList.add(group);
        }

        ModelAndView mv = new ModelAndView("/group/manage");
        PagerResult<GroupVO, Void> pagerResult = new PagerResult<>();
        pagerResult.setList(groupList);
        pagerResult.setRecordCount(100000L);
        pagerResult.setCurrentPageIndex(groupQuery.getCurrentPageIndex());
        pagerResult.setPageSize(10);
        SparrowPagerResult<GroupVO, Void> pager = new SparrowPagerResult<>(pagerResult);
        mv.addObject("pager", pager);
        return mv;
    }

    @PostMapping("save")
    public ModelAndView saveGroup(GroupParam groupParam) throws BusinessException {
        groupParam.setGroupType("default");//预留后续使用
        groupService.saveGroup(groupParam);
        return ModelAndViewUtils.redirect("/group/manage");
    }

    @GetMapping("new")
    public ModelAndView getGroup(Long groupId) throws BusinessException {
        ModelAndView mv = new ModelAndView("/group/new");
        if(groupId==null){
            return mv;
        }
        GroupBO groupBo = groupService.getGroup(groupId);
        GroupVO groupVo = this.groupControllerAssemble.boAssembleVO(groupBo);
        mv.addObject("group", groupVo);
        return mv;
    }

    @PostMapping("del")
    public Integer delGroup(String groupIds) throws BusinessException {
        return groupService.deleteGroup(groupIds);
    }

    @PostMapping("enable")
    public Integer enableGroup(String groupIds) throws BusinessException {
        return groupService.enableGroup(groupIds);
    }

    @PostMapping("disable")
    public Integer disableGroup(String groupIds) throws BusinessException {
        return groupService.disableGroup(groupIds);
    }
}
