package com.sparrow.security.admin.repository;

import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.admin.protocol.param.AppParam;
import com.sparrow.security.admin.protocol.query.AppQuery;

import java.util.List;

public interface AppRepository {
    Long save(AppParam appParam);

    int delete(String appIds);

    int disable(String appIds);

    int enable(String appIds);

    AppBO getApp(Long appId);

    List<AppBO> queryApps(AppQuery appQuery);

    List<AppBO> queryAllEnableApps();

    Long getAppCount(AppQuery appQuery);

}
