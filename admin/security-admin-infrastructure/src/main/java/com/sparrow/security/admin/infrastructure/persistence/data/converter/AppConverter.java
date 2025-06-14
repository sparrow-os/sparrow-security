package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.protocol.dao.DatabasePagerQuery;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.admin.dao.query.app.CountAppQuery;
import com.sparrow.security.admin.dao.query.app.PagerAppQuery;
import com.sparrow.security.admin.protocol.param.AppParam;
import com.sparrow.security.admin.protocol.query.AppQuery;
import com.sparrow.security.po.App;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.utility.BeanUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named
public class AppConverter implements Param2POConverter<AppParam, App>, PO2BOConverter<AppBO, App> {
    public PagerAppQuery toDbPagerQuery(AppQuery appQuery) {
        if (appQuery == null) {
            return new PagerAppQuery();
        }
        DatabasePagerQuery pagerQuery = new DatabasePagerQuery(appQuery.getPageSize(), appQuery.getPageNo());
        PagerAppQuery pagerGroupQuery = new PagerAppQuery();
        this.fullProperties(appQuery, pagerGroupQuery);
        pagerGroupQuery.setPager(pagerQuery);
        return pagerGroupQuery;
    }

    private void fullProperties(AppQuery appQuery, CountAppQuery dbQuery) {
        if (appQuery == null) {
            return;
        }
        BeanUtility.copyProperties(appQuery,dbQuery);
        if (appQuery.getStatus() != null) {
            dbQuery.setStatus(StatusRecord.valueOf(appQuery.getStatus()));
        }
    }

    public CountAppQuery toDbCountQuery(AppQuery appQuery) {
        CountAppQuery countAppQuery = new CountAppQuery();
        if (appQuery == null) {
            return countAppQuery;
        }
        this.fullProperties(appQuery, countAppQuery);
        return countAppQuery;
    }

    public AppBO toBo(App app) {
        AppBO appBo = new AppBO();
        BeanUtility.copyProperties(app, appBo);
        return appBo;
    }

    @Override public App param2po(AppParam param) {
        App app = new App();
        BeanUtility.copyProperties(param, app);
        app.setGmtCreate(System.currentTimeMillis());
        app.setGmtModified(app.getGmtCreate());
        app.setCreateUserId(0L);
        app.setModifiedUserId(0L);
        app.setStatus(StatusRecord.ENABLE);
        if (app.getRemark() == null) {
            app.setRemark("");
        }
        return app;
    }

    @Override public AppBO po2bo(App app) {
        AppBO appBO = new AppBO();
        BeanUtility.copyProperties(app, appBO);
        return appBO;
    }

    @Override public List<AppBO> poList2BoList(List<App> list) {
        List<AppBO> appBos = new ArrayList<>(list.size());
        for (App app : list) {
            appBos.add(this.po2bo(app));
        }
        return appBos;
    }
}
