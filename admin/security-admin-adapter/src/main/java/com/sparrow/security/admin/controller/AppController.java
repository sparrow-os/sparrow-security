package com.sparrow.security.admin.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.TreeItem;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.assemble.AppAssemble;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.admin.protocol.param.AppParam;
import com.sparrow.security.admin.protocol.param.batch.AppBatchOperateParam;
import com.sparrow.security.admin.protocol.query.AppQuery;
import com.sparrow.security.admin.protocol.vo.AppVO;
import com.sparrow.security.admin.service.AppService;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.spring.starter.ModelAndViewUtils;
import com.sparrow.support.pager.HtmlPagerResult;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("app")
public class AppController {

    @Inject
    private AppService appService;

    @Inject
    private AppAssemble appAssemble;

    @Inject
    private ServletContainer servletContainer;

    @GetMapping("manage")
    public ModelAndView loadAllApps() {
        AppBatchOperateParam batchOperationQuery = ModelAndViewUtils.query();
        if (batchOperationQuery != null) {
            return this.queryApps(batchOperationQuery);
        }
        SimplePager simplePager = new SimplePager();
        ListRecordTotalBO<AppBO> groupListTotalRecord = this.appService.queryAllApp();
        HtmlPagerResult<AppVO> pager = this.appAssemble.assembleHtmlPager(groupListTotalRecord, simplePager);
        ModelAndView mv = new ModelAndView("/app/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    private ModelAndView queryApps(AppQuery appQuery) {
        ListRecordTotalBO<AppBO> groupListTotalRecord = this.appService.queryApp(appQuery);
        HtmlPagerResult<AppVO> pager = this.appAssemble.assembleHtmlPager(groupListTotalRecord, appQuery);
        ModelAndView mv = new ModelAndView("/app/manage");
        mv.addObject("pager", pager);
        mv.addObject("query", appQuery);
        return mv;
    }

    @PostMapping("search.do")
    public ModelAndView search(AppQuery appQuery) {
        return this.queryApps(appQuery);
    }

    @PostMapping("tooltip.json")
    public List<TreeItem> tooltip() {
        List<AppBO> appBos = this.appService.queryAllEnableApps();
        return this.appAssemble.toTreeItemList(appBos);
    }

    @PostMapping("save")
    public ModelAndView saveApp(AppParam appParam) throws BusinessException {
        try {
            this.appService.saveApp(appParam);
            return ModelAndViewUtils.redirect("/app/manage");
        } catch (Exception e) {
            this.servletContainer.getRequest().setAttribute("app", this.appAssemble.paramAssembleVO(appParam));
            throw e;
        }
    }

    @GetMapping("edit")
    public ModelAndView getApp(Long appId) throws BusinessException {
        ModelAndView mv = new ModelAndView("/app/new");
        if (appId == null) {
            return mv;
        }
        AppBO appBo = appService.getApp(appId);
        AppVO appVo = this.appAssemble.boAssembleVO(appBo);
        mv.addObject("app", appVo);
        return mv;
    }

    @PostMapping("delete")
    public ModelAndView delApp(AppBatchOperateParam batchOperationQuery) throws BusinessException {
        this.appService.delApp(batchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/app/manage", batchOperationQuery);
    }

    @PostMapping("enable")
    public ModelAndView enableApp(AppBatchOperateParam batchOperationQuery) throws BusinessException {
        this.appService.enableApp(batchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/app/manage", batchOperationQuery);
    }

    @PostMapping("disable")
    public ModelAndView disableApp(AppBatchOperateParam batchOperationQuery) throws BusinessException {
        this.appService.disableApp(batchOperationQuery.getIds());
        return ModelAndViewUtils.redirect("/app/manage", batchOperationQuery);
    }
}
