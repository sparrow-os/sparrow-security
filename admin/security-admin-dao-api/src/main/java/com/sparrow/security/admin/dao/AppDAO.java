package com.sparrow.security.admin.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.admin.dao.query.app.CountAppQuery;
import com.sparrow.security.admin.dao.query.app.PagerAppQuery;
import com.sparrow.security.po.App;

import java.util.List;


public interface AppDAO extends DaoSupport<App, Long> {
    List<App> queryApps(PagerAppQuery appPagerQuery);

    Long countApp(CountAppQuery countAppQuery);

    List<App> queryAllEnableApps();
}
