package com.sparrow.security.admin.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.assemble.GroupAssemble;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.protocol.param.GroupParam;
import com.sparrow.security.admin.protocol.param.batch.GroupBatchOperateParam;
import com.sparrow.security.admin.protocol.query.GroupQuery;
import com.sparrow.security.admin.protocol.vo.GroupVO;
import com.sparrow.security.admin.service.GroupService;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.spring.starter.ModelAndViewUtils;
import com.sparrow.support.pager.HtmlPagerResult;

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
    @Inject
    private ServletContainer servletContainer;

    @GetMapping("manage")
    public ModelAndView loadAllGroups() {
        GroupBatchOperateParam groupBatchOperateParam = (GroupBatchOperateParam) ModelAndViewUtils.flash("query");
        return this.queryGroups(groupBatchOperateParam);
    }

    private ModelAndView queryGroups(GroupQuery groupQuery) {
        ListRecordTotalBO<GroupBO> groupListTotalRecord = this.groupService.queryGroup(groupQuery);
        HtmlPagerResult<GroupVO> pager = this.groupControllerAssemble.assembleHtmlPager(groupListTotalRecord, groupQuery);
        ModelAndView mv = new ModelAndView("/group/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    @PostMapping("search.do")
    public ModelAndView search(GroupQuery groupQuery) {
        return this.queryGroups(groupQuery);
    }

    @PostMapping("save")
    public ModelAndView saveGroup(GroupParam groupParam) throws BusinessException {
        try {
            groupParam.setGroupType("default");//预留后续使用
            groupService.saveGroup(groupParam);
            return ModelAndViewUtils.redirect("/group/manage");
        } catch (Exception e) {
            //失败回显
            this.servletContainer.getRequest().setAttribute("group", this.groupControllerAssemble.paramAssembleVO(groupParam));
            throw e;
        }
    }

    @GetMapping("new")
    public ModelAndView getGroup(Long groupId) throws BusinessException {
        ModelAndView mv = new ModelAndView("/group/new");
        if (groupId == null) {
            return mv;
        }
        GroupBO groupBo = groupService.getGroup(groupId);
        GroupVO groupVo = this.groupControllerAssemble.boAssembleVO(groupBo);
        mv.addObject("group", groupVo);
        return mv;
    }

    @PostMapping("delete")
    public ModelAndView delGroup(GroupBatchOperateParam batchOperateParam) throws BusinessException {
        this.servletContainer.getRequest().setAttribute("query", batchOperateParam);
        groupService.deleteGroup(batchOperateParam.getIds());
        return ModelAndViewUtils.redirect("/group/manage");
    }

    @PostMapping("enable")
    public ModelAndView enableGroup(GroupBatchOperateParam batchOperateParam) throws BusinessException {
        this.servletContainer.getRequest().setAttribute("query", batchOperateParam);
        groupService.enableGroup(batchOperateParam.getIds());
        return ModelAndViewUtils.redirect("/group/manage");
    }

    @PostMapping("disable")
    public ModelAndView disableGroup(GroupBatchOperateParam batchOperateParam) throws BusinessException {
        this.servletContainer.getRequest().setAttribute("query", batchOperateParam);
        groupService.disableGroup(batchOperateParam.getIds());
        return ModelAndViewUtils.redirect("/group/manage");
    }
}
