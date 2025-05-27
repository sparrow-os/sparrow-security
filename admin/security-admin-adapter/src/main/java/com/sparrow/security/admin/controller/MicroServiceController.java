package com.sparrow.security.admin.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.security.admin.assemble.MicroServiceAssemble;
import com.sparrow.security.admin.bo.MicroServiceBO;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.protocol.param.batch.MicroServiceBatchOperateParam;
import com.sparrow.security.admin.protocol.query.MicroServiceQuery;
import com.sparrow.security.admin.protocol.vo.MicroServiceVO;
import com.sparrow.security.admin.service.MicroServiceService;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.spring.starter.ModelAndViewUtils;
import com.sparrow.support.pager.HtmlPagerResult;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("micro/service")
public class MicroServiceController {

    @Inject
    private MicroServiceService microServiceService;

    @Inject
    private MicroServiceAssemble microServiceAssemble;

    @Inject
    private ServletContainer servletContainer;

    @GetMapping("manage")
    public ModelAndView loadAllMicroServices() {
        MicroServiceBatchOperateParam batchOperateParam = (MicroServiceBatchOperateParam) ModelAndViewUtils.flash("query");
        if (batchOperateParam != null) {
            return this.queryMicroServices(batchOperateParam);
        }
        SimplePager simplePager = new SimplePager();
        ListRecordTotalBO<MicroServiceBO> microServiceListTotalRecord = this.microServiceService.queryAllMicroService();
        HtmlPagerResult<MicroServiceVO> pager = this.microServiceAssemble.assembleHtmlPager(microServiceListTotalRecord, simplePager);
        ModelAndView mv = new ModelAndView("/micro/service/manage");
        mv.addObject("pager", pager);
        return mv;
    }

    private ModelAndView queryMicroServices(MicroServiceQuery microServiceQuery) {
        ListRecordTotalBO<MicroServiceBO> microServiceListTotalRecord = this.microServiceService.queryMicroService(microServiceQuery);
        HtmlPagerResult<MicroServiceVO> pager = this.microServiceAssemble.assembleHtmlPager(microServiceListTotalRecord, microServiceQuery);
        ModelAndView mv = new ModelAndView("/micro-service/manage");
        mv.addObject("pager", pager);
        mv.addObject("query", microServiceQuery);
        return mv;
    }

    @PostMapping("search.do")
    public ModelAndView search(MicroServiceQuery microServiceQuery) {
        return this.queryMicroServices(microServiceQuery);
    }

    @PostMapping("save")
    public ModelAndView saveMicroService(@RequestBody MicroServiceParam microServiceParam) throws BusinessException {
        return null;
        //        try {
//            microServiceService.saveMicroService(microServiceParam);
//            return ModelAndViewUtils.redirect("/micro-service/manage");
//        } catch (Exception e) {
//            //失败回显
//            this.servletContainer.getRequest().setAttribute("microService", this.microServiceAssemble.paramAssembleVO(microServiceParam));
//            throw e;
//        }
    }

    @GetMapping("new")
    public ModelAndView getMicroService(Long microServiceId) throws BusinessException {
        ModelAndView mv = new ModelAndView("/micro/service/new");
        if (microServiceId == null) {
            return mv;
        }
        MicroServiceBO microServiceBo = this.microServiceService.getMicroService(microServiceId);
        MicroServiceVO microServiceVO = this.microServiceAssemble.boAssembleVO(microServiceBo);
        mv.addObject("microService", microServiceVO);
        return mv;
    }

    @PostMapping("delete")
    public Integer deleteMicroService(String microServiceIds) throws BusinessException {
        return this.microServiceService.deleteMicroService(microServiceIds);
    }

    @PostMapping("enable")
    public Integer enableMicroService(String microServiceIds) throws BusinessException {
        return this.microServiceService.enableMicroService(microServiceIds);
    }

    @PostMapping("disable")
    public Integer disableMicroService(String microServiceIds) throws BusinessException {
        return this.microServiceService.disableMicroService(microServiceIds);
    }
}