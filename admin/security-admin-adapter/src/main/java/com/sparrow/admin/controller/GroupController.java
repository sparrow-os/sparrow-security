package com.sparrow.admin.controller;

import com.sparrow.admin.assemble.GroupAssemble;
import com.sparrow.admin.protocol.admin.vo.GroupVO;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.bo.GroupListTotalRecordBO;
import com.sparrow.security.admin.service.GroupService;
import com.sparrow.security.protocol.admin.param.GroupParam;
import com.sparrow.security.protocol.admin.query.GroupBatchOperationQuery;
import com.sparrow.security.protocol.admin.query.GroupQuery;
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
        GroupBatchOperationQuery batchOperationQuery = (GroupBatchOperationQuery) ModelAndViewUtils.flash("query");
        if (batchOperationQuery != null) {
            return this.queryGroups(batchOperationQuery);
        }
        SimplePager simplePager = new SimplePager();
        GroupListTotalRecordBO groupListTotalRecord = this.groupService.queryAllGroup();
        HtmlPagerResult<GroupVO> pager = this.groupControllerAssemble.assembleHtmlPager(groupListTotalRecord, simplePager);
        ModelAndView mv = new ModelAndView("/group/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    private ModelAndView queryGroups(GroupQuery groupQuery) {
        GroupListTotalRecordBO groupListTotalRecord = this.groupService.queryGroup(groupQuery);
        HtmlPagerResult<GroupVO> pager = this.groupControllerAssemble.assembleHtmlPager(groupListTotalRecord, groupQuery);
        ModelAndView mv = new ModelAndView("/group/manage");
        mv.addObject("pager", pager);
        mv.addObject("query", groupQuery);
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
            this.servletContainer.getRequest().setAttribute("group", this.groupControllerAssemble.param2Vo(groupParam));
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
    public ModelAndView delGroup(GroupBatchOperationQuery batchOperationQuery) throws BusinessException {
        this.servletContainer.getRequest().setAttribute("query", batchOperationQuery);
        groupService.deleteGroup(batchOperationQuery.getGroupIds());
        return ModelAndViewUtils.redirect("/group/manage");
    }

    @PostMapping("enable")
    public ModelAndView enableGroup(GroupBatchOperationQuery batchOperationQuery) throws BusinessException {
        this.servletContainer.getRequest().setAttribute("query", batchOperationQuery);
        groupService.enableGroup(batchOperationQuery.getGroupIds());
        return ModelAndViewUtils.redirect("/group/manage");
    }

    @PostMapping("disable")
    public ModelAndView disableGroup(GroupBatchOperationQuery batchOperationQuery) throws BusinessException {
        this.servletContainer.getRequest().setAttribute("query", batchOperationQuery);
        groupService.disableGroup(batchOperationQuery.getGroupIds());
        return ModelAndViewUtils.redirect("/group/manage");
    }
}
