package com.sparrow.security.admin.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.assemble.RoleAssemble;
import com.sparrow.security.admin.bo.RoleBO;
import com.sparrow.security.admin.protocol.param.RoleParam;
import com.sparrow.security.admin.protocol.param.batch.RoleBatchOperateParam;
import com.sparrow.security.admin.protocol.query.RoleQuery;
import com.sparrow.security.admin.protocol.vo.RoleVO;
import com.sparrow.security.admin.service.RoleService;
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
@RequestMapping("role")
public class RoleController {
    @Inject
    private RoleService roleService;
    @Inject
    private RoleAssemble roleAssemble;
    @Inject
    private ServletContainer servletContainer;

    @GetMapping("manage")
    public ModelAndView loadAllRole() {
        RoleBatchOperateParam batchOperationQuery = (RoleBatchOperateParam) ModelAndViewUtils.flash("query");
        if (batchOperationQuery != null) {
            return this.queryRoles(batchOperationQuery);
        }
        SimplePager simplePager = new SimplePager();
        ListRecordTotalBO<RoleBO> roleListRecordTotal = this.roleService.queryAllRole();
        HtmlPagerResult<RoleVO> pager = this.roleAssemble.assembleHtmlPager(roleListRecordTotal, simplePager);
        ModelAndView mv = new ModelAndView("/role/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    private ModelAndView queryRoles(RoleQuery roleQuery) {
        ListRecordTotalBO<RoleBO> roleListTotalRecord = this.roleService.queryRole(roleQuery);
        HtmlPagerResult<RoleVO> pager = this.roleAssemble.assembleHtmlPager(roleListTotalRecord, roleQuery);
        ModelAndView mv = new ModelAndView("/role/manage");
        mv.addObject("pager", pager);
        mv.addObject("query", roleQuery);
        return mv;
    }

    @PostMapping("search.do")
    public ModelAndView search(RoleQuery roleQuery) {
        return this.queryRoles(roleQuery);
    }

    @PostMapping("save")
    public ModelAndView saveRole(RoleParam roleParam) throws BusinessException {
        try {
            roleParam.setSort(1);
            roleService.saveRole(roleParam);
            return ModelAndViewUtils.redirect("/role/manage");
        } catch (Exception e) {
            //失败回显
            this.servletContainer.getRequest().setAttribute("role", this.roleAssemble.paramAssembleVO(roleParam));
            throw e;
        }
    }

    @GetMapping("new")
    public ModelAndView getRole(Long roleId) throws BusinessException {
        ModelAndView mv = new ModelAndView("/role/new");
        if (roleId == null) {
            return mv;
        }
        RoleBO roleBO = roleService.getRole(roleId);
        RoleVO roleVo = this.roleAssemble.boAssembleVO(roleBO);
        mv.addObject("role", roleVo);
        return mv;
    }

    @PostMapping("delete")
    public ModelAndView delRole(RoleBatchOperateParam roleBatchOperationQuery) throws BusinessException {
        this.servletContainer.getRequest().setAttribute("query", roleBatchOperationQuery);
        roleService.deleteRole(roleBatchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/role/manage");
    }

    @PostMapping("enable")
    public ModelAndView enableRole(RoleBatchOperateParam roleBatchOperationQuery) throws BusinessException {
        this.servletContainer.getRequest().setAttribute("query", roleBatchOperationQuery);
        roleService.enableRole(roleBatchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/role/manage");
    }

    @PostMapping("disable")
    public ModelAndView disableGroup(RoleBatchOperateParam roleBatchOperationQuery) throws BusinessException {
        this.servletContainer.getRequest().setAttribute("query", roleBatchOperationQuery);
        roleService.disableRole(roleBatchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/role/manage");
    }
}
