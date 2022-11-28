package com.sparrow.admin.controller;

import com.sparrow.admin.assemble.AppAssemble;
import com.sparrow.admin.protocol.admin.vo.AppVO;
import com.sparrow.protocol.BusinessException;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.admin.service.AppService;
import com.sparrow.security.protocol.admin.param.AppParam;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class AppController {

    @Inject
    private AppService appService;

    @Inject
    private AppAssemble appControllerAssemble;

    @PostMapping("save")
    public Long saveApp(AppParam appParam) throws BusinessException {
        return this.appService.saveApp(appParam);
    }

    @GetMapping("get")
    public AppVO getApp(Long groupId) throws BusinessException {
        AppBO appBo = this.appService.getApp(groupId);
        return this.appControllerAssemble.boAssembleVO(appBo);
    }

    @PostMapping("del")
    public Integer delApp(String appIds) throws BusinessException {
        return this.appService.delApp(appIds);
    }

    @PostMapping("enable")
    public Integer enableApp(String appIds) throws BusinessException {
        return this.appService.enableApp(appIds);
    }

    @PostMapping("disable")
    public Integer disableApp(String appIds) throws BusinessException {
        return this.appService.disableApp(appIds);
    }
}
