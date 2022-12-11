package com.sparrow.security.admin.service;

import com.sparrow.protocol.BusinessException;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.admin.repository.AppRepository;
import com.sparrow.security.admin.protocol.param.AppParam;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AppService {
    @Inject
    private AppRepository appRepository;

    public Long saveApp(AppParam appParam) throws BusinessException {
        //todo
        return this.appRepository.save(appParam);
    }

    public AppBO getApp(Long appId) throws BusinessException {
        return this.getApp(appId);
    }

    public int delApp(String appIds) throws BusinessException {
        return this.appRepository.delete(appIds);
    }

    public int enableApp(String appIds) throws BusinessException {
        return this.appRepository.enable(appIds);
    }

    public int disableApp(String appIds) throws BusinessException {
        return this.appRepository.disable(appIds);
    }
}
