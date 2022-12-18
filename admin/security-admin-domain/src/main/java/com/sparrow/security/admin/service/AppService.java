package com.sparrow.security.admin.service;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.admin.bo.GroupBO;
import com.sparrow.security.admin.protocol.query.AppQuery;
import com.sparrow.security.admin.protocol.query.GroupQuery;
import com.sparrow.security.admin.repository.AppRepository;
import com.sparrow.security.admin.protocol.param.AppParam;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AppService {
    @Inject
    private AppRepository appRepository;

    public ListRecordTotalBO<AppBO> queryAllApp() {
        return queryApp(null);
    }

    public ListRecordTotalBO<AppBO> queryApp(AppQuery appQuery) {
        Long totalRecord = this.appRepository.getAppCount(appQuery);
        List<AppBO> appBoList = null;
        if (totalRecord > 0) {
            appBoList = this.appRepository.queryApps(appQuery);
        }
        return new ListRecordTotalBO<>(appBoList, totalRecord);
    }

    public Long saveApp(AppParam appParam) throws BusinessException {
        return this.appRepository.save(appParam);
    }

    public AppBO getApp(Long appId) throws BusinessException {
        return this.appRepository.getApp(appId);
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

    public List<AppBO> queryAllEnableApps() {
        return this.appRepository.queryAllEnableApps();
    }

}
